package shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.model.Client;

@Repository
public interface ClientRepo extends JpaRepository<Client,Integer> {
}
