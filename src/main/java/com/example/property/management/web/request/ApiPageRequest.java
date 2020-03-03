package com.example.property.management.web.request;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * <p> </p>
 *
 * @author 俞淼霞
 * @since 2019-09-03
 */
public class ApiPageRequest<T> extends ApiRequest<T> {

    @Min(0)
    @JsonProperty
    @ApiModelProperty(value = "页码", example = "0")
    private Integer pageNo;

    @Min(0)
    @JsonProperty
    @NotNull
    @ApiModelProperty(value = "每页记录数", example = "20")
    private Integer pageSize;

    @JsonProperty
    @ApiModelProperty(value = "排序类型,1——升序，2——降序。顺序跟sortProperties中的字段的顺序一一对应")
    private Integer[] directions;

    @JsonProperty
    @ApiModelProperty(value = "排序字段,顺序跟directions中的排序类型的顺序一一对应")
    private String[] sortColumns;

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setDirections(Integer[] directions) {
        this.directions = directions;
    }

    public void setSortColumns(String[] sortColumns) {
        this.sortColumns = sortColumns;
    }

    @JsonIgnore
    public <U> Page<U> getPageable() {
        List<OrderItem> orderItems = getOrderItems();
        Page<U> pageable = null;
        if (pageSize != null && pageNo != null) {
            pageable = new Page<>(pageNo.longValue(), pageSize.longValue());
        } else {
            pageable = new Page<>(0, 20);
        }
        pageable.addOrder(getOrderItems());
        return pageable;
    }

    private List<OrderItem> getOrderItems() {
        List<OrderItem> orderItems = new ArrayList<>();
        if (this.directions != null && this.sortColumns != null && this.directions.length == this.sortColumns.length) {
            for (int i = 0; i < sortColumns.length; i++) {
                OrderItem orderItem = new OrderItem();
                if (directions[i].equals(1)) {
                    orderItem.setAsc(true);
                } else if (directions[i].equals(2)) {
                    orderItem.setAsc(false);
                } else {
                    continue;
                }
                orderItem.setColumn(sortColumns[i]);
                orderItems.add(orderItem);
            }
        }
        return orderItems;
    }


    @Override
    public String toString() {
        return "ApiPageRequest{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", directions=" + directions +
                ", sortProperties=" + sortColumns +
                '}';
    }
}
