package model;

import java.util.ArrayList;

public class Race {
    int laps;
    ArrayList<Car> carArrayList = new ArrayList<>();

    public Race(int laps, ArrayList<Car> carArrayList){
        this.laps = laps;
        this.carArrayList = carArrayList;
    }

    public ArrayList<Car> getCarArrayList() {
        return carArrayList;
    }

    public int getLaps() {
        return laps;
    }
}
