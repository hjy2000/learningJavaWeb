import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest1 {
    @Test
    public void testselectAll() throws IOException {
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3
        BrandMapper brandmapper = sqlSession.getMapper(BrandMapper.class);//获取代理对象
        List<Brand> brands= brandmapper.selectAll();//通过接口执行xml对应的sql
        System.out.println(brands);
        //4. 释放资源
        sqlSession.close();
    }
    @Test
    public void testSelectById() throws IOException {
        int id=1;
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3
        BrandMapper brandmapper = sqlSession.getMapper(BrandMapper.class);//获取代理对象
        Brand brand= brandmapper.selectById(id);//通过接口执行xml对应的sql
        System.out.println(brand);
        //4. 释放资源
        sqlSession.close();
    }
    @Test
    public void testSelectByCondition() throws IOException {
        int status=1;
        String companyName="华为";
        String brandName="华为";
        //处理参数 在程序完成
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        //封装brand对象给参数方法二使用
        Brand brand=new Brand();
        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);

        //封装map集合给参数方法三使用
        Map map=new HashMap();
//        map.put("status",status);
        map.put("companyName",companyName);
//        map.put("brandName",brandName);

        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3
        BrandMapper brandmapper = sqlSession.getMapper(BrandMapper.class);//获取代理对象
//        List<Brand> brands= brandmapper.selectByCondition(status,companyName,brandName);//通过接口执行xml对应的sql
//        List<Brand> brands1= brandmapper.selectByCondition1(brand);//通过接口执行xml对应的sql
//        List<Brand> brands2= brandmapper.selectByCondition2(map);//通过接口执行xml对应的sql
//        List<Brand> brands3= brandmapper.selectByCondition3(map);
        List<Brand> brands4= brandmapper.selectByConditionSingle(brand);
        System.out.println(brands4);
        //4. 释放资源
        sqlSession.close();
    }
    @Test
    public void testAdd() throws IOException {
        int status = 1;
        String companyName="波导手机";
        String brandName="波导";
        String description="手机中的战斗机";
        int ordered = 100;

        //封装brand对象
        Brand brand=new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//可以设置传参自动提交事务（true）
        //3
        BrandMapper brandmapper = sqlSession.getMapper(BrandMapper.class);//获取代理对象
        brandmapper.add(brand);

        //提交事务
//        sqlSession.commit();

        //4. 释放资源
        sqlSession.close();
    }

    @Test
    public void testAdd2() throws IOException {
        int status = 1;
        String companyName="波导手机";
        String brandName="波导";
        String description="手机中的战斗机";
        int ordered = 100;

        //封装brand对象
        Brand brand=new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//可以设置传参自动提交事务（true）
        //3
        BrandMapper brandmapper = sqlSession.getMapper(BrandMapper.class);//获取代理对象
        brandmapper.add2(brand);
        System.out.println(brand.getId());//打印主键返回的id值

        //4. 释放资源
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
        int status = 1;
        String companyName="波导手机";
        String brandName="波导";
        String description="波导手机，手机中的战斗机";
        int ordered = 200;
        int id=5;

        //封装brand对象
        Brand brand=new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);
        brand.setId(id);
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//可以设置传参自动提交事务（true）
        //3
        BrandMapper brandmapper = sqlSession.getMapper(BrandMapper.class);//获取代理对象
        int count=brandmapper.update(brand);
        System.out.println(count);//打印影响行数

        //4. 释放资源
        sqlSession.close();
    }
    @Test
    public void testUpdate1() throws IOException {
        int status = 0;
        String companyName="波导手机";
        String brandName="波导";
        String description="波导手机，手机中的战斗机";
        int ordered = 200;
        int id=6;

        //封装brand对象
        Brand brand=new Brand();
        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);
//        brand.setDescription(description);
//        brand.setOrdered(ordered);
        brand.setId(id);
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//可以设置传参自动提交事务（true）
        //3
        BrandMapper brandmapper = sqlSession.getMapper(BrandMapper.class);//获取代理对象
        int count=brandmapper.update1(brand);
        System.out.println(count);//打印影响行数

        //4. 释放资源
        sqlSession.close();
    }
    @Test
    public void testDeleteById() throws IOException {
//        int status = 0;
//        String companyName="波导手机";
//        String brandName="波导";
//        String description="波导手机，手机中的战斗机";
//        int ordered = 200;
        int id=6;

        //封装brand对象
//        Brand brand=new Brand();
//        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);
//        brand.setDescription(description);
//        brand.setOrdered(ordered);
//        brand.setId(id);
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//可以设置传参自动提交事务（true）
        //3
        BrandMapper brandmapper = sqlSession.getMapper(BrandMapper.class);//获取代理对象
        brandmapper.deleteById(id);

        //4. 释放资源
        sqlSession.close();
    }
    @Test
    public void testDeleteByIds() throws IOException {
        int [] ids={1,7};
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//可以设置传参自动提交事务（true）
        //3
        BrandMapper brandmapper = sqlSession.getMapper(BrandMapper.class);//获取代理对象
        brandmapper.deleteByIds(ids);

        //4. 释放资源
        sqlSession.close();
    }
}
