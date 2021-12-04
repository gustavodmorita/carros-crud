package br.com.gustavodm.carroscrud.services;

import br.com.gustavodm.carroscrud.model.Carro;
import br.com.gustavodm.carroscrud.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class CarroServiceV2 {

    @Autowired
    private CarroRepository repository;

    @Autowired
    private EntityManager em;

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
        //v2
        c.setCor(carro.getCor());
        c.setCombustivel(carro.getCombustivel());
        return repository.save(c);
    }

    public void delete(long id) throws Exception{
        Carro c = repository.findById(id).orElseThrow( () -> new Exception("Not Found!") );
        repository.delete(c);
    }

    //v2
    public List<Carro> listByMarca(String marca){
        String hql = "from Carro where marca like :marca order by marca";
        Query query = em.createQuery(hql);
        query.setParameter("marca", marca + "%");
        List<Carro> carro = query.getResultList();
        return carro;
    }

    public List<Carro> listByModelo(String modelo){
        String hql = "from Carro where modelo like :modelo order by modelo";
        Query query = em.createQuery(hql);
        query.setParameter("modelo", modelo + "%");
        List<Carro> carro = query.getResultList();
        return carro;
    }
}
