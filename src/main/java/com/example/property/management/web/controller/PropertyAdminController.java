package com.example.property.management.web.controller;


import com.example.property.management.web.application.PropertyAdminApplicationService;
import com.example.property.management.web.dto.ProAdminDto;
import com.example.property.management.web.response.ApiResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * 管理员 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2020-03-01
 */
@Controller
@RequestMapping("/propertyAdmin")
public class PropertyAdminController {

    private final PropertyAdminApplicationService propertyAdminApplicationService;

    public PropertyAdminController(PropertyAdminApplicationService propertyAdminApplicationService) {
        this.propertyAdminApplicationService = propertyAdminApplicationService;
    }

    @ApiOperation("物业管理员详情")
    @GetMapping("/detail/{adminId}")
    public ApiResponse<ProAdminDto> detail(@PathVariable String adminId) {
        ProAdminDto result = propertyAdminApplicationService.detail(adminId);
        return ApiResponse.createSuccess(result);
    }
}

