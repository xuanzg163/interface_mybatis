package com.mybatis;

import com.mybatis.dto.UserCardAccountDto;
import com.mybatis.dto.UserCardDto;
import com.mybatis.mapper.UserMapper;
import com.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class UserMapperTest {

    private UserMapper userMapper;

    @Before
    public void init() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sqlSessionFactory.openSession(true);//事务提交
        userMapper = session.getMapper(UserMapper.class);
    }

    /**
     * 测试根据用户id查询用户信息
     *
     * @throws Exception
     */
    @Test
    public void queryUserById() throws Exception {
        User user = userMapper.queryUserById(1);
        System.out.println(user);
    }


    /**
     * 测试动态SQL，利用用户名模糊查询用户信息
     *
     * @throws Exception
     */
    @Test
    public void queryUserByName() throws Exception {
        List<User> userList = userMapper.queryUserByName("miku");
        for (User user : userList) {
            System.out.println(user);
        }
    }

    /**
     * 测试动态sql 利用国家查询用户信息
     *
     * @throws Exception
     */
    @Test
    public void queryUserByNation() throws Exception {
//        List<User> userList = userMapper.queryUserByNation("chn");
        List<User> userList = userMapper.queryUserByNation("");

        for (User user : userList) {
            System.out.println(user);
        }
    }

    /**
     *  测试动态sql 利用用户名或者国家查询
     * @throws Exception
     */
    @Test
    public void queryUserByNameAndNation() throws Exception {
        User user = new User();
//        user.setUserName("zhang");
        user.setNation("jp");

        List<User> userList = userMapper.queryUserByNameAndNation(user);
        for (User user1:userList){
            System.out.println(user1);
        }
    }

    /**
     *  测试动态sql 利用用户名或者国家查询
     *  利用trim标签自动去除语句
     * @throws Exception
     */
    @Test
    public void queryUserByNameAndNation2() throws Exception {
        User user = new User();
//        user.setUserName("zhang");
        user.setNation("jp");

        List<User> userList = userMapper.queryUserByNameAndNation2(user);
        for (User user1:userList){
            System.out.println(user1);
        }
    }



    /**
     * 测试addUser 不返回主键
     *
     * @throws Exception
     */
    @Test
    public void addUser() throws Exception {
        User user = new User();
        user.setUserName("yoooooooooo");
        user.setUserPwd("ysdadada");
        user.setRealName("hiname");
        user.setNation("jp");
        user.setCardId(11);

        Integer num = userMapper.addUser(user);
        System.out.println("num =====" + num);
    }

    /**
     * 测试添加用户返回主键
     */
    @Test
    public void addUserHasKey() throws Exception {
        User user = new User();
        user.setUserName("leilei");
        user.setUserPwd("sadad");
        user.setRealName("xxxxx");
        user.setNation("jp");
        user.setCardId(12);

        Integer num = userMapper.addUserHasKey(user);
        System.out.println("受影响行数 =====" + num);
        System.out.println("新建用户的主键为: " + user.getId());
    }

    /**
     * 测试添加用户返回主键(通用版)
     */
    @Test
    public void addUserHasKeyGeneral() throws Exception {
        User user = new User();
        user.setUserName("keybord");
        user.setUserPwd("sdadad");
        user.setRealName("fuck konami");
        user.setNation("jp");
        user.setCardId(14);

        Integer num = userMapper.addUserHasKeyGeneral(user);
        System.out.println("受影响行数 =====" + num);
        System.out.println("新建用户的主键为: " + user.getId());
    }

    /**
     * 测试批量添加用户
     */
    @Test
    public void addUserBatch() throws Exception {
        List<User> userList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUserName("kation" + i);
            user.setUserPwd("sao");
            user.setRealName("fuck konami");
            user.setNation("jp");
            user.setCardId(14 + i);
            userList.add(user);
        }
        Integer num = userMapper.addUserBatch(userList);
        System.out.println("num ====" + num);
    }


    /**
     * 测试根据用户id更新指定的用户
     *
     * @throws Exception
     */
    @Test
    public void updateUser() throws Exception {
        User user = new User();
        user.setId(17);
        user.setUserName("好饿啊");
        user.setUserPwd("该去吃饭了");
        user.setRealName("fuck konami");

        Integer num = userMapper.updateUser(user);
        System.out.println("受影响行数 =====" + num);
    }

    /**
     * 测试批量更新用户的密码
     */
    @Test
    public void updateUserBatch() throws Exception {
        Integer[] idx = new Integer[10];

        for (int i = 0; i < 10; i++) {
            idx[i] = 8 + i;
        }
        Integer num = userMapper.updateUserBatch(idx);
        System.out.println("num == ===" + num);
    }

    /**
     * 测试根据用户id删除指定用户
     */
    @Test
    public void deleteUser() throws Exception {
        userMapper.deleteUser(28);
    }

    /**
     * 测试根据用户id批量删除用户
     *
     * @throws Exception
     */
    @Test
    public void deleteUserBatch() throws Exception {
        List<Integer> list = new ArrayList<>();
        for (int i = 8; i <= 17; i++) {
            list.add(i);
        }
        Integer num = userMapper.deleteUserBatch(list);
        System.out.println(num);
    }

    /**
     *  测试映射一对一关系
     *  根据用户id查询用户card信息
     * @throws Exception
     */
    @Test
    public void queryUserCardByIdUse() throws Exception {
        UserCardDto userCardDto = userMapper.queryUserCardByIdUse(31);
        System.out.println(userCardDto);
//        System.out.println(userCardDto.getUserName());
    }

    /**
     *  测试映射一对多
     * @throws Exception
     */
    @Test
    public void queryUserCardAccountByIdUses() throws Exception {
        UserCardAccountDto userCardAccountDto = userMapper.queryUserCardAccountByIdUses(31);
        System.out.println(userCardAccountDto);
//        System.out.println(userCardDto.getUserName());
    }

}
