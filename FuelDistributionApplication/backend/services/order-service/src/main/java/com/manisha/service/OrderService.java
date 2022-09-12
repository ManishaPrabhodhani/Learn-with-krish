package com.manisha.service;


import com.manisha.dto.OrderDetails;
import com.manisha.entity.Order;
import com.manisha.entity.Schedule;
import com.manisha.entity.Status;
import com.manisha.repository.OrderRepository;
import com.manisha.repository.ScheduleRepository;
import com.manisha.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private StatusRepository statusRepository;


    public Order createOrder(Order order) {
        return orderRepository.save(order);

    }


    public List<Order> getAllOrders() {
        List<Order> order= (List<Order>) orderRepository.findAll();
        return order;
    }


    // find dispatch details
    public List<OrderDetails> findDispatchOrderDetails() {
        List<Order> order = orderRepository.findAll();
        List<Status> status = statusRepository.findAll();
        List<Schedule> schedule = scheduleRepository.findAll();
        List<OrderDetails> details = new ArrayList<>();

        for (Order odr : order) {
            for (Status st : status) {
                for (Schedule sch : schedule) {
                    if (odr.getOrderId() == st.getOrderId() && odr.getOrderId() == sch.getOrderId() && st.getDispatchStatus().equals("SUCCESSFUL")) {
                        OrderDetails orderDetails = new OrderDetails();
                        orderDetails.setOrderId(odr.getOrderId());
                        orderDetails.setFuelStationRegNo(odr.getFuelStationRegNo());
                        orderDetails.setFuelStationName(odr.getFuelStationName());
                        orderDetails.setAddress(odr.getAddress());
                        orderDetails.setContactNo(odr.getContactNo());
                        orderDetails.setFuelType(odr.getFuelType());
                        orderDetails.setFuelQty(odr.getFuelQty());
                        orderDetails.setScheduleDate(odr.getScheduleDate());
                        orderDetails.setAllocationStatus(st.getAllocationStatus());
                        orderDetails.setScheduleStatus(st.getScheduleStatus());
                        orderDetails.setDispatchStatus(st.getDispatchStatus());

                        details.add(orderDetails);

                    }
                }
            }
        }
        return details;

    }

    // find order details by station registration number
    public List<OrderDetails> findOrderByStationRegNo(String id) {

        List<Order> order = orderRepository.findAll();
        List<Status> status = statusRepository.findAll();
        List<Schedule> schedule = scheduleRepository.findAll();
        List<OrderDetails> details = new ArrayList<>();

        for (Order odr : order) {
            for (Status st : status) {
                for (Schedule sch : schedule) {
                    if (odr.getFuelStationRegNo().equals(id)) {
                        if (odr.getOrderId() == st.getOrderId() && odr.getOrderId() == sch.getOrderId()) {

                            OrderDetails orderDetails = new OrderDetails();

                            orderDetails.setOrderId(odr.getOrderId());
                            orderDetails.setFuelStationRegNo(odr.getFuelStationRegNo());
                            orderDetails.setFuelStationName(odr.getFuelStationName());
                            orderDetails.setAddress(odr.getAddress());
                            orderDetails.setContactNo(odr.getContactNo());
                            orderDetails.setFuelType(odr.getFuelType());
                            orderDetails.setFuelQty(odr.getFuelQty());
                            orderDetails.setScheduleDate(odr.getScheduleDate());
                            orderDetails.setAllocationStatus(st.getAllocationStatus());
                            orderDetails.setScheduleStatus(st.getScheduleStatus());
                            orderDetails.setDispatchStatus(st.getDispatchStatus());

                            details.add(orderDetails);
                        }
                    }
                }
            }

        }
        return details;
    }
}

