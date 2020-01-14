package shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.model.Gun;
import shop.repository.GunRepo;

import java.util.List;


@Service
public class GunService {

    private final GunRepo gunRepo;

    @Autowired
    public GunService(GunRepo gunRepo) {
        this.gunRepo = gunRepo;
    }

    public List<Gun> showAllGuns() {
        return gunRepo.findAll();
    }

    public Gun findGunById(Integer id) {
        if(gunRepo.findById(id).isPresent())
            return gunRepo.findById(id).get();
        else
            return null;
    }

    public void deleteGunById(Integer id){
        gunRepo.deleteById(id);
    }

    public Gun addGun(Gun gun){
        return gunRepo.save(gun);
    }


}
