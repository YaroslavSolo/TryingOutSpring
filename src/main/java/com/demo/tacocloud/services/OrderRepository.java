package com.demo.tacocloud.services;

import com.demo.tacocloud.entities.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;


public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findByDeliveryZip(String deliveryZip);

    List<Order> findByDeliveryZipAndPlacedAtBetween(String zip, Date startDate, Date endDate);

    List<Order> findByDeliveryCityIgnoringCase(String deliveryCity);

}
