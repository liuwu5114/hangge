package com.dao.mapper;

import com.dao.model.UserOrder;

public interface UserOrderMapper {
    int deleteByPrimaryKey(String orderNo);

    int insert(UserOrder record);

    int insertSelective(UserOrder record);

    UserOrder selectByPrimaryKey(String orderNo);

    int updateByPrimaryKeySelective(UserOrder record);

    int updateByPrimaryKey(UserOrder record);
}