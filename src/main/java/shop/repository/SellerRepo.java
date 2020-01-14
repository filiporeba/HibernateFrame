package shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.model.Seller;

@Repository
public interface SellerRepo extends JpaRepository<Seller,Integer> {

}
