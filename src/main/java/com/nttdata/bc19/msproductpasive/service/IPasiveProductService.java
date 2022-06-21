package com.nttdata.bc19.msproductpasive.service;

import com.nttdata.bc19.msproductpasive.model.PasiveProduct;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPasiveProductService {
    Mono<PasiveProduct> create(PasiveProduct pasiveProduct);
    Mono<PasiveProduct> update(PasiveProduct pasiveProduct);
    Mono<Void>deleteById(String id);
    Mono<PasiveProduct> findById(String id);
    Flux<PasiveProduct> findAll();
}
