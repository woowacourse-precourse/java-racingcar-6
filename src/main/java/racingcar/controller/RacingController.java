package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.NoticeType;
import racingcar.service.RacingService;

import java.util.List;

public class RacingController {

    private RacingService racingService = new RacingService();
    private List<Car> cars;
    private int round;

    public List<String> getInputNames() {
        System.out.println(NoticeType.GET_CARS.getMessage());
        String input = Console.readLine();
        return racingService.stringToList(input);
    }

    public int getInputNum() {
        System.out.println(NoticeType.GET_NUMBER_OF_ROUNDS.getMessage());
        return Integer.parseInt(Console.readLine());
    }

    public void racingStart() {
        List<String> names = getInputNames();
        cars = racingService.generateCars(names);
        round = getInputNum();
        racing(round);
    }

    public void racing(int round) {
        System.out.println(NoticeType.PRINT_ATTEMPT_RESULT.getMessage());
        for (int i = 0; i < round; i++) {
            cars = racingService.attempt(cars);
        }
        finishRacing();
    }

    public void finishRacing() {
        List<String> winners = racingService.pickWinner(cars);
        racingService.printWinners(winners);
    }
}
