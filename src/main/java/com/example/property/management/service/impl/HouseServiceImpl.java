package com.example.property.management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.property.management.entity.House;
import com.example.property.management.mapper.HouseMapper;
import com.example.property.management.service.IHouseService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 楼盘信息表 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2020-03-01
 */
@Service
public class HouseServiceImpl extends ServiceImpl<HouseMapper, House> implements IHouseService {

}
