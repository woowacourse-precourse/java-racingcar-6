package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class RacingGameView {

    public static final String INPUT_FOR_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_FOR_ATTEMPTS = "시도할 회수는 몇회인가요?";

    public void inputForCarNames() {
        System.out.println(INPUT_FOR_CAR_NAMES);
    }

    public void inputForAttempts(){
        System.out.println(INPUT_FOR_ATTEMPTS);
    }

    public void printRoundResults(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getPositionString());
        }
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        System.out.print("최종 우승자 : ");
        if (winners.size() == 1) {
            printSingleWinner(winners.get(0));
        } else {
            printMultipleWinners(winners);
        }
    }

    private void printSingleWinner(Car winner) {
        System.out.print(winner.getName());
    }

    private void printMultipleWinners(List<Car> winners) {
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
