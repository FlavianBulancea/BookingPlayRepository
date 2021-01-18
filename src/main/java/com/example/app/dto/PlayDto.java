package com.example.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayDto {

    private Long id;

    private Long theaterId;

    private String name;

    private Timestamp start;

    private Timestamp end;
}
