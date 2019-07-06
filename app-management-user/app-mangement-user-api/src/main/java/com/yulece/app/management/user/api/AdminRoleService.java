package com.yulece.app.management.user.api;

import com.yulece.app.management.comments.api.entity.Page;
import com.yulece.app.management.comments.api.interceptor.FeignHeaderInterceptor;
import com.yulece.app.management.user.dto.AdminRoleAclDto;
import com.yulece.app.management.user.dto.AdminRoleDto;
import com.yulece.app.management.user.param.AdminRoleAclParam;
import com.yulece.app.management.user.param.AdminRoleParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Copyright © 2019 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: AdminRoleService
 * @Package com.yulece.app.management.user.api
 * @Description:
 * @Date 2019-03-10 09:22
 **/
@FeignClient(value = "app-management-user-provider", configuration = FeignHeaderInterceptor.class)
public interface AdminRoleService {

    @PostMapping("/role/save")
    Boolean save(@RequestBody AdminRoleParam param);

    @GetMapping("/role")
    AdminRoleDto getById(@RequestParam("id") Integer id);

    @PutMapping("/role/update" )
    Boolean update(@RequestBody AdminRoleParam param);

    @DeleteMapping("/role/{id}")
    Boolean delete(@PathVariable("id") Integer id);

    @PostMapping("/role/list")
    Page<AdminRoleDto> findAdminRoleByPage(@RequestBody AdminRoleParam param);

    @PostMapping("/role/addAdminRoleAcl")
    AdminRoleAclDto addAdminRoleAcl(@RequestBody AdminRoleAclParam param);

}
