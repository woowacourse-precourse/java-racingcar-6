package racingcar.view;

import racingcar.domain.Cars;

public class OutputView {
    static private String STRING_START_GAME = "실행 결과";

    public void printStartGame() {
        System.out.println();
        System.out.println(STRING_START_GAME);
    }

    public void printCurrentGame(Cars cars) {
        cars.getCars().stream().forEach(car -> {
            System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
        });
    }
}
