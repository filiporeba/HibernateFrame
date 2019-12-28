package shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.model.Seller;
import shop.service.SellerService;

import java.util.Optional;

@RestController
public class SellerController {

    private final SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @RequestMapping("/hello")
    public Optional<Seller> showSeller() {
        Optional<Seller> seller = sellerService.showSellers();
        return seller;
    }


}
