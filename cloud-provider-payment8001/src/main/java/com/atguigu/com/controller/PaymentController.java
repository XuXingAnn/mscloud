package com.atguigu.com.controller;

import com.atguigu.com.Servers.PaymentService;
import com.atguigu.com.entities.CommonResult;
import com.atguigu.com.entities.Payment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private Integer port;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        final int i = paymentService.create(payment);
        if(i >=0){
            return new CommonResult(200,"数据插入成功" + "端口 ： " + port,i);
        }else {
            return new CommonResult(400,"数据插入失败",null);
        }
    }


    @GetMapping("/payment/get/{id}")
    public CommonResult getpayment(@PathVariable("id") Long id){
        final Payment payment = paymentService.getPayment(id);
        if(payment != null){
            return new CommonResult(200,"数据插入成功" + "端口 ： " + port,payment);
//            return new CommonResult(200,"数据查询成功",payment);
        }else {
            return new CommonResult(400,"数据查询失败",null);
        }
    }

    @Autowired
    private DiscoveryClient discoveryClient;
    @GetMapping(value = "/payment/discovery")
    public Object discoery(){
        final List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("**************" + service);
        }
        final List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return discoveryClient;
    }
}
