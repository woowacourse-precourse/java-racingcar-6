package model;

import java.util.ArrayList;

public class Race {
    int laps;
    ArrayList<Car> cars = new ArrayList<>();

    public Race(int laps){
        this.laps = laps;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public int getLaps() {
        return laps;
    }
}
