package com.example.property.management.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itsherman.dto.assembler.utils.DtoAssembleUtils;
import com.itsherman.dto.assembler.utils.DtoTransFormer;

import java.util.List;
import java.util.stream.Collectors;

public class MyDtoTransformer extends DtoTransFormer {

    public static <R> PageHelper<R> toPage(Class<R> dtoClass) {
        return new MyDtoTransformer.PageHelper<>(dtoClass);
    }


    public static class PageHelper<R> {

        private Class<R> dtoClass;

        public PageHelper(Class<R> dtoClass) {
            this.dtoClass = dtoClass;
        }

        public <T> Page<R> apply(Page<T> tPage) {
            Page<R> rPage = new Page<>(tPage.getCurrent(), tPage.getSize());
            List<R> result = tPage.getRecords().stream().map((t) -> {
                return DtoAssembleUtils.assemble(this.dtoClass, new Object[]{t});
            }).collect(Collectors.toList());
            rPage.setRecords(result);
            return rPage;
        }
    }
}
