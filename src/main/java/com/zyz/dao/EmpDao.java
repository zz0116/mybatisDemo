package com.zyz.dao;

import com.zyz.model.Emp;
import com.zyz.util.SqlMapperManager;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.BasicConfigurator;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ZhangYuanzhuo on 2016/9/18.
 */
public class EmpDao {

    public static void main(String[] args) {
        BasicConfigurator.configure();
        SqlSession session = null;
        try {
            SqlSessionFactory factory = SqlMapperManager.getFactory();
            if (factory == null) {
                System.out.println("get SqlSessionFactory failed.");
                return;
            }
            session = factory.openSession();

            List<Integer> ids = new LinkedList<>();
            ids.add(5);
            List<Emp> emps = session.selectList(EmpDao.class.getName()+".dynaQuery", ids);
            for(Emp emp: emps) {
                printEmp(emp);
            }

            Emp emp = new Emp();
            emp.setId(4);
            emp.setSal(10000D);
            session.update(EmpDao.class.getName()+".dynaUpdate", emp);
            session.commit();
//
//            ids = new ArrayList<>();
////            ids = new LinkedList<>();
//            ids.add(2);
//            ids.add(3);
////            Integer[] ids = {1,8};
//            session.delete(EmpDao.class.getName()+".dynaDelete", ids);
//            session.commit();
//
//            emp = new Emp();
//            emp.setId(9);
//            emp.setName("");
//            emp.setSal(7000D);
//            session.insert(EmpDao.class.getName()+".dynaInsert", emp);
//            session.commit();
//
//            emp = session.selectOne(
//                    EmpDao.class.getName() + ".selectEmp_by_id", 6);
            printEmp(emp);


        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public static void printEmp(Emp emp) {
        if (emp!=null) {
            System.out.println(emp.getId() + ": " + emp.getName() + ", " + emp.getSal());
        } else {
            System.out.println("emp is null!");
        }
    }
}
