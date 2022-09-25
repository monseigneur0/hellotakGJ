package hello8.hellotakGJ.repository;


import hello8.hellotakGJ.domain.MyBatis;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyBatisRepository {

    List<MyBatis> getAllMember();
}
