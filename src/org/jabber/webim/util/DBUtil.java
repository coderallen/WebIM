package org.jabber.webim.util;

import java.util.List;
import java.util.Map;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.midao.jdbc.core.MjdbcFactory;
import org.midao.jdbc.core.handlers.input.named.MapInputHandler;
import org.midao.jdbc.core.handlers.output.MapListOutputHandler;
import org.midao.jdbc.core.handlers.type.OracleTypeHandler;
import org.midao.jdbc.core.service.QueryRunnerService;

public class DBUtil {
	public static BasicDataSource dataSource;
	
	static{
		try {
			if(dataSource == null){
				System.out.println("初始化WEBIM数据源.");
				dataSource = new BasicDataSource();
				dataSource.setDriverClassName(PropertyUtil.getProperty("db.jdbc.driver"));
				dataSource.setUrl(PropertyUtil.getProperty("db.jdbc.url"));
				dataSource.setUsername(PropertyUtil.getProperty("db.jdbc.username"));
				dataSource.setPassword(PropertyUtil.getProperty("db.jdbc.password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 执行查询操作
	 * @param sql
	 * @param queryParameters
	 * @return
	 * @throws Exception
	 */
	public static List<Map<String, Object>> executeQuery(String sql,Map<String, Object> queryParameters) throws Exception{
		QueryRunnerService runner = MjdbcFactory.getQueryRunner(dataSource,OracleTypeHandler.class);
		MapInputHandler input = new MapInputHandler(sql, queryParameters);
		List<Map<String, Object>> result = runner.query(input, new MapListOutputHandler());
		
		return result;
	}
	
	/**
	 * 执行更新操作
	 * @param sql
	 * @param queryParameters
	 * @return
	 * @throws Exception
	 */
	public static int execute(String sql,Map<String, Object> queryParameters) throws Exception{
		QueryRunnerService runner = MjdbcFactory.getQueryRunner(dataSource,OracleTypeHandler.class);
		MapInputHandler input = new MapInputHandler(sql, queryParameters);
		return runner.update(input);
	}
	
}
