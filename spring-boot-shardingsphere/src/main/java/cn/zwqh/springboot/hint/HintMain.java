package cn.zwqh.springboot.hint;

import cn.zwqh.springboot.hint.service.ExampleService;
import cn.zwqh.springboot.hint.service.OrderServiceImpl;
import org.apache.shardingsphere.api.hint.HintManager;
import org.apache.shardingsphere.shardingjdbc.api.yaml.YamlMasterSlaveDataSourceFactory;
import org.apache.shardingsphere.shardingjdbc.api.yaml.YamlShardingDataSourceFactory;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class HintMain {
    /**
     * 分库分表
     */
    private static final HintType TYPE = HintType.DATABASE_TABLES;
    /**
     * 分库
     */
    //private static final HintType TYPE = HintType.DATABASE_ONLY;

    /**
     * 读写分离
     */
    //private static final HintType TYPE = HintType.MASTER_ONLY;

    /**
     * demo运行入口
     *
     * @param args
     * @throws IOException
     * @throws SQLException
     */
    public static void main(String[] args) throws IOException, SQLException {
        DataSource dataSource = getDataSource();
        ExampleService exampleService = getExampleService(dataSource);
        exampleService.initEnvironment();
        exampleService.processSuccess();
        processWithHintValue(dataSource);
//        exampleService.cleanEnvironment();
    }

    /**
     * 根据TYPE创建不同配置的数据源
     *
     * @return
     * @throws IOException
     * @throws SQLException
     */
    private static DataSource getDataSource() throws IOException, SQLException {
        switch (TYPE) {
            case DATABASE_TABLES:
                return YamlShardingDataSourceFactory.createDataSource(getFile("/META-INF/hint-databases-tables.yaml"));
            case DATABASE_ONLY:
                return YamlShardingDataSourceFactory.createDataSource(getFile("/META-INF/hint-databases-only.yaml"));
            case MASTER_ONLY:
                return YamlMasterSlaveDataSourceFactory.createDataSource(getFile("/META-INF/hint-master-only.yaml"));
            default:
                throw new UnsupportedOperationException("unsupported type");
        }
    }

    /**
     * 获取配置文件
     *
     * @param configFile 绝对路径或者相对路径都可
     * @return
     */
    private static File getFile(final String configFile) {
        return new File(Thread.currentThread().getClass().getResource(configFile).getFile());
    }

    private static ExampleService getExampleService(final DataSource dataSource) {
        return new OrderServiceImpl(dataSource);
    }

    private static void processWithHintValue(final DataSource dataSource) throws SQLException {
        try (HintManager hintManager = HintManager.getInstance();
             Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            setHintValue(hintManager);
            statement.execute("select * from t_order");
            statement.execute("SELECT i.* FROM t_order o, t_order_item i WHERE o.order_id = i.order_id");
            statement.execute("select * from t_order_item");
            statement.execute("INSERT INTO t_order (user_id, address_id, status) VALUES (1, 1, 'init')");
        }
    }

    private static void setHintValue(final HintManager hintManager) {
        switch (TYPE) {
            case DATABASE_TABLES:
                //设置数据源分片键值
                hintManager.addDatabaseShardingValue("t_order", 0L);
                //设置表分片键值
                hintManager.addTableShardingValue("t_order", 1L);
                return;
            case DATABASE_ONLY:
                //设置数据源分片键值
                hintManager.setDatabaseShardingValue(1L);
                return;
            case MASTER_ONLY:
                //设置主库路由
                hintManager.setMasterRouteOnly();
                return;
            default:
                throw new UnsupportedOperationException("unsupported type");
        }
    }
}