package com.swt.hbase;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2016/3/3 0003.
 */
public class HbaseJdbc {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
//    @Before
    public void before(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        jdbcTemplate = (JdbcTemplate) context.getBean("phoenixJdbcTemplate");
    }
//    @Test
    public void test(){
        List<com.swt.hbase.Travel> pageRecords = findPageRecords(3, 3, "20160202", "163572", "98756");
        for (Travel tt:pageRecords){
            System.out.println(tt.getROWKEY());
        }
    }

    public List<Travel> findPageRecords(int currentPageNum, int pageSize, String ST, String SP, String EP) {


        //第一个参数为SQL语句，第二参数的RowMapper将每一行结果映射成一个Java对象，方便将其他封装到JavaBean中，第三个参数为占位符值（为可变参数）
        List<Travel> travels =  jdbcTemplate.query("SELECT * FROM TRAVEL where PAGEID > ? AND ST >= ? AND ROWKEY LIKE ? limit ?",
                new RowMapper<Travel>() {
                    public Travel mapRow(ResultSet rs, int rowNum)
                            throws SQLException {
                        Travel travel = new Travel();
                        travel.setROWKEY(rs.getString("ROWKEY"));
                        travel.setSP(rs.getString("SP"));
                        travel.setEP(rs.getString("EP"));
                        travel.setST(rs.getString("ST"));
                        travel.setET(rs.getString("ET"));
                        return travel;
                    }
                },(currentPageNum - 1)*pageSize,ST,SP+EP+"%",pageSize);
        return  travels;
    }
}
