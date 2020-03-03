package com.example.property.management.web.application;

import com.example.property.management.entity.OrderFee;
import com.example.property.management.service.IOrderFeeService;
import com.example.property.management.web.command.OrderFeeCreate;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class OrderFeeApplicationService {

    private final IOrderFeeService orderFeeService;

    public OrderFeeApplicationService(IOrderFeeService orderFeeService) {
        this.orderFeeService = orderFeeService;
    }

    @Transactional
    public void create(OrderFeeCreate command) {
        OrderFee orderFee = new OrderFee();
        BeanUtils.copyProperties(command, orderFee);
        orderFeeService.save(orderFee);
    }
}
