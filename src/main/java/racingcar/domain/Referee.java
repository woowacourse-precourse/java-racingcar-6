package racingcar.domain;

import java.util.Stack;

public class Referee {
    private static final String RACE_RESULT_MESSAGE = "최종 우승자 : ";

    public static void announceRoundResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getCarInfo());
        }
    }

    private static Stack<Car> pickWinners(Cars cars) {
        Stack<Car> winners = new Stack<>();
        for (Car car : cars.getCars()) {
            while (!winners.empty() && winners.peek().getMovedDistance() < car.getMovedDistance()) {
                winners.pop();
            }
            if (winners.empty() || winners.peek().getMovedDistance() == car.getMovedDistance()) {
                winners.push(car);
            }
        }
        return winners;
    }

    public static void announceWinners(Cars cars) {
        Stack<Car> winners = pickWinners(cars);
        System.out.print(RACE_RESULT_MESSAGE);
        System.out.print(winners.get(0).getName());
        for (int i = 1; i < winners.size(); ++i) {
            System.out.print(", " + winners.get(i).getName());
        }
    }
}
