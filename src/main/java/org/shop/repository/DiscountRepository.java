package org.shop.repository;

import org.shop.model.Discount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  DiscountRepository extends CrudRepository<Discount, Long>  {

}
