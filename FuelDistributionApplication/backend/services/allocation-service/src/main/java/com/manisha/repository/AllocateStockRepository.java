package com.manisha.repository;

import com.manisha.entity.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllocateStockRepository extends JpaRepository<Allocation,Integer> {
}
