package dev_java._5.punch_clock.entities;

import java.time.LocalDateTime;

public record PunchClockListing(String message, LocalDateTime timeStamp) {
    public PunchClockListing(PunchClockDTO data){
        this("Ponto registrado com sucesso.", data.timeStamp());
    }
}
