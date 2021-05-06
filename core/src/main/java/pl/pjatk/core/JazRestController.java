package pl.pjatk.core;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class JazRestController {

    @GetMapping("/hello")
    public ResponseEntity<String> getHelloWorld(){


        return ResponseEntity.ok("Hello world");
    }
    @GetMapping("/model")
    public ResponseEntity<Car> getCar() {
        Car vw = new Car("vw");
        return ResponseEntity.ok(vw);
    }
    @PostMapping("/model")
    public ResponseEntity<Car> getCarPost(@RequestBody Car car) {

        return ResponseEntity.ok(car);
    }




}
