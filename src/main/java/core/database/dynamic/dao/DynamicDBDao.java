package core.database.dynamic.dao;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @Auther: Administrator
 * @Date: 2018/8/11 15:12
 * @Description:
 */
public class DynamicDBDao {
    private JdbcTemplate jdbcTemplate;

    public DynamicDBDao() {
        jdbcTemplate=new JdbcTemplate(getDataSource());
    }
    private static final String driverClassName = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://www.zmjeep.com/jeeweb";
    private static final String dbUsername = "root";
    private static final String dbPassword = "lhadmin";
    public static DriverManagerDataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(dbPassword);
        return dataSource;
    }
    public DynamicDBDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     *
     * @title: getJdbcTemplate
     * @description:不滿足方便获取操作
     * @return
     * @return: JdbcTemplate
     */
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void initJdbcTemplate(BasicDataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Map<String, Object>> queryList(String sql, Object... param) {
        List<Map<String, Object>> list;
        if (ArrayUtils.isEmpty(param)) {
            list = jdbcTemplate.queryForList(sql);
        } else {
            list = jdbcTemplate.queryForList(sql, param);
        }
        return list;
    }
    public List<Map<String,Object>> queryList(String sql){
        return jdbcTemplate.queryForList(sql);
    }

    public <T> List<T> queryList(String sql, Class<T> clazz, Object... param) {
        List<T> list;

        if (ArrayUtils.isEmpty(param)) {
            list = jdbcTemplate.queryForList(sql, clazz);
        } else {
            list = jdbcTemplate.queryForList(sql, clazz, param);
        }
        return list;
    }
}
