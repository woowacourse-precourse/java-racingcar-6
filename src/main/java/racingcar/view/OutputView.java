package racingcar.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.model.Car;
import racingcar.model.Race;

public class OutputView {

    public static void printIndividualResultHeader() {
        System.out.println();
        System.out.println("실행 결과");
    }
    public static void printIndividualResult(Race race) {
        for (Car car : race.getCars()) {
            printCarNameAndPosition(car.getName(), car.getPosition());
        }
        System.out.println();
    }

    public static void printFinalResult(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private static void printCarNameAndPosition(String carName, int position) {
        printCarName(carName);
        printCarPosition(position);
    }

    private static void printCarName(String carName) {
        System.out.print(carName + " : ");
    }

    private static void printCarPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
