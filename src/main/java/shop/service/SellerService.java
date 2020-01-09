package shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import shop.model.Seller;
import shop.repository.SellerRepo;

import java.util.Optional;

@Service
public class SellerService {

    private final SellerRepo sellerRepo;

    @Autowired
    public SellerService(SellerRepo sellerRepo) {
        this.sellerRepo = sellerRepo;
        Seller seller = new Seller("Test","Test",33,33,"Test");
        sellerRepo.save(seller);
    }

    public Optional<Seller> showSellers() {
        Optional<Seller> seller = sellerRepo.findById(1);
        return seller;
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void init() {
//        Seller seller = new Seller("Test","Test",33,33,"Test");
//        sellerRepo.save(seller);
//    }

    //clone checkinggg



}
