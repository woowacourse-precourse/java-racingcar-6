package racingcar.view;

import racingcar.controller.RacingController;
import racingcar.model.Car;

import java.util.List;

public class OutputView {

    private OutputView() {}

    private static class OutputViewCreater {
        private static final OutputView INSTANCE = new OutputView();
    }

    public static OutputView getInstance() { return OutputViewCreater.INSTANCE; }

    private final static RacingController racingController = RacingController.getInstance();

    public void printRoundResult(int currentRound, int totalRound, List<Car> cars) {
        if (currentRound == 1) {
            System.out.println();
            System.out.println("실행 결과");
        }
        for (Car car : cars) {
            printEachCar(car);
        }
        System.out.println();

        // TODO: round 가 마지막이면, controller 의 '우승 출력' 함수로 요청
    }

    private void printEachCar(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i=0; i<car.getMoveCount(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
