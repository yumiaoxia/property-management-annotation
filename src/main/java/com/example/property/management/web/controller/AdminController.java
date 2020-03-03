package com.example.property.management.web.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.property.management.web.application.AdminApplicationService;
import com.example.property.management.web.dto.AdminDto;
import com.example.property.management.web.request.ApiPageRequest;
import com.example.property.management.web.response.ApiPageResponse;
import com.example.property.management.web.response.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 管理员 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2020-03-01
 */
@Api(tags = "管理员")
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminApplicationService adminApplicationService;

    public AdminController(AdminApplicationService adminApplicationService) {
        this.adminApplicationService = adminApplicationService;
    }

    @ApiOperation("系统管理员列表")
    @PostMapping("/list")
    public ApiPageResponse<List<AdminDto>> listPage(@Validated @RequestBody ApiPageRequest<Void> request) {
        Page<AdminDto> result = adminApplicationService.list(request.getPageable());
        return ApiPageResponse.createPageSuccess(result);
    }

    @ApiOperation("详情")
    @GetMapping("/{adminId}")
    public ApiResponse<AdminDto> detail(@PathVariable String adminId) {
        AdminDto result = adminApplicationService.detail(adminId);
        return ApiResponse.createSuccess(result);
    }

}

