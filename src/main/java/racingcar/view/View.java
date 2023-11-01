package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class View {
    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_ATTEMPTS_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printAttemptsMessage() {
        System.out.println(ASK_ATTEMPTS_MESSAGE);
    }

    public void printCurrentStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(createStatus(car));
        }
        System.out.println();
    }

    private String createStatus(Car car) {
        return car.getName() + " : " + "-".repeat(car.getPosition());
    }

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }
}
