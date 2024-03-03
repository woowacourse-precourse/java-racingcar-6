package racingcar.view;

import java.util.List;

import racingcar.domain.Car;

public class OutputView {
    private static final String GREETING_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String WIN_MESSAGE = "최종 우승자 :";
    private static final String ERROR_MESSAGE = "[ERROR]: ";

    public static void printErrorMessage(String message) {
        System.out.println(ERROR_MESSAGE + message);
    }

    public static void printRoundResult(List<Car> carList) {
        for(Car car : carList) {
            System.out.printf("%s : %s\n", car.getName(), car.getStatus());
        }
        System.out.println();
    }
}
