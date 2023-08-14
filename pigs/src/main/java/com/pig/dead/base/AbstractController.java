package com.pig.dead.base;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pig.dead.common.PageResult;
import com.pig.dead.common.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

public abstract class AbstractController<S extends IService<T>,T,Q extends BaseQuery> {
    private S service;
    @Resource
    public void setService(S service){this.service=service;}

    @GetMapping
    public Result<PageResult<T>> findAll(@Valid Q qo){
        Page<T> page = new Page<>(qo.getCurrent(),qo.getPageSize());
        Page<T> result = service.page(page);
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setCurrent((int)result.getCurrent());
        pageResult.setPageSize((int)result.getSize());
        pageResult.setTotal(result.getTotal());
        pageResult.setResult(result.getRecords());
        return Result.ok(pageResult);
    }
    @GetMapping("{id}")
    public Result<T> findById(@PathVariable String id){
        return Result.ok(service.getById(Long.parseLong(id)));
    }
    @PostMapping
    public Result<Boolean> save(@RequestBody T to){
        return Result.ok(service.save(to));
    }
    @PutMapping
    public Result<Boolean> edit(@RequestBody T to){
        return Result.ok(service.updateById(to));
    }
    @DeleteMapping
    public Result<Boolean> batchRemove(List<String> ids){
        return Result.ok(service.removeByIds(ids));
    }
    @DeleteMapping("{id}")
    public Result<Boolean> removeById(@PathVariable String id){
        return Result.ok(service.removeById(id));
    }

}
