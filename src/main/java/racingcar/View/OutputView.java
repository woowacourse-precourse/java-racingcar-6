package racingcar.View;

import java.util.Queue;

import racingcar.Model.Car;

public class OutputView {
    private static final String MSG_RESULT = "\n실행 결과";
    private static final String MSG_WINNER = "최종 우승자 : ";

    public void printResultInit() {
        System.out.println(MSG_RESULT);
    }

    public void printRaceProgress(Car car) {
        String carName = car.getCarName();
        String carProgress = car.getProgress();
        System.out.println(carName + " : " + carProgress);
    }

    public void printFinalWinners(Queue<String> finalWinners) {
        String result = String.join(", ", finalWinners);
        System.out.println(MSG_WINNER + result);
    }
}
