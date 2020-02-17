package service;

import db.CityMapper;
import db.CityRangeMapper;
import db.model.CityModel;
import db.model.CityRangeModel;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.Reader;

import java.util.List;

public class DBService {
    private SqlSessionFactory sqlSessionFactory;
    private Reader reader;
    private static final Logger LOGGER = Logger.getLogger(DBService.class);

    public DBService() {
        try {
            reader = Resources
                    .getResourceAsReader("mybatis.config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException dbs){
            LOGGER.error(dbs);
        }
    }
    public List<CityModel> getCities() {
        SqlSession sqlSession1 = null;
        try {
            sqlSession1 = sqlSessionFactory.openSession();
            CityMapper cityMapper = sqlSession1.getMapper(CityMapper.class);
            return cityMapper.getCities();
        } catch (SqlSessionException ex) {
            LOGGER.error(ex.getMessage(), ex);
            return null;

        } finally {
            if (sqlSession1 != null) {
                sqlSession1.close();

            }
        }
    }
    public List<CityRangeModel> getRanges() {
        SqlSession sqlSession1 = null;
        try {
            sqlSession1 = sqlSessionFactory.openSession();
            CityRangeMapper cityMapper = sqlSession1.getMapper(CityRangeMapper.class);
            return cityMapper.getRanges();
        } catch (SqlSessionException ex) {
            LOGGER.error(ex.getMessage(), ex);
            return null;

        } finally {
            if (sqlSession1 != null) {
                sqlSession1.close();

            }
        }
    }
}


