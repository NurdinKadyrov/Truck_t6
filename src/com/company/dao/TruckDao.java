package com.company.dao;

import com.company.model.Truck;

import java.util.ArrayList;
import java.util.List;

public class TruckDao {
    private final List<Truck>truckList=new ArrayList<>();

    public List<Truck> getTruckList() {
        return truckList;
    }
}
