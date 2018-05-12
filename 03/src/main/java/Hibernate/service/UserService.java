package Hibernate.service;

import Hibernate.entity.User;
import Hibernate.util.MySessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @param
 * @Author: 董能宇
 * @Email:dongnengyu@gmail.com
 * @Description:
 * @Date: 2018/5/12
 */
public class UserService {

    public static void main(String[] args) {

        //addUser();
        //updateUser();

        deleteUser();

    }


    public static void updateUser() {

//        //1.创建Configuration，该对象用于读取HIbernate.cfg.xml，并完成初始化
//        Configuration configuration = new Configuration().configure();
//
//
//        //2.创建sessionfactory，重量级对象（应该尽量保证只有一个对象）
//        SessionFactory sessionFactory = configuration.buildSessionFactory();
//
//        //3.创建session，
//        Session session = sessionFactory.openSession();


        //为了避免内存问题 ，直接调用制作好的MySessionFactory
        Session session = MySessionFactory.getSessionFactory().openSession();

        //4.对HIbernate而言，要求进行增加、修改、删除的时候要用事务，查询就不需要
        Transaction transaction = session.beginTransaction();

        User user = session.load(User.class, 1);


        user.setName("xiaomu");
        transaction.commit();
        session.close();


    }

    public static void deleteUser() {

//        //1.创建Configuration，该对象用于读取HIbernate.cfg.xml，并完成初始化
//        Configuration configuration = new Configuration().configure();
//
//
//        //2.创建sessionfactory，重量级对象（应该尽量保证只有一个对象）
//        SessionFactory sessionFactory = configuration.buildSessionFactory();
//
//        //3.创建session，
//        Session session = sessionFactory.openSession();


        //为了避免内存问题 ，直接调用制作好的MySessionFactory
        Session session = MySessionFactory.getSessionFactory().openSession();

        //4.对HIbernate而言，要求进行增加、修改、删除的时候要用事务，查询就不需要
        Transaction transaction = session.beginTransaction();

        User user = (User) session.load(User.class, 7);

        session.delete(user);

        transaction.commit();

        session.close();
    }


    public static void addUser() {

//        //1.创建Configuration，该对象用于读取HIbernate.cfg.xml，并完成初始化
//        Configuration configuration = new Configuration().configure();
//
//
//        //2.创建sessionfactory，重量级对象（应该尽量保证只有一个对象）
//        SessionFactory sessionFactory = configuration.buildSessionFactory();
//
//        //3.创建session，
//        Session session = sessionFactory.openSession();


        //为了避免内存问题 ，直接调用制作好的MySessionFactory
        Session session = MySessionFactory.getSessionFactory().openSession();

        //4.对HIbernate而言，要求进行增加、修改、删除的时候要用事务，查询就不需要
        Transaction transaction = session.beginTransaction();

        User user = new User();
        user.setName("dongnengyu");
        user.setAge(45);
        //user.setId(1);

        session.save(user);

        //5.事务提交
        transaction.commit();

        session.close();
    }
}
