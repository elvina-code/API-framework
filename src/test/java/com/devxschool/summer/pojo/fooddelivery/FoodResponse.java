package com.devxschool.summer.pojo.fooddelivery;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FoodResponse {
    private List<FoodRequest> foodCached;
}

