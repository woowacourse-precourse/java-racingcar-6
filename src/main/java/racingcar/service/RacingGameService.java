package racingcar.service;

import racingcar.Domain.Car;
import racingcar.repository.CarRepository;
import racingcar.repository.RoundRepository;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.Util.ErrorMessage.*;
import static racingcar.Util.GameConstant.*;

public class RacingGameService {
    private final CarRepository carRepository = CarRepository.getInstance();
    private final RoundRepository roundRepository = RoundRepository.getInstance();


    public void acceptCarList() {
        String inputStream = readLine(); // readLine() 메소드를 사용하여 입력값을 받아옴
        if(inputStream.length() == EMPTY_INPUT_SIZE.getValue()) {
            throw new IllegalArgumentException(ERROR_EMPTY_PARTICIPATING_CAR.getMessage());
        }
        List<String> carNames = Arrays.asList(inputStream.split(","));
        carNames.stream().forEach(name -> {
            if (name.length() > CAR_NAME_MAX_LENGTH.getValue()) {
                throw new IllegalArgumentException(ERROR_CAR_NAME_MAX_LENGTH.getMessage());
            }
            if (name.length() < CAR_NAME_MIN_LENGTH.getValue()) {
                throw new IllegalArgumentException(ERROR_CAR_NAME_MIN_LENGTH.getMessage());
            }
            carRepository.save(name);
        });
    }

}
