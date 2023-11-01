package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            playRacingGame();
        } catch (IllegalArgumentException e) {
            System.out.println("입력 오류: " + e.getMessage());
        }
    }

    public static void playRacingGame() {
        Referee referee = new Referee();
        List<String> carNames = referee.splitStringCarName();
        int cycle = referee.inputCycle();

        Judgment judgment = new Judgment();
        List<Car> cars = referee.cars(carNames);

        for (int i = 0; i < cycle; i++) {
            for (Car carMovement : cars) {
                carMovement.decideAction();
            }
            judgment.printRunResuEachCase(cars);
        }

        judgment.getMovement(cars);
        judgment.extractWinnerCarIndex();
        List<String> winners = judgment.getWinnerCarName();

        System.out.print("최종우승자 : ");
        if (judgment.checkJointWinner()) {
            System.out.println(String.join(",", winners));
        } else {
            System.out.print(winners);
        }
    }
}
