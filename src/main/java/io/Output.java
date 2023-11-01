package io;

import domain.Car;
import domain.Race;

import java.util.ArrayList;

public class Output {
    public static final String ROUND_MESSAGE = "실행 결과";
    public static final String RESULT_MESSAGE = "최종 우승자 :";

    public void printRoundResult() {
        System.out.println(ROUND_MESSAGE);
    }

    public void printWinnerList(ArrayList<Car> carList) {
        StringBuilder result = new StringBuilder();
        System.out.print(RESULT_MESSAGE);

        for (Car car: carList) {
            result.append(" " + car.getName() + ",");
        }
        result.deleteCharAt(result.length() - 1);

        System.out.println(result.toString());
    }
}
