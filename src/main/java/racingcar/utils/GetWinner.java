package racingcar.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

import main.java.racingcar.model.Car;
public class GetWinner {

    public static List<String> winnerList(List<Car> Users) {
        List<String> Winners = new ArrayList<>();
        int winnersPosition = winnerPosition(Users);
        for (Car car: Users) {
            if (isWinner(car, winnersPosition)) {
                Winners.add(car.getName());
            }
        }
        return Winners;
    }
    private static boolean isWinner(Car car, int winnersPosition) {
        return car.getPosition() == winnersPosition;
    }
    private static int winnerPosition(List<Car> Users) {
        return Users.stream().mapToInt(Car::getPosition).max().orElse(Integer.MIN_VALUE);
    }





}
