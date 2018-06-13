package com.demo.dao.proxy;  
import com.demo.dao.UserDAO;  
import com.demo.dao.UserDAOImpI;  
import com.demo.utils.JdbcUtils;  
import com.demo.bean.User;  
public class UserDAOProxy implements UserDAO{  
    private  JdbcUtils dbc=null;//定义数据库连接  
    private UserDAO dao=null;//定义DAO接口  
    public UserDAOProxy(){  
        try {  
            dbc=new JdbcUtils();//实例化数据库连接  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        dao=new UserDAOImpI(dbc.getConnection());  
          
    }  
    @Override  
    public boolean findLogin(User user) throws Exception {  
        boolean flag=false;  
        try {  
            flag=dao.findLogin(user);//调用真实主题  
        } catch (Exception e) {  
            throw e;  
        }finally{  
            dbc.close();  
        }  
        return flag;  
    }  
  
}  