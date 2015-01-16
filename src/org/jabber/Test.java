package org.jabber;

import org.jabber.webim.DBSync;
import org.jabber.webim.model.IMGroup;
import org.jabber.webim.model.IMUser;

public class Test {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			IMGroup group = new IMGroup();
			group.setName("嘻嘻哈哈");
			group.setDescription("嘻嘻哈哈哈.");
			DBSync.addIMGroup(group);
			
			IMUser user = new IMUser();
			user.setUsername("111");
			user.setPassword("123456");
			user.setRealname("111");
			user.setEmail("nmcfehl@fdsf.com");
			user.setGroup("嘻嘻哈哈");
			user.setIsgroupadmin(true);
			DBSync.addIMUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
