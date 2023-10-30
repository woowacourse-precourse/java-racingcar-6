package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.service.RacingService;

import java.util.ArrayList;
import java.util.List;

public class RacingController {

    private RacingService racingService = new RacingService();
    private List<Car> cars;
    private int numOfRound;
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
        numOfRound = getInputNum();
    }
}
