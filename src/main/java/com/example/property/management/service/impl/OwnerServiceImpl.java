package com.example.property.management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.property.management.entity.Owner;
import com.example.property.management.mapper.OwnerMapper;
import com.example.property.management.service.IOwnerService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 业主信息表
 * 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2020-03-02
 */
@Service
public class OwnerServiceImpl extends ServiceImpl<OwnerMapper, Owner> implements IOwnerService {

}
