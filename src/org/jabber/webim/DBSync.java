package org.jabber.webim;

import java.util.HashMap;
import java.util.Map;

import org.jabber.webim.model.IMGroup;
import org.jabber.webim.model.IMUser;
import org.jabber.webim.util.DBUtil;
import org.jabber.webim.util.PropertyUtil;
import org.jivesoftware.util.Blowfish;

public class DBSync {
	
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	public static void addIMUser(IMUser user) throws Exception{
		Map<String, Object> userparam = new HashMap<String, Object>();
		userparam.put("username", user.getUsername());
		Blowfish blowFish = new Blowfish(PropertyUtil.getProperty("passrowd.passWordKey"));
		userparam.put("password", blowFish.encryptString(user.getPassword()));
		userparam.put("realname", user.getRealname());
		userparam.put("email", user.getEmail());
		
		if(user.getGroup() != null){//创建与组的关系
			Map<String, Object> groupuserparam = new HashMap<String, Object>();
			groupuserparam.put("groupname", user.getGroup());
			groupuserparam.put("username", user.getUsername());
			groupuserparam.put("isadmin", user.isIsgroupadmin());
			
			DBUtil.execute("INSERT INTO ofGroupUser VALUES(:groupname,:username,:isadmin)", groupuserparam);
		}
		
		DBUtil.execute("INSERT INTO ofUser VALUES(:username,NULL,:password,:realname,:email,'001419392511749','001419392511749')", userparam);
	}
	
	/**
	 * 删除用户
	 * @param user
	 * @return
	 */
	public static void delIMUser(String user) throws Exception{
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("username", user);
		DBUtil.execute("DELETE FROM ofGroupUser WHERE username =:username", param);
		param.put("username", user);
		DBUtil.execute("DELETE FROM ofUser WHERE username =:username", param);
	}
	
	/**
	 * 新增组
	 * @param group
	 * @return
	 */
	public static void addIMGroup(IMGroup group) throws Exception{
		Map<String, Object> groupparam = new HashMap<String, Object>();
		groupparam.put("name", group.getName());
		groupparam.put("description", group.getDescription());
		
		DBUtil.execute("INSERT INTO ofGroup VALUES(:name,:description)", groupparam);
	}
	
	/**
	 * 删除组
	 * @param group
	 * @return
	 */
	public static void delIMGroup(String group) throws Exception{
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("name", group);
		DBUtil.execute("DELETE FROM ofGroupUser WHERE groupName =:name", param);
		param.put("name", group);
		DBUtil.execute("DELETE FROM ofGroup WHERE groupName =:name", param);
	}
}
