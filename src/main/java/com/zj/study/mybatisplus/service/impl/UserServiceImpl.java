package com.zj.study.mybatisplus.service.impl;

import com.zj.study.mybatisplus.entity.User;
import com.zj.study.mybatisplus.mapper.UserMapper;
import com.zj.study.mybatisplus.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zj
 * @since 2021-06-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
