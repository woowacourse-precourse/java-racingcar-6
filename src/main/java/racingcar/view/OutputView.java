package racingcar.view;

import java.util.List;
import racingcar.model.car.Car;

public class OutputView {
    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        return instance;
    }

    public void printResult() {
        System.out.println(Message.OUTPUT_RESULT.message);
    }

    private static StringBuilder resultDisplay(Car car) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < car.getPosition(); i++) {
            result.append("-");
        }
        return result;
    }

    public void printResultCarList(List<Car> carList) {
        for (Car car : carList) {
            System.out.printf(Message.OUTPUT_FORMAT.message, car.getName(), resultDisplay(car));
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.printf(Message.OUTPUT_WINNER.message, String.join(", ", winners));
    }

    public enum Message {
        OUTPUT_RESULT("실행 결과"),
        OUTPUT_FORMAT("%s : %s%n"),
        OUTPUT_WINNER("최종 우승자 : %s");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }

}
