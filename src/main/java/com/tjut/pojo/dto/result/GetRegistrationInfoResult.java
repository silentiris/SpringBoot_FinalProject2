package com.tjut.pojo.dto.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRegistrationInfoResult {
    private int total;
    List<Student> students = new ArrayList<>();
}
