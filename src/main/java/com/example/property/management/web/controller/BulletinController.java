package com.example.property.management.web.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.property.management.web.application.BulletinApplicationService;
import com.example.property.management.web.command.BulletinCreate;
import com.example.property.management.web.command.BulletinUpdate;
import com.example.property.management.web.dto.BulletinDto;
import com.example.property.management.web.request.ApiPageRequest;
import com.example.property.management.web.request.ApiRequest;
import com.example.property.management.web.response.ApiPageResponse;
import com.example.property.management.web.response.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.property.management.web.response.ApiResponse.createSuccess;

/**
 * <p>
 * 小区公告表 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2020-03-01
 */
@Api(tags = "小区公告管理")
@RestController
@RequestMapping("/api/bulletin")
public class BulletinController {

    private final BulletinApplicationService bulletinApplicationService;

    public BulletinController(BulletinApplicationService bulletinApplicationService) {
        this.bulletinApplicationService = bulletinApplicationService;
    }

    @ApiOperation("新增公告")
    @PostMapping("/create")
    public ApiResponse<Void> create(@Validated @RequestBody ApiRequest<BulletinCreate> request) {
        bulletinApplicationService.create(request.getCommand());
        return createSuccess();
    }

    @ApiOperation("公告详情")
    @GetMapping("/{bulletinId}")
    public ApiResponse<BulletinDto> detail(@PathVariable String bulletinId) {
        BulletinDto result = bulletinApplicationService.detail(bulletinId);
        return ApiResponse.createSuccess(result);
    }

    @ApiOperation("公告列表")
    @PostMapping("/list")
    public ApiPageResponse<List<BulletinDto>> listPage(@Validated @RequestBody ApiPageRequest<Void> request) {
        Page<BulletinDto> result = bulletinApplicationService.list(request.getPageable());
        return ApiPageResponse.createPageSuccess(result);
    }

    @ApiOperation("更新公告")
    @PostMapping("/update")
    public ApiResponse<Void> update(@Validated @RequestBody ApiRequest<BulletinUpdate> request) {
        bulletinApplicationService.update(request.getCommand());
        return createSuccess();
    }
}

