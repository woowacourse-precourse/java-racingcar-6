package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

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

    public void startDrive(){
        carArrayList.forEach(Car::drive);
    }

    public void CheckWinner(){
        int max = carArrayList.stream()
                .max(Comparator.comparing(Car::getPosition))
                .get()
                .getPosition();

        ArrayList<String> winner = carArrayList.stream()
                .filter(car -> car.getPosition() == max)
                .map(car -> car.getName())
                .collect(Collectors.toCollection(()->new ArrayList<>()));
    }
}
