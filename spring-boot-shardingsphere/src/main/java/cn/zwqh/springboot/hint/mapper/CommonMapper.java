package cn.zwqh.springboot.hint.mapper;

import java.sql.SQLException;
import java.util.List;

public interface CommonMapper<T, P> {
    
    /**
     * 如果表不存在则创建表
     * Create table if not exist.
     * 
     * @throws SQLException SQL exception
     */
    void createTableIfNotExists() throws SQLException;
    
    /**
     * 删除表
     * Drop table.
     * 
     * @throws SQLException SQL exception
     */
    void dropTable() throws SQLException;
    
    /**
     * 清空表
     * Truncate table.
     * 
     * @throws SQLException SQL exception
     */
    void truncateTable() throws SQLException;
    
    /**
     * 新增数据
     * Insert data.
     * 
     * @param entity entity
     * @return generated primary key
     * @throws SQLException SQL exception
     */
    P insert(T entity) throws SQLException;
    
    /**
     * 删除数据
     * Delete data.
     * 
     * @param primaryKey primaryKey
     * @throws SQLException SQL exception
     */
    void delete(P primaryKey) throws SQLException;
    
    /**
     * 查询数据
     * Select all data.
     * 
     * @return all data
     * @throws SQLException SQL exception
     */
    List<T> selectAll() throws SQLException;
}
