package com.ujiuye.day03;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 孙永辉
 * @create 2020-12-30 14:52
 */
public class TestUtils {
    private static SqlSession sqlSession = null;

    static {
        //读取核心配置文件
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("Mybayis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //生产数据，操作对象
        sqlSession = sqlSessionFactory.openSession();
    }

    public static SqlSession tu() {
        return sqlSession;
    }
}
