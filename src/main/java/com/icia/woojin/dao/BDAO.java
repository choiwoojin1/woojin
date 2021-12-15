package com.icia.woojin.dao;

import com.icia.woojin.dto.BOARD;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BDAO {
    int bWrite(BOARD board);

    List<BOARD> bList();

    void bCount(int bNo);

    BOARD bView(int bNo);

    int bModify(BOARD board);

    int bDelete(int bNo);
}
