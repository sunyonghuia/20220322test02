package com.ujiuye.day03;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.event.ItemEvent;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 孙永辉
 * @create 2020-12-30 10:20
 */
public class MyTest {
    private SqlSession sqlSession = null;

    @Before
    public void before() {
        sqlSession = TestUtils.tu();
    }

    @After
    public void after() {
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testQuery() throws IOException {
//        //读取核心配置文件
//        InputStream is = Resources.getResourceAsStream("Mybayis-config.xml");
//        //创建工厂对象
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
//        //生产数据，操作对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        //数据操作
        List<Person> psersonList = sqlSession.selectList("Person.queryAll");
        for (Person person : psersonList) {
            System.out.println(person);
        }
    }

    @Test
    public void testQueryById() throws IOException {
//        //读取核心配置文件
//        InputStream is = Resources.getResourceAsStream("Mybayis-config.xml");
//        //创建工厂对象
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
//        //生产数据，操作对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //数据操作
        Person person = sqlSession.selectOne("Person.queryById", 1);
        System.out.println(person);
    }

    @Test
    public void testaddPerson() throws IOException {
//        //读取核心配置文件
//        InputStream is = Resources.getResourceAsStream("Mybayis-config.xml");
//        //创建工厂对象
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
//        //生产数据，操作对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //数据操作
        Person person = new Person();
        person.setPname("张二飞");
        person.setPaddress("老张家");

        int insert = sqlSession.insert("Person.addPerson", person);
        System.out.println("完成");
//        sqlSession.commit();
//        sqlSession.close();
    }

    @Test
    public void testupdatePerson() throws IOException {
//        //读取核心配置文件
//        InputStream is = Resources.getResourceAsStream("Mybayis-config.xml");
//        //创建工厂对象
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
//        //生产数据，操作对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        //数据操作
        Person person = new Person();
        person.setPid(4);
        person.setPname("张大da飞");
        sqlSession.update("Person.updatePerson", person);
        System.out.println("完成");
//        sqlSession.commit();
//        sqlSession.close();
    }

    @Test
    public void testdelPerson() throws IOException {
//        //读取核心配置文件
//        InputStream is = Resources.getResourceAsStream("Mybayis-config.xml");
//        //创建工厂对象
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
//        //生产数据，操作对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        //数据操作
        int delete = sqlSession.delete("Person.delPerson", 4);
        System.out.println("完成");
//        sqlSession.commit();
//        sqlSession.close();
    }
}
