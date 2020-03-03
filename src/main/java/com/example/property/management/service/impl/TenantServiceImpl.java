package com.example.property.management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.property.management.entity.Tenant;
import com.example.property.management.mapper.TenantMapper;
import com.example.property.management.service.ITenantService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 租客信息表 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2020-03-01
 */
@Service
public class TenantServiceImpl extends ServiceImpl<TenantMapper, Tenant> implements ITenantService {

}
