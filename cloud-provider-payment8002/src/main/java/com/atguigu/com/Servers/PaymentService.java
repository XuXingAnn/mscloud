package com.atguigu.com.Servers;

import com.atguigu.com.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    public int create(Payment payment);
    public Payment getPayment(Long id);
}
