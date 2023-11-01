package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Winners;

public class OutputView {
    private static final OutputView instance = new OutputView();

    public OutputView() {
    }

    public static OutputView getInstance() {
        return instance;
    }

    public static void printMainMessage() {
        StringBuilder mainMessage = new StringBuilder();
        mainMessage.append("\n").append(Message.OUTPUT_MAIN_MESSAGE.message);
        System.out.println(mainMessage);
    }

    public static void printCarsStatus(List<Car> cars) {
        cars.forEach(car -> {
            System.out.println(getCarStatus(car));
        });
        System.out.println();
    }

    private static String getCarStatus(Car car) {
        String carMoveBar = getMoveBar(car);
        return String.format(Message.OUTPUT_CARMOVE_FORMAT.message, car.getNickName(), carMoveBar);
    }

    private static String getMoveBar(Car car) {
        return "-".repeat(Math.max(0, car.getPosition()));
    }

    public static void printWinners(Winners winners) {
        System.out.println(String.format(Message.OUTPUT_WINNERS_FORMAT.message, winners.getWinners()));
    }

    private enum Message {
        OUTPUT_MAIN_MESSAGE("실행 결과"),
        OUTPUT_CARMOVE_FORMAT("%s : %s"),
        OUTPUT_WINNERS_FORMAT("최종 우승자 : %s");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
