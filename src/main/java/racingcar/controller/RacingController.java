package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.service.RacingService;

import java.util.List;

public class RacingController {

    private RacingService racingService = new RacingService();
    private List<Car> cars;
    private int round;

    public List<String> getInputNames() {
        String input = Console.readLine();
        return racingService.stringToList(input);
    }

    public int getInputNum() {
        return Integer.parseInt(Console.readLine());
    }

    public void racingStart() {
        List<String> names = getInputNames();
        cars = racingService.generateCars(names);
        round = getInputNum();
        racing(round);
    }

    public void racing(int round) {
        for (int i = 0; i < round; i++) {
            cars = racingService.attempt(cars);
        }
        fiinishRacing();
    }

    public void fiinishRacing() {
        List<String> winners = racingService.pickWinner(cars);
        racingService.printWinners(winners);
    }
}
