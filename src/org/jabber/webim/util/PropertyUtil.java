package org.jabber.webim.util;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

public class PropertyUtil {
	private static Properties props;
	
	static{
		if(props == null){
			try {
				System.out.println("初始化配置文件.");
				props = new Properties();
				URL url = PropertyUtil.class.getClassLoader().getResource("/");

				if(url == null){
					url = PropertyUtil.class.getClassLoader().getSystemResource("");
				}

				props.load(new FileInputStream(new File(url.getPath() + "webim.properties")));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 根据KEY获取config配置文件内容
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String getProperty(String key) throws Exception{
		return props.getProperty(key);
	}
	
	public static int getPropertyInt(String key) throws Exception{
		return Integer.parseInt(props.getProperty(key));
	}
}
