package br.com.gustavodm.carroscrud.controller;


import br.com.gustavodm.carroscrud.model.Carro;
import br.com.gustavodm.carroscrud.services.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroService service;

    @PostMapping
    public Carro save(@RequestBody Carro carro){
        return service.save(carro);
    }

    @GetMapping
    public List<Carro> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Carro findById(@PathVariable("id") long id) throws Exception{
        return service.findById(id);
    }

    @PutMapping
    public Carro update(@RequestBody Carro carro) throws Exception{
        return service.update(carro);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) throws Exception{
        service.delete(id);
    }
}
