package racingcar.controller;

import static racingcar.constant.MessageConst.GET_TRY_COUNT_MESSAGE;
import static racingcar.constant.MessageConst.RESULT_MESSAGE;
import static racingcar.constant.MessageConst.SAVE_CAR_NAMES_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Stream;
import racingcar.service.CarService;

public class CarController {

    private final CarService carService = new CarService();

    public void save() {
        System.out.println(SAVE_CAR_NAMES_MESSAGE);
        List<String> carNames = stringToCollection(Console.readLine());
        carService.save(carNames);
    }

    private List<String> stringToCollection(String input) {
        return Stream.of(input.split(","))
                .toList();
    }

    public int getRaceCount() {
        System.out.println(GET_TRY_COUNT_MESSAGE);
        int raceCount = Integer.parseInt(Console.readLine());
        System.out.println(RESULT_MESSAGE);
        return raceCount;
    }

    public void forward() {
        carService.forward();
    }

    public void getRoundRaceResults() {
        System.out.println(carService.createRoundRaceResults());
    }

    public void getWinner() {
        System.out.println(carService.createWinner());
    }
}
