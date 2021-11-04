package com.atguigu.com.Servers.impl;

import com.atguigu.com.Dao.PaymentDao;
import com.atguigu.com.Servers.PaymentService;
import com.atguigu.com.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        final int i = paymentDao.create(payment);
        return i;
    }

    @Override
    public Payment getPayment(@Param("id")Long id) {
        final Payment payment = paymentDao.getPayment(id);
        return payment;
    }
}
