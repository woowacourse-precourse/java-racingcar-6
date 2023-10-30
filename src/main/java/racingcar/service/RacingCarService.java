package racingcar.service;


import racingcar.domain.Car;
import racingcar.domain.CarList;
import racingcar.validation.RacingCarValidation;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RacingCarService {


    private final CarList carList;
    private final RacingCarValidation racingCarValidation;

    public RacingCarService(CarList carList, RacingCarValidation racingCarValidation) {
        this.carList = carList;
        this.racingCarValidation = racingCarValidation;
    }
    
}