package shop.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import shop.model.Gun;
import shop.service.GunService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "")
public class GunController {

    private final GunService gunService;

    public GunController(GunService gunService) {
        this.gunService = gunService;
    }

    @GetMapping(value = "/guns")
    public List<Gun> getGuns() {
        return gunService.showAllGuns();
    }

    @GetMapping(value = "/guns/{id}")
    public Gun getGun(@PathVariable ("id") Integer id) {
        return gunService.findGunById(id);
    }

    @PostMapping(value = "/guns", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Gun addGun(@RequestBody Gun gun) {
        return gunService.addGun(gun);
    }

    @PutMapping(value = "/guns")
    public Gun updateGun(@RequestBody @Valid Gun gun) {
        return gunService.addGun(gun);
    }

    @DeleteMapping(value = "/guns/{id}")
    public void deleteGun(@PathVariable Integer id) {
        gunService.deleteGunById(id);
    }
}
