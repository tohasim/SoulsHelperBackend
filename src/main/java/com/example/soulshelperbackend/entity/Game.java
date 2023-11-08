package com.example.soulshelperbackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Game {
    @Id
    private int id;
    @Column(length = 550)
    private String summary;
    private String name;
    private int coverId;

    @Override
    public String toString() {
        return "Game{"+ '\n' +
                "name='" + name + ", \n" +
                "summary='" + summary + ", \n" +
                "coverId=" + coverId + "\n" +
                '}';
    }
}
