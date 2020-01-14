package shop.service;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.EmptyResultDataAccessException;
import shop.model.Gun;
import shop.repository.GunRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;


public class GunServiceTest {

    @Mock
    GunRepo gunRepo;

    @InjectMocks
    GunService gunService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    private  final Gun gun =  Gun.builder()
            .id(1)
            .producent("producent")
            .name("name")
            .category("category")
            .caliber(44F)
            .numberOfMissiles(12)
            .weigth(2.46F)
            .price(800F)
            .serialNumber(56456)
            .build();

    private List<Gun> mockGunList() {
        List<Gun> gunList = new ArrayList<>();
        gunList.add(new Gun(1, "producent", "name", "category", 0.44F, 12, 2.46F, 800F, 56456));
        gunList.add(new Gun(5, "test", "test", "test", 0.36F, 15, 1.46F, 450F, 55464));
        return gunList;
    }

    @Test
    public void shouldReturnRightSizeOfGunList() {
        when(gunRepo.findAll()).thenReturn(mockGunList());

        List<Gun> gunList = gunService.showAllGuns();

        assertEquals(2,gunList.size());
    }

    @Test
    public void shouldAddGunToDataBase() {
        when(gunRepo.save(Mockito.any(Gun.class))).thenReturn(gun);

        Gun gunToAdd = gunService.addGun(new Gun());

        assertEquals(gunToAdd, gun);
    }

    @Test
    public void shouldFindGunWithIdOne() {
        when(gunRepo.findById(1)).thenReturn(Optional.of(gun));

        Optional<Gun> gunToFind = Optional.ofNullable(gunService.findGunById(1));

        assertEquals(gunToFind, Optional.of(gun));
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void shouldThrowExceptionToFindPersonWithIdZero() {
        doThrow(EmptyResultDataAccessException.class).when(gunRepo).deleteById(0);

        gunService.deleteGunById(0);
    }

}