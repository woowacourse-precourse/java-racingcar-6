package model;

import service.RacingService;

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

    public ArrayList<String> CheckWinner(){
        int max = RacingService.findMax(carArrayList);
        ArrayList<String> winner = RacingService.findWinner(carArrayList, max);

        return winner;
    }
}
