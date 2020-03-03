package com.example.property.management.web.application;

import com.example.property.management.constants.CommonConstants;
import com.example.property.management.entity.Order;
import com.example.property.management.exception.ErrorCode;
import com.example.property.management.exception.ServiceException;
import com.example.property.management.service.IOrderService;
import com.example.property.management.web.command.OrderDetail;
import com.example.property.management.web.dto.OrderDto;
import com.itsherman.dto.assembler.utils.DtoTransFormer;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class OrderApplicationService {

    private final IOrderService orderService;

    public OrderApplicationService(IOrderService orderService) {
        this.orderService = orderService;
    }

    @Transactional
    public OrderDto detail(OrderDetail command) {
        Order order = orderService.getById(command.getHouseNum());
        if (order == null) {
            throw ServiceException.of(ErrorCode.RESOURCE_NOT_FOUND, CommonConstants.ORDER);
        }
        return DtoTransFormer.to(OrderDto.class).apply(order);
    }


}
