package racingcar.controller;

import racingcar.model.Car;

public class Search {
    public static int searchMax(Car[] cars){
        int max = 0;
        int tmp;

        for (Car car : cars) {
            tmp = car.getScore();
            if (max < tmp) {
                max = tmp;
            }
        }
        return max;
    }
    public static String searchWinner(int max, Car[] cars){
        StringBuilder name = new StringBuilder();
        for (Car car : cars) {
            if (max == car.getScore()) {
                name.append(car.getName()).append(", ");
            }
        }
        name.delete(name.length() -2, name.length());
        return name.toString();
    }
}
