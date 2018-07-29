package com.reportservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@FeignClient(name = "account-service")
interface AccountServiceProxy {

    @RequestMapping(value = "/accounts", method = GET)
    AccountsResource fetchAccounts(@RequestParam("page") Integer page, @RequestParam("size") Integer size);
}
