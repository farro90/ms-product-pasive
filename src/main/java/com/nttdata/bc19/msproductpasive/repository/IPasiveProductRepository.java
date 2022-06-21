package com.nttdata.bc19.msproductpasive.repository;

import com.nttdata.bc19.msproductpasive.model.PasiveProduct;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPasiveProductRepository extends ReactiveMongoRepository<PasiveProduct, String> {
}
