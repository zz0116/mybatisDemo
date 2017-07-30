DROP DATABASE IF EXISTS mybatis;
CREATE DATABASE mybatis CHARACTER SET = utf8;
USE mybatis;

CREATE TABLE emp(
  emp_id INT PRIMARY KEY ,
  emp_name VARCHAR(20) DEFAULT NULL ,
  emp_sal DOUBLE(9,2) DEFAULT NULL
)CHARACTER SET = utf8;

INSERT INTO emp(emp_id, emp_name, emp_sal) VALUES(1, "张三", 7000);
INSERT INTO emp(emp_id, emp_name, emp_sal) VALUES(2, "李四", 8000);
INSERT INTO emp(emp_id, emp_name, emp_sal) VALUES(3, "王五", 9000);
INSERT INTO emp(emp_id, emp_name, emp_sal) VALUES(4, "翠花", 6000);
INSERT INTO emp(emp_id, emp_name, emp_sal) VALUES(5, "大宝", 5000);