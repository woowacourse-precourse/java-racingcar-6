package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.utils.StringConstants;

public class OutputView {
    public static void printRequestInputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
    public static void printRequestInputRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printCarsStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(getCarStatusString(car));
        }
        System.out.println();
    }

    private static String getCarStatusString(Car car) {
        String carPositionString = createDashString(car.getPosition().getPosition());
        return car.getName() + " : " + carPositionString;
    }

    private static String createDashString(int count) {
        return StringConstants.CURRENT_POSITION.getValue().repeat(Math.max(0, count));
    }
}
