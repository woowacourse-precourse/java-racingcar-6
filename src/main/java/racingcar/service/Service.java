package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Cars;
import racingcar.utils.CarNameValidator;
import racingcar.utils.TrialNumberValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class Service {

    public static Cars setCars(String cars) {
        CarNameValidator validation = new CarNameValidator(cars);
        return new Cars(validation.NAMES);
    }

    public static int setTrialNumber(String num) {
        TrialNumberValidator validation = new TrialNumberValidator(num);
        return Integer.parseInt(validation.ROUND_NUM_STRING);
    }
}
