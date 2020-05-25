package com.thcha.mini.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class CustomerRestReturnDto {
    private int count;
    private List<Data> data = new ArrayList<Data>();

    public void addListData(Data data) {
        this.data.add(data);
    }
}