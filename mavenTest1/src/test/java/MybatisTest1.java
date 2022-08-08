import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest1 {

    @Test
    public void testsekectAll() throws IOException {
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

}
