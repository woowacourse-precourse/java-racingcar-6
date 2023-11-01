package racingcar.view;

import racingcar.controller.RacingController;
import racingcar.model.Car;

import java.util.List;
import java.util.stream.Collectors;

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
        if (currentRound == totalRound) {
            racingController.decideWinner();
        }
    }

    public void printWinners(List<Car> winners) {
        List<String> winnerNames = winners.stream().map(Car::getName).collect(Collectors.toList());
        System.out.print("최종 우승자 : ");
        if (winnerNames.size() == 1) {
            System.out.print(winnerNames.get(0));
        }
        else {
            System.out.print(String.join(", ",winnerNames));
        }
    }

    private void printEachCar(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i=0; i<car.getMoveCount(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
