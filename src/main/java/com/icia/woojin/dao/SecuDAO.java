package com.icia.woojin.dao;

import com.icia.woojin.dto.SecuDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SecuDAO {

    // int secuJoin(SecuDTO secu);
    // service로 int타입의 값을 반환

    // void return값이 없음
    void secuJoin(SecuDTO secu);

    SecuDTO secuLogin(SecuDTO secu);



}
