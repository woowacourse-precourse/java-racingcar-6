package racingcar.view;

import static racingcar.constant.MessageConst.*;

import java.util.List;
import racingcar.domain.Car;
import racingcar.util.ConvertUtil;

public class OutputView {

    public static void printResult() {
        System.out.println(MOVING_RESULT);
    }

    public static void printPosition(List<Car> cars) {
        for (Car car : cars) {
            int position = car.getPosition();
            System.out.println(car.getName() + " : " + ConvertUtil.convertPositionToStr(position));
        }
        System.out.println();
    }

    public static void printWinner(List<Car> cars) {
        System.out.println(FINAL_WINNERS + ConvertUtil.convertListCarToStr(cars));
    }

}
