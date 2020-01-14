package shop.service;


import org.hamcrest.Matchers;
import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import shop.model.Seller;
import shop.repository.SellerRepo;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;


public class SellerServiceTest {


    @Mock
    SellerRepo sellerRepo;

    @InjectMocks
    SellerService sellerService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    private final Seller seller = new Seller(1, "Test", "Test", 33, "Test");

    private List<Seller> sellerMockList() {
        List<Seller> sellers = new ArrayList<>();
        sellers.add(new Seller(1, "Test", "Test", 33, "Test"));
        sellers.add(new Seller(2, "Adam", "Surrname", 24, "Newbie"));
        sellers.add(new Seller(3, "Adam", "Surrname", 24, "Newbie"));
        return sellers;
    }

    @Test
    public void shouldFindSellerWithIdNrOne() {
        when(sellerRepo.findById(1)).thenReturn(Optional.of(seller));

        Optional<Seller> sellerById = Optional.ofNullable(sellerService.getSellerById(1));

        Assert.assertEquals(sellerById, Optional.of(seller));
    }


    @Test
    public void shouldReturnAllSellers() {
        when(sellerRepo.findAll()).thenReturn(sellerMockList());

        List<Seller> sellers = sellerService.showSellers();

        Assert.assertThat(sellers, Matchers.hasSize(3));
    }

    @Test
    public void shouldAddSeller() {
        when(sellerRepo.save(Mockito.any(Seller.class))).thenReturn(seller);

        Seller saveSeller = sellerService.save(new Seller());

        Assert.assertEquals(saveSeller, seller);
    }
}