package shop.controller;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import shop.model.Seller;
import shop.service.SellerService;

import java.util.List;


@RestController
@RequestMapping(value = "")
public class SellerController {

    private final SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping(value = "/sellers")
    public List<Seller> getSellers() {
        return sellerService.showSellers();
    }

    @GetMapping(value = "/sellers/{id}")
    public Seller getSeller(@PathVariable("id") Integer id) {
        return sellerService.getSellerById(id);
    }

    @PostMapping(value = "/sellers", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Seller addSeller(@RequestBody Seller seller) {
        return sellerService.save(seller);
    }

    @PutMapping(value = "/sellers")
    public Seller updateSelller(@RequestBody Seller seller) {
        return sellerService.save(seller);
    }

    @DeleteMapping(value = "/sellers/{id}")
    public void deleteSeller(@PathVariable Integer id) {
        sellerService.deleteSellerByID(id);
    }

}
