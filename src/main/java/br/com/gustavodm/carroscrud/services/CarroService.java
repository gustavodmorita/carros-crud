package br.com.gustavodm.carroscrud.services;

import br.com.gustavodm.carroscrud.model.Carro;
import br.com.gustavodm.carroscrud.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository repository;

    public Carro save(Carro carro){
        return repository.save(carro);
    }

    public Carro findById(long id) throws Exception{
        return repository.findById(id).orElseThrow(() -> new Exception("Not Found!") );
    }

    public List<Carro> findAll(){
        return repository.findAll();
    }

    public Carro update(Carro carro) throws Exception{
        Carro c = repository.findById(carro.getId()).orElseThrow( () -> new Exception("Not Found!"));
        c.setMarca(carro.getMarca());
        c.setModelo(carro.getModelo());
        c.setAno(carro.getAno());
        return repository.save(c);
    }

    public void delete(long id) throws Exception{
        Carro c = repository.findById(id).orElseThrow( () -> new Exception("Not Found!") );
        repository.delete(c);
    }
}
