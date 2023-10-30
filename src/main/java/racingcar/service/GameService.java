package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameService {

    private Input input = new Input();
    private Output output = new Output();
    private Validator validator = new Validator();

    public void play() {
        String[] carNames = validator.stringToArray(input.getCarNames());
        List<Car> cars = createCars(carNames);
    }


    private List<Car> createCars(String[] carNames) {
        return Arrays.stream(carNames).map(Car::new).collect(Collectors.toList());
    }

}
