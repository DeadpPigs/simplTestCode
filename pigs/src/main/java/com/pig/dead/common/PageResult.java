package com.pig.dead.common;

import com.pig.dead.base.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class PageResult<T> extends BaseQuery {
    private Long total;
    private List<T> result;
}
