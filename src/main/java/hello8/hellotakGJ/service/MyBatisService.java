package hello8.hellotakGJ.service;

import hello8.hellotakGJ.domain.MyBatis;
import hello8.hellotakGJ.repository.MyBatisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBatisService {

    @Autowired
    private MyBatisRepository myBatisRepository;

    public List<MyBatis> getAllMember(){
        return myBatisRepository.getAllMember();
    };
}
