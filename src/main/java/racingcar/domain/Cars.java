package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.vaildator.InputValidator;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.Constant.EXCEPTION_MESSAGE;
import static racingcar.vaildator.InputValidator.isValidLengthCarNames;

public class Cars {

    List<Car> cars = new ArrayList<>();

    public Cars(String nameBeforeSeparation){
        List<String> carNames = Arrays.asList(nameBeforeSeparation.split(","));

        if(!isValidLengthCarNames(carNames)){
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }

        cars = MakeCar(carNames);
    }

    private List<Car> MakeCar(List<String> carNames) {
        return carNames.stream().map(Car::new).toList();
    }



}
