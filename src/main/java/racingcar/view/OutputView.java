package racingcar.view;

import java.util.List;
import racingcar.constant.Message;
import racingcar.model.Car;
import racingcar.model.CarRepository;
import racingcar.util.StringUtil;

public class OutputView {
    public static void printResult() {
        System.out.println(Message.RESULT);
    }

    public static void printCarsResult(CarRepository carList) {
        for (Car car : carList.getCarList()) {
            printCarResult(car);
        }
        System.out.println();
    }

    private static void printCarResult(Car car) {
        String result = car.getName() + " : ";
        for(int i=0; i<car.getGo(); i++) {
            result += "-";
        }
        System.out.println(result);
    }

    public static void printWinner(CarRepository carList) {
        System.out.print(Message.WINNER);
        printWinners(carList.getWinners());
    }

    private static void printWinners(List<Car> winners) {
        System.out.println(StringUtil.convertListToString(winners));
    }
}
