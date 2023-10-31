package service;

import camp.nextstep.edu.missionutils.Console;
import model.Car;
import model.RacingCar;
import validate.Validator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingService {
    public static ArrayList<Car> createCar(String carlist){
        String[] cars = carlist.split(", ");
        return Stream
                .of(cars)
                .map(name -> new RacingCar(Validator.checkName(name)))
                .collect(Collectors.toCollection(() -> new ArrayList<Car>()));
    }

    public static int inputLaps(String input){
        return Validator.checkNum(input);
    }

    public static int findMax(ArrayList<Car> carArrayList){
        return carArrayList.stream()
                .max(Comparator.comparing(Car::getPosition))
                .get()
                .getPosition();
    }

    public static ArrayList<String> findWinner(ArrayList<Car> carArrayList, int max){
        return carArrayList.stream()
                .filter(car -> car.getPosition() == max)
                .map(car -> car.getName())
                .collect(Collectors.toCollection(()->new ArrayList<>()));
    }
}
