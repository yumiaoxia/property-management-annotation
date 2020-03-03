package com.example.property.management.web.controller;


import com.example.property.management.web.application.OrderFeeApplicationService;
import com.example.property.management.web.command.OrderFeeCreate;
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
 * 各项费用详情 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2020-03-01
 */
@Api(tags = "物业费管理")
@RestController
@RequestMapping("/api/orderFee")
public class OrderFeeController {

    private final OrderFeeApplicationService orderFeeApplicationService;

    public OrderFeeController(OrderFeeApplicationService orderFeeApplicationService) {
        this.orderFeeApplicationService = orderFeeApplicationService;
    }

    @ApiOperation("新增物业费")
    @PostMapping("/create")
    public ApiResponse<Void> create(@Validated @RequestBody ApiRequest<OrderFeeCreate> request) {
        orderFeeApplicationService.create(request.getCommand());
        return ApiResponse.createSuccess();
    }

}

