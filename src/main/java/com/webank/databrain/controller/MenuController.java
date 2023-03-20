package com.webank.databrain.controller;

import com.webank.databrain.service.MenuService;
import com.webank.databrain.vo.common.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/menu")
@Slf4j
public class MenuController {

    @Autowired
    private MenuService menuService;
    @PostMapping(value = "/getMenuByRole")
    public CommonResponse getMenuByRole() {
        return menuService.getMenuByRole();
    }
}
