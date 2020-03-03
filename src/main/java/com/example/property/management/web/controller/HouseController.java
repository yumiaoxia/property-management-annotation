package com.example.property.management.web.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.property.management.web.application.HouseApplicationService;
import com.example.property.management.web.command.HouseCreate;
import com.example.property.management.web.command.HouseUpdate;
import com.example.property.management.web.dto.HouseDto;
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
 * 楼盘信息表 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2020-03-01
 */
@Api(tags = "楼盘信息管理")
@RestController
@RequestMapping("/api/house")
public class HouseController {

    private final HouseApplicationService houseApplicationService;

    public HouseController(HouseApplicationService houseApplicationService) {
        this.houseApplicationService = houseApplicationService;
    }

    @ApiOperation("新增楼盘")
    @PostMapping("/create")
    public ApiResponse<Void> create(@Validated @RequestBody ApiRequest<HouseCreate> request) {
        houseApplicationService.create(request.getCommand());
        return createSuccess();
    }

    @ApiOperation("楼盘信息")
    @GetMapping("/{houseNum}")
    public ApiResponse<HouseDto> detail(@PathVariable String houseNum) {
        HouseDto result = houseApplicationService.detail(houseNum);
        return createSuccess(result);
    }

    @ApiOperation("楼盘列表")
    @PostMapping("/list")
    public ApiPageResponse<List<HouseDto>> listPage(@Validated @RequestBody ApiPageRequest<Void> request) {
        Page<HouseDto> result = houseApplicationService.list(request.getPageable());
        return ApiPageResponse.createPageSuccess(result);
    }

    @ApiOperation("删除楼盘")
    @DeleteMapping("/{houseNum}")
    public ApiResponse<Void> delete(@PathVariable String houseNum) {
        houseApplicationService.delete(houseNum);
        return createSuccess();
    }

    @ApiOperation("更新入住状态")
    @PostMapping("/update")
    public ApiResponse<Void> update(@Validated @RequestBody ApiRequest<HouseUpdate> request) {
        houseApplicationService.update(request.getCommand());
        return createSuccess();
    }


}

