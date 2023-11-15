package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private Productor productor;

    public Controller(Productor productor) {
        this.productor = productor;
    }
    @PostMapping("/transaccion")
    public void enviarJson(@RequestBody TransaccionDTO transaccion){
        productor.enviarJson(transaccion);
    }
}
