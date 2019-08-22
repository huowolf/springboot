package com.huowolf.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huowolf.entity.User;
import com.huowolf.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huowolf
 * @since 2019-08-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IService<User> {

}
