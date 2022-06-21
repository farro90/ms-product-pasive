package com.nttdata.bc19.msproductpasive.service.impl;

import com.nttdata.bc19.msproductpasive.exception.ModelNotFoundException;
import com.nttdata.bc19.msproductpasive.model.PasiveProduct;
import com.nttdata.bc19.msproductpasive.repository.IPasiveProductRepository;
import com.nttdata.bc19.msproductpasive.service.IPasiveProductService;
import com.nttdata.bc19.msproductpasive.util.LogMessage;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.function.Consumer;

@Service
public class PasiveProductServiceImpl implements IPasiveProductService {

    private final Logger LOGGER = LoggerFactory.getLogger("PasiveProductLog");
    private final String SAVESUCCESS = "SAVESUCCESS";
    private final String UPDATESUCCESS = "UPDATESUCCESS";
    private final String DELETESUCCESS = "DELETESUCCESS";
    @Autowired
    IPasiveProductRepository pasiveProductRepository;

    @Override
    public Mono<PasiveProduct> create(PasiveProduct pasiveProduct) {
        pasiveProduct.setId(new ObjectId().toString());
        pasiveProduct.setCreatedAt(LocalDateTime.now());
        return pasiveProductRepository.save(pasiveProduct).doOnSuccess(this.doOnSucess(SAVESUCCESS));
    }

    @Override
    public Mono<PasiveProduct> update(PasiveProduct pasiveProduct) {
        pasiveProduct.setUpdatedAt(LocalDateTime.now());
        return pasiveProductRepository
                .findById(pasiveProduct.getId())
                .switchIfEmpty(Mono.error(new ModelNotFoundException(LogMessage.idNotFound)))
                .flatMap(personClientFind -> {
                    return pasiveProductRepository.save(pasiveProduct).doOnSuccess(this.doOnSucess(UPDATESUCCESS));
                });
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return pasiveProductRepository
                .findById(id)
                .switchIfEmpty(Mono.error(new ModelNotFoundException(LogMessage.idNotFound)))
                .flatMap(personClient -> {
                    return pasiveProductRepository.deleteById(id).doOnSuccess(this.doOnSucessDelete(DELETESUCCESS));
                });
    }

    @Override
    public Mono<PasiveProduct> findById(String id) { return pasiveProductRepository.findById(id).switchIfEmpty(Mono.error(new ModelNotFoundException(LogMessage.idNotFound))); }

    @Override
    public Flux<PasiveProduct> findAll() {
        return pasiveProductRepository.findAll();
    }

    private Consumer<PasiveProduct> doOnSucess(String idLogMessage){
        return new Consumer<PasiveProduct>() {
            @Override
            public void accept(PasiveProduct personClient) {
                LOGGER.info(LogMessage.logMessage.get(idLogMessage));
            }
        };
    }

    private Consumer<Void> doOnSucessDelete(String idLogMessage){
        return new Consumer<Void>() {
            @Override
            public void accept(Void unused) {
                LOGGER.info(LogMessage.logMessage.get(idLogMessage));
            }
        };
    }
}
