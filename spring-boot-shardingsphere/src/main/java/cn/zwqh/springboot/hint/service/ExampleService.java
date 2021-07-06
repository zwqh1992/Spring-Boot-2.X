package cn.zwqh.springboot.hint.service;

import java.sql.SQLException;

public interface ExampleService {

    /**
     * 初始化环境
     * Initialize environment.
     *
     * @throws SQLException SQL exception
     */
    void initEnvironment() throws SQLException;

    /**
     * 清除环境
     * Clean environment.
     *
     * @throws SQLException SQL exception
     */
    void cleanEnvironment() throws SQLException;

    /**
     * 流程成功
     * Process success.
     *
     * @throws SQLException SQL exception
     */
    void processSuccess() throws SQLException;

    /**
     * 流程失败
     * Process failure.
     *
     * @throws SQLException SQL exception
     */
    void processFailure() throws SQLException;

    /**
     * 打印数据
     * Print data.
     *
     * @throws SQLException SQL exception
     */
    void printData() throws SQLException;
}
