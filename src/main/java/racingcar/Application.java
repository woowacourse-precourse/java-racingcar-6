package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Checker;
import racingcar.domain.NumberGenerator;
import racingcar.domain.UserInputManager;

public class Application {
    public static void main(String[] args) {

    }

    public static void printTurnInfo(List<Car> cars) {
        for (Car car: cars) {
            System.out.println(makeCarInfo(car));
        }
        System.out.println();
    }

    public static String makeCarInfo(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName()).append(" : ");

        for (int i = 0; i < car.getStraightCount(); i++) {
            sb.append("-");
        }

        return sb.toString();
    }
}
