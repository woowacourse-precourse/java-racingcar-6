package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarStorage {
    private static List<Car> winners;
    private static List<Car> cars;
    private static List<Integer> stepsList;
    public CarStorage() {}
    public static void init() { // GameManager에서 1번만 호출
        cars = new ArrayList<>();
        winners = new ArrayList<>();
        stepsList = new ArrayList<>();
    }
}
