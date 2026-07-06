package com.padhai.backend.controller;

import com.padhai.backend.config.RazorpayConfig;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/payment")
@CrossOrigin("*")
public class PaymentController {

    private final RazorpayConfig config;

    public PaymentController(RazorpayConfig config) {
        this.config = config;
    }

    @PostMapping("/create-order")
    public ResponseEntity<String> createOrder() throws Exception {

        RazorpayClient client = new RazorpayClient(config.getKey(), config.getSecret());

        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", 499);
        orderRequest.put("currency", "INR");
        orderRequest.put("receipt", "course_001");

        Order order = client.orders.create(orderRequest);

        return ResponseEntity.ok(order.toString());
    }
    @PostMapping("/verify")
    public ResponseEntity<String> verifyPayment(@RequestBody Map<String, String> data) {

        String razorpayPaymentId = data.get("razorpay_payment_id");
        String razorpayOrderId = data.get("razorpay_order_id");
        String razorpaySignature = data.get("razorpay_signature");

        // Yahan signature verify karna hai

        return ResponseEntity.ok("Payment Verified");
    }


}