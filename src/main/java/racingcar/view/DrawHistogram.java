package racingcar.view;

import racingcar.controller.Car;

public class DrawHistogram {

    public static String draw(Car car) {
        StringBuilder histogram = new StringBuilder();
        for (int i = 0; i < car.getDistance(); i++) {
            histogram.append("-");
        }
        return histogram.toString();
    }

}