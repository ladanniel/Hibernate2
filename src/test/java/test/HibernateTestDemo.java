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
		//��ȡsession
		Session session = sessionFactory.openSession();
		//��������
		Transaction trans = session.beginTransaction();
		//����id��ѯ
		User user = session.get(User.class, "297e278c693442bb01693442c1270000");
		System.out.println(user);
		//�򷵻ص�user�������������޸�֮���ֵ
		user.setUsername("��������");
		session.update(user);
		System.out.println("ִ�й��̣���user�������ҵ�uidֵ������uid�����޸�");
		trans.commit();
	}
	@Test
	public void testAdd(){
		/*//��һ��������hibernate���������ļ� hibernate.cfg.xml
			//��src���ҵ�������hibernate.cfg.xml
			//��hibernate�����װ����
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");*/
		//�ڶ���������sessionFactory���� ��ȡhibernacle���������ļ����ݣ�����sessionFactory
		   //�ڹ����У�����ӳ���ϵ�����������ݿ��ﴴ����
/*		 SessionFactory sessionFactory = configuration.buildSessionFactory();*/
		
		
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		//��������ʹ��sessionFactory����session���� ����jdbc����
		Session session = sessionFactory.openSession();
		//���Ĳ�����������
		Transaction tx = session.beginTransaction();
		//���岽��д�����߼�crud����
		User user = new User();
		user.setUsername("�ܶ���");
		user.setPassword("1234567");
		user.setAddress("�Ϻ��л��ֽ���");
		//����session�����ύ
		session.save(user);
		//��������ع�
		/*tx.rollback();*/
		//���������ύ����
		tx.commit();
		//���߲����ر���Դ
		session.close();
		sessionFactory.close();
	}

}
