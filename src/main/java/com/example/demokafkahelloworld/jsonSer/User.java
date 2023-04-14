package com.example.demokafkahelloworld.jsonSer;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class User {
    private long id;
    private String name;
    private LocalDateTime crtDt;

    @Builder
    public User (long id, String name) {
        this.id = id;
        this.name = name;
        this.crtDt = LocalDateTime.now();
    }
}
