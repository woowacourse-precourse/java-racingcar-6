package racingcar.service;

import java.util.Stack;
import racingcar.controller.MessageDto;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Race;

public class RefereeService {
    private static final String RACE_RESULT_DELIMITER = ", ";

    public String getRoundResult(Cars cars) {
        StringBuilder builder = new StringBuilder();
        for (Car car : cars.getCars()) {
            builder.append(car.getCarInfo());
        }
        builder.append(System.lineSeparator());
        return builder.toString();
    }

    public MessageDto announceWinners(Race race) {
        Stack<Car> winners = pickWinners(race.getCars());
        StringBuilder builder = new StringBuilder();
        builder.append(winners.get(0).getName());
        for (int i = 1; i < winners.size(); ++i) {
            builder.append(RACE_RESULT_DELIMITER).append(winners.get(i).getName());
        }
        return new MessageDto(builder.toString());
    }

    public Stack<Car> pickWinners(Cars cars) {
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
}
