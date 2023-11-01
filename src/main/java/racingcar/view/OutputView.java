package racingcar.view;

import racingcar.model.Car;
import racingcar.util.Message;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printGameStartMessage() {
        printMessage(Message.NAME_INPUT_MESSAGE);
    }

    public static void printInputNumberMessage() {
        printMessage(Message.COUNT_INPUT_MESSAGE);
    }

    public static void printRoundResultMessage(List<Car> Cars) {
        // 따로 함수로 라운드 결과를 종합하는 것 만들기??
        printMessage(Message.ROUND_RESULT);
        for (Car car : Cars) {
            String moveBar = "";
            for (int j = 0; j < car.getDistance(); j++) {
                moveBar += Message.MOVE_PRINT;
            }
            System.out.println(car.getName() + " : " + moveBar);
        }
        System.out.println();
    }

    public static void printGameResultMessage(List<Car> Cars, int maxMove) {
        // 최종 우승자를 선정하는 것 함수 만들기??
        List<String> winnersArr = new ArrayList<>();
        for (Car car : Cars) {
            if (car.getDistance() == maxMove) {
                winnersArr.add(car.getName());
            }
        }
        String winner = String.join(", ", winnersArr);
        printMessage(Message.FINAL_WINNER + winner);
    }


}
