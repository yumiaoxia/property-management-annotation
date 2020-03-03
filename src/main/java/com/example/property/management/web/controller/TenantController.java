package com.example.property.management.web.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.property.management.web.application.TenantApplicationService;
import com.example.property.management.web.command.KeywordSearchCommand;
import com.example.property.management.web.command.TenantCreate;
import com.example.property.management.web.command.TenantUpdate;
import com.example.property.management.web.dto.TenantDto;
import com.example.property.management.web.request.ApiPageRequest;
import com.example.property.management.web.request.ApiRequest;
import com.example.property.management.web.response.ApiPageResponse;
import com.example.property.management.web.response.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 租客信息表 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2020-03-01
 */
@Api(tags = "租客管理")
@RestController
@RequestMapping("/api/tenant")
public class TenantController {

    private final TenantApplicationService tenantApplicationService;

    public TenantController(TenantApplicationService tenantApplicationService) {
        this.tenantApplicationService = tenantApplicationService;
    }

    @ApiOperation("新增租客")
    @PostMapping("/create")
    public ApiResponse<Void> create(@Validated @RequestBody ApiRequest<TenantCreate> request) {
        tenantApplicationService.create(request.getCommand());
        return ApiResponse.createSuccess();
    }

    @ApiOperation("租客详情")
    @GetMapping("/{tenantId}")
    public ApiResponse<TenantDto> detail(@PathVariable String tenantId) {
        TenantDto result = tenantApplicationService.detail(tenantId);
        return ApiResponse.createSuccess(result);
    }

    @ApiOperation("租客列表")
    @PostMapping("/list")
    public ApiPageResponse<List<TenantDto>> listPage(@Validated @RequestBody ApiPageRequest<KeywordSearchCommand> request) {
        Page<TenantDto> result = tenantApplicationService.list(request.getCommand(), request.getPageable());
        return ApiPageResponse.createPageSuccess(result);
    }


    @ApiOperation("删除租客")
    @DeleteMapping("/{tenantId}")
    public ApiResponse<Void> delete(@PathVariable String tenantId) {
        tenantApplicationService.delete(tenantId);
        return ApiResponse.createSuccess();
    }

    @ApiOperation("更新租客")
    @PostMapping("/update")
    public ApiResponse<Void> update(@Validated @RequestBody ApiRequest<TenantUpdate> request) {
        tenantApplicationService.update(request.getCommand());
        return ApiResponse.createSuccess();
    }


}

