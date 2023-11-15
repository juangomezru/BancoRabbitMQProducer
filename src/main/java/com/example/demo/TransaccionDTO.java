package com.example.demo;

import lombok.Data;

import java.time.LocalTime;
import java.util.UUID;

@Data
public class TransaccionDTO {
    private String id = UUID.randomUUID().toString();
    private String cuentaOrigen;
    private String cuentaDestino;
    private double cantidad;
    private String fechaTransaccion = LocalTime.now().toString();
}
