package com.pig.dead.base;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class BaseQuery {
    @Min(value = 1,message = "最小页数为1")
    @Max(value = Integer.MAX_VALUE,message = "最大页数为int的最大值")
    private Integer current;
    @Min(value = 10,message = "最小显示数量为10")
    @Max(value = 300,message = "最大显示数量为300")
    private Integer pageSize;
}
