package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    
    private static final String INVALID_INPUT_MESSAGE = "잘못된 입력입니다.";
    private static final String NAME_SEPARATOR = ",";
    private final List<Car> cars = new ArrayList<>();
    
    public Cars(String names) {
        validate(names);
        saveCars(names);
    }
    
    private void saveCars(String names) {
        for (String name : names.split(NAME_SEPARATOR)) {
            // TODO: 똑같은 이름의 Car가 이미 있으면 IllegalArgumentException
            cars.add(new Car(name));
        }
    }
    
    private void validate(String names) {
        checkBlank(names);
        checkCommaString(names);
    }
    
    private void checkCommaString(String names) {
        if (isCommaString(names)) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }
    
    private boolean isCommaString(String names) {
        return names.matches("^,+");
    }
    
    private void checkBlank(String names) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }
}
