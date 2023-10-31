package racingcar.view;

import java.util.List;
import racingcar.controller.Car;

public class DrawHistogram {

    public static String draw(Car car) {
        StringBuilder histogram = new StringBuilder();
        for (int i = 0; i < car.getLength(); i++) {
            histogram.append("-");
        }
        return histogram.toString();
    }

}