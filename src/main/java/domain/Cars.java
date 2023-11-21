package domain;

import util.exception.ExceptionMessage;

import java.util.*;

public class Cars {

    private static final int ZERO = 0;
    private final List<Car> cars = new ArrayList<>();
    public Cars(String[] carNames){
        validateDuplicateName(carNames);
        init(carNames);
    }

    private void validateDuplicateName(String[] carNames){
        long distinctSize = Arrays.stream(carNames).distinct().count();
        if (distinctSize != carNames.length) {
            ExceptionMessage.CAR_DUPLICATED_NAME.throwException();
        }
    }

    private void init(String[] carNames){
        for (String carName : carNames) {
            cars.add(new Car(carName, ZERO));
        }
    }
}
