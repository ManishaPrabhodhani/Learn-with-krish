package com.manisha.service;

import com.manisha.entity.Order;
import com.manisha.entity.Status;
import com.manisha.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderStatusService {

    @Autowired
    private StatusRepository statusRepository;


    public Status createStatus(Status status) {
        return statusRepository.save(status);
    }


    public List<Status> getAllOrderStatus()  {
        List<Status> status = (List<Status>) statusRepository.findAll();
        return status;
    }

    public Status findById(int id) {
        List<Status> list = statusRepository.findAll();
        Status status = new Status();
        for (Status sts : list) {
            if (sts.getOrderId() == id) {
              status.setStatusId(sts.getStatusId());
                status.setOrderId(sts.getOrderId());
                status.setScheduleStatus(sts.getScheduleStatus());
               status.setAllocationStatus(sts.getAllocationStatus());
                status.setDispatchStatus(sts.getDispatchStatus());

            }
        }
        return status;
    }
}
