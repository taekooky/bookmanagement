package com.demo.dao.proxy;  
import com.demo.dao.UserDAO;  
import com.demo.dao.UserDAOImpI;  
import com.demo.utils.JdbcUtils;  
import com.demo.bean.User;  
public class UserDAOProxy implements UserDAO{  
    private  JdbcUtils dbc=null;//�������ݿ�����  
    private UserDAO dao=null;//����DAO�ӿ�  
    public UserDAOProxy(){  
        try {  
            dbc=new JdbcUtils();//ʵ�������ݿ�����  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        dao=new UserDAOImpI(dbc.getConnection());  
          
    }  
    @Override  
    public boolean findLogin(User user) throws Exception {  
        boolean flag=false;  
        try {  
            flag=dao.findLogin(user);//������ʵ����  
        } catch (Exception e) {  
            throw e;  
        }finally{  
            dbc.close();  
        }  
        return flag;  
    }  
  
}  