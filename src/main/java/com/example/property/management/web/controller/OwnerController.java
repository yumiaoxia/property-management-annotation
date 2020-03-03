package com.example.property.management.web.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.property.management.web.application.OwnerApplicationService;
import com.example.property.management.web.command.KeywordSearchCommand;
import com.example.property.management.web.command.OwnerCreate;
import com.example.property.management.web.command.OwnerUpdate;
import com.example.property.management.web.dto.OwnerDto;
import com.example.property.management.web.request.ApiPageRequest;
import com.example.property.management.web.request.ApiRequest;
import com.example.property.management.web.response.ApiPageResponse;
import com.example.property.management.web.response.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 业主信息表
 * 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2020-03-01
 */
@Api(tags = "业主管理")
@RestController
@RequestMapping("/api/owner")
public class OwnerController {

    @Autowired
    private OwnerApplicationService ownerApplicationService;

    @ApiOperation("新增业主")
    @PostMapping("/create")
    public ApiResponse<Void> create(@Validated @RequestBody ApiRequest<OwnerCreate> request) {
        ownerApplicationService.create(request.getCommand());
        return ApiResponse.createSuccess();
    }

    @ApiOperation("业主详情")
    @GetMapping("/{houseNumber}")
    public ApiResponse<OwnerDto> detail(@PathVariable String houseNumber) {
        OwnerDto owner = ownerApplicationService.detail(houseNumber);
        return ApiResponse.createSuccess(owner);
    }

    @ApiOperation("业主列表")
    @PostMapping("/list")
    public ApiPageResponse<List<OwnerDto>> listPage(@Validated @RequestBody ApiPageRequest<KeywordSearchCommand> request) {
        Page<OwnerDto> result = ownerApplicationService.list(request.getCommand(), request.getPageable());
        return ApiPageResponse.createPageSuccess(result);
    }

    @ApiOperation("删除业主")
    @DeleteMapping("/{houseNumber}")
    public ApiResponse<Void> delete(@PathVariable String houseNumber) {
        ownerApplicationService.delete(houseNumber);
        return ApiResponse.createSuccess();
    }

    @ApiOperation("更新业主")
    @PostMapping("/update")
    public ApiResponse<Void> update(@Validated @RequestBody ApiRequest<OwnerUpdate> request) {
        ownerApplicationService.update(request.getCommand());
        return ApiResponse.createSuccess();
    }


}

