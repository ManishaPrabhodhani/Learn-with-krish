package com.manisha.service;

import com.manisha.entity.Dispatch;
import com.manisha.repository.DispatchRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DispatchService {

    @Autowired
    DispatchRepository dispatchRepository;

    public Dispatch save(Dispatch dispatch) {
        return dispatchRepository.save(dispatch);
    }


    public List<Dispatch> getAllDispatch() {
        List<Dispatch> dispatch= (List<Dispatch>) dispatchRepository.findAll();
        return dispatch;
    }







}
