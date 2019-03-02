package test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import Utils.HibernateUtils;

import com.itcast.entity.User;

public class HibernateTestDemo {
	@Test
	public void testUpdate(){
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		//获取session
		Session session = sessionFactory.openSession();
		//开启事务
		Transaction trans = session.beginTransaction();
		//根据id查询
		User user = session.get(User.class, "297e278c693442bb01693442c1270000");
		System.out.println(user);
		//向返回的user对象里面设置修改之后的值
		user.setUsername("东方不败");
		session.update(user);
		System.out.println("执行过程：到user对象里找到uid值，根据uid进行修改");
		trans.commit();
	}
	@Test
	public void testAdd(){
		/*//第一步：加载hibernate核心配置文件 hibernate.cfg.xml
			//到src下找到名称是hibernate.cfg.xml
			//在hibernate里面封装对象
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");*/
		//第二步：创建sessionFactory对象 读取hibernacle核心配置文件内容，创建sessionFactory
		   //在过程中，根据映射关系，在配置数据库里创建表
/*		 SessionFactory sessionFactory = configuration.buildSessionFactory();*/
		
		
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		//第三步：使用sessionFactory创建session对象 类似jdbc连接
		Session session = sessionFactory.openSession();
		//第四步：开启事务
		Transaction tx = session.beginTransaction();
		//第五步：写具体逻辑crud操作
		User user = new User();
		user.setUsername("周冬雨");
		user.setPassword("1234567");
		user.setAddress("上海市黄浦江区");
		//调用session方法提交
		session.save(user);
		//处理操作回滚
		/*tx.rollback();*/
		//第六步：提交事务
		tx.commit();
		//第七步：关闭资源
		session.close();
		sessionFactory.close();
	}

}
