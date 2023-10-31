package view;

import model.Car;
import model.Winners;

import java.util.List;

/**
 * packageName    : view
 * fileName       : OutputView
 * author         : qkrtn_ulqpbq2
 * date           : 2023-10-26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-10-26        qkrtn_ulqpbq2       최초 생성
 */
public class OutputView {

    private static final String DISTANCE_MARK = "-";
    private static final String DELIMITER = ", ";
    private static final String WINNER_SENTENCE = "최종 우승자 : ";

    public static final String RUN_RESULT = "실행 결과";

    public static void printResultMessage() {
        System.out.println(RUN_RESULT);
    }

    public static void printCarsStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(getCarStatus(car));
        }
        System.out.println();
    }

    private static String getCarStatus(Car car) {
        String carPositionString = getGaugeBar(car.getPosition());
        return car.getName() + " : " + carPositionString;
    }

    private static String getGaugeBar(int cnt) {
        return DISTANCE_MARK.repeat(Math.max(0, cnt));
    }

    public static void printWinners(Winners winners) {
        System.out.println(WINNER_SENTENCE + String.join(DELIMITER, winners.getNames()));
    }
}
