package com.example.property.management.web.controller;


import com.example.property.management.web.application.OrderApplicationService;
import com.example.property.management.web.command.OrderDetail;
import com.example.property.management.web.dto.OrderDto;
import com.example.property.management.web.request.ApiRequest;
import com.example.property.management.web.response.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2020-03-01
 */

@Api(tags = "家政预约")
@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderApplicationService orderApplicationService;

    public OrderController(OrderApplicationService orderApplicationService) {
        this.orderApplicationService = orderApplicationService;
    }

    @ApiOperation("家政预约详情")
    @PostMapping("/detail")
    public ApiResponse<OrderDto> detail(@Validated @RequestBody ApiRequest<OrderDetail> request) {
        OrderDto result = orderApplicationService.detail(request.getCommand());
        return ApiResponse.createSuccess(result);
    }
}

