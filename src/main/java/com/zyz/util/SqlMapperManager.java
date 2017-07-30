package com.zyz.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by ZhangYuanzhuo on 2016/9/18.
 */
public class SqlMapperManager {
    private static SqlSessionFactory factory = null;
    private static String fileName = "mybatisConf.xml";

    private SqlMapperManager() {
    }

    public static void initMapper(String sqlMapperFileName) {
        fileName = sqlMapperFileName;
    }

    public static SqlSessionFactory getFactory() {
        try {
            if (factory == null) {
                Reader reader = Resources
                        .getResourceAsReader(fileName);
                SqlSessionFactoryBuilder builder =
                        new SqlSessionFactoryBuilder();
                factory = builder.build(reader);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return factory;
    }
}
