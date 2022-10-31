package com.uni.pnu.service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.uni.pnu.entity.OrderDetails;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private static final String AMOUNT = "amount";
    private static final String CURRENCY = "currency";
    private static final String KEY = "need to put your key here";
    private static final String SECRET_KEY = "need to put your key here";

    public OrderDetails createOrder(Double amount) {
        try {
            JSONObject orderRequest = new JSONObject();
            orderRequest.put(AMOUNT, (amount*100)); // amount in the smallest currency unit
            orderRequest.put(CURRENCY, "HTG");

            RazorpayClient razorpayClient = new RazorpayClient(
                    KEY,
                    SECRET_KEY
            );
           Order order = razorpayClient.orders.create(orderRequest);
           return processOrder(order);
        } catch (RazorpayException e) {
            // Handle Exception
            System.out.println(e.getMessage());
        }
        return null;
    }

    OrderDetails processOrder(Order order) {
        String orderId = order.get("id");
        String currency = order.get("currency");
        Integer amount = order.get("amount");

        return new OrderDetails(KEY, orderId, amount, currency);
    }
}
