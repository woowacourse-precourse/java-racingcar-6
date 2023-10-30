package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final String DUPLICATED_NAME_ERROR_MESSAGE = "중복된 이름 삽입 불가";
    private static final String CARS_RANGE_ERROR_MESSAGE = "자동차의 개수는 1개 이상이어야 함";
    private List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

 
}
