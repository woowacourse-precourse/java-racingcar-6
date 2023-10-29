package domain;

import util.UserInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Race {

    private static Race instance = new Race();

    private List<Car> cars;
    private int moveCount;

    private Race() {
        this.cars = new ArrayList<>();
        this.moveCount = 0;
    }

    public static Race getInstance() {
        if (instance == null) {
            instance = new Race();
        }
        return instance;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void start() {
        inputRaceDetails();
        runRace();
        declareWinner();
    }

    private void inputRaceDetails() {
        inputCarNames();
        inputMoveCount();
    }



}
