package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        Referee referee = new Referee();
        int cycle = referee.inputCycle();
        List<String> carNames = referee.splitStringCarName();

        Judgment judgment = new Judgment();
        List<Car> cars = referee.cars(carNames);

        for (int i = 0; i < cycle; i++) {
            judgment.printRunResuEachCase(cars);
        }

        judgment.getMovement(cars);
        judgment.extractWinnerCarIndex();
        List<String> winners = judgment.getWinnerCarName();

        System.out.print("최종우승자 : ");
        //공동 우승 true
        if (judgment.checkJointWinner()) {
            System.out.println(String.join(",", winners));
        } else {
            System.out.print(winners);
        }
    }
}
