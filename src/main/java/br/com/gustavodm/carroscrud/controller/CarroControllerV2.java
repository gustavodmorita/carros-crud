package br.com.gustavodm.carroscrud.controller;


import br.com.gustavodm.carroscrud.model.Carro;
import br.com.gustavodm.carroscrud.services.CarroService;
import br.com.gustavodm.carroscrud.services.CarroServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros/v2")//v2
public class CarroControllerV2 {

    @Autowired
    private CarroServiceV2 service;//v2

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

    //v2
    @GetMapping("/marca/{marca}")
    public List<Carro> listByMarca(@PathVariable("marca") String marca){
        return service.listByMarca(marca);
    }

    @GetMapping("/modelo/{modelo}")
    public List<Carro> listByModelo(@PathVariable("modelo") String modelo){
        return service.listByModelo(modelo);
    }
}
