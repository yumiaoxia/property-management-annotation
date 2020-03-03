package com.example.property.management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.property.management.entity.Admin;
import com.example.property.management.mapper.AdminMapper;
import com.example.property.management.service.IAdminService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2020-03-01
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

}
