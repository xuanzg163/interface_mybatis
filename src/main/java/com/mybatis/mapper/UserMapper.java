package com.mybatis.mapper;

import com.mybatis.dto.UserCardAccountDto;
import com.mybatis.dto.UserCardDto;
import com.mybatis.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * UserDAO
 */

public interface UserMapper {
    public User queryUserById(Integer id);
    public List<User> queryUserByName(@Param("userName")String userName);
    public List<User> queryUserByNation(@Param("nation")String nation);
    public List<User> queryUserByNameAndNation(User user);
    public List<User> queryUserByNameAndNation2(User user);
    public Integer addUser(User user);
    public Integer addUserHasKey(User user);
    public Integer addUserHasKeyGeneral(User user);
    public Integer addUserBatch(List<User> userList);
    public Integer updateUser(User user);
    public Integer updateUserBatch(Integer[] idx);
    public Integer deleteUser(Integer id);
    public Integer deleteUserBatch(List<Integer> idx);
    public UserCardDto queryUserCardByIdUse(Integer id);
    public UserCardAccountDto queryUserCardAccountByIdUses(Integer id);

}

