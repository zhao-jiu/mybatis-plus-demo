package com.zj.study.test;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zj.study.mybatisplus.entity.User;
import com.zj.study.mybatisplus.mapper.UserMapper;
import com.zj.study.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


/**
 * @author ZhaoJiu
 * @CreateTime: 2021/6/25 10:21
 * @Description: MybatisPlus CRUD测试
 */
@SpringBootTest
public class TestMybatisPlus {

    @Resource
    UserMapper userMapper;

    @Autowired
    UserService userService;

    /**
     * 批量插入数据
     */
    @Test
    void insertBatch(){
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setName("Tom").setAge(20).setEmail("Tom@163.com");

        User user1 = new User();
        user1.setName("Jerry").setAge(22).setEmail("Jerry@163.com");

        User user2 = new User();
        user2.setName("Marry").setAge(18).setEmail("Marry@163.com");

        User user3 = new User();
        user3.setName("John").setAge(24).setEmail("John@163.com");

        User user4 = new User();
        user4.setName("Sandy").setAge(21).setEmail("Sandy@163.com");

        users.add(user);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        userService.saveBatch(users);

    }

    /**
     * 测试乐观锁
     */
    @Test
    void testVersion() {
        User user = new User();
        user.setName("tom111").setAge(20).setEmail("tom@163.com");
        userService.save(user);
        userService.list().forEach(System.out::println);
        user.setName("jerry111");
        userService.updateById(user);
        userService.list().forEach(System.out::println);
    }

    /**
     * 测试逻辑删除
     */
    @Test
    void testLogicDelete(){
        userMapper.deleteById(1408303360857796610L);
    }

    /**
     * 测试自动生成ID
     */
    @Test
    void testInsertAuto(){
        User user = new User();
        user.setName("tom").setAge(20).setEmail("tom@163.com");
        userService.saveOrUpdate(user);
    }

    /**
     * 保存或修改
     */
    @Test
    void saveOrUpdateUser() {
        User user = new User();
        user.setId(6L);
        user.setAge(18);
        user.setEmail("wangwu123@qq.com");
        user.setName("wangwu");

        userService.saveOrUpdate(user);
    }

    /**
     * 根据id查询
     */
    @Test
    void selectUserById() {
        User user = userMapper.selectById(3);
        System.out.println("user = " + user);
    }

    /**
     * 查询集合
     */
    @Test
    void selectList() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("age",20);
        List<User> userList = userMapper.selectList(queryWrapper);
        for (User user : userList) {
            System.out.println("user = " + user);
        }
    }

    /**
     * 分页查询
     */
    @Test
    void testPage() {
        Page<User> page = new Page<>();
        page.setCurrent(1);
        page.setSize(3);
        userService.page(page, null);

        List<User> userList = page.getRecords();
        for (User user : userList) {
            System.out.println("user = " + user);
        }
    }


}
