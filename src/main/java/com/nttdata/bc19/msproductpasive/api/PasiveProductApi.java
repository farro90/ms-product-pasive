package com.nttdata.bc19.msproductpasive.api;

import com.nttdata.bc19.msproductpasive.model.PasiveProduct;
import com.nttdata.bc19.msproductpasive.service.IPasiveProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/product/pasive")
public class PasiveProductApi {
    @Autowired
    private IPasiveProductService pasiveProductService;

    @PostMapping
    public Mono<PasiveProduct> create(@RequestBody PasiveProduct pasiveProduct){ return pasiveProductService.create(pasiveProduct); }

    @PutMapping
    public Mono<PasiveProduct> update(@RequestBody PasiveProduct pasiveProduct){ return pasiveProductService.update(pasiveProduct); }

    @GetMapping
    public Flux<PasiveProduct> findAll(){
        return pasiveProductService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<PasiveProduct> findById(@PathVariable String id){ return pasiveProductService.findById(id); }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id){
        return pasiveProductService.deleteById(id);
    }
}
