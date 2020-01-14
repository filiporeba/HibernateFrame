package shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.model.Seller;
import shop.repository.SellerRepo;

import java.util.List;


@Service
public class SellerService {

    private final SellerRepo sellerRepo;

    @Autowired
    public SellerService(SellerRepo sellerRepo) {
        this.sellerRepo = sellerRepo;
    }

    public List<Seller> showSellers() {
        return sellerRepo.findAll();
    }

    public Seller getSellerById(Integer id) {
        if(sellerRepo.findById(id).isPresent())
            return sellerRepo.findById(id).get();
        else
            return null;
    }

    public void deleteSellerByID(Integer id){
        sellerRepo.deleteById(id);
    }

    public Seller save(Seller seller){
        return sellerRepo.save(seller);
    }


}
