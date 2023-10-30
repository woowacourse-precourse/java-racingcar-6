package view;

import model.Car;

import java.util.List;

import static util.Messages.RUN_RESULT;

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
    public static void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }

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
}
