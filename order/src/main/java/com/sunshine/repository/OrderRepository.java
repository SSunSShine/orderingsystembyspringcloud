package com.sunshine.repository;

import com.sunshine.entity.Order;

import java.util.List;

public interface OrderRepository {
    public void save(Order order);
    public List<Order> findAllByUid(int index, int limit,long uid);
    public int countByUid(long uid);
    public List<Order> findAll(int index,int limit);
    public void updateState(long id);
    public int countByState();
}
