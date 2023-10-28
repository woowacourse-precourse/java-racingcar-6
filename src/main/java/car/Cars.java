package car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
    private final List<Car> carList;
    private static final int CAR_NAME_LIMIT = 5;
    private static final String NAME_LENGTH_INVALID = "이름은 5자 이하만 가능하다.";
    private static final String SPLIT_DELIMITER = ",";

    public Cars(String userInput) {
        this.carList = this.initByStringInput(userInput);
    }

    public List<Car> getCarList() { // 테스트에서만 사용하는 것이라면 없애도 되지 않을까?
        return new ArrayList<>(carList);
    }

    public List<String> getCarNames(){
        return carList.stream().map(Car::getName).toList();
    }

    public void moveForTest(){ // 테스트만을 위한 매서드가 존재해도 무방할까?
        this.carList.forEach(Car::addLocation);
    }

    private List<Car> initByStringInput(String userInput){
        String[] carNames = userInput.split(SPLIT_DELIMITER);
        validateUserInput(carNames);
        return Arrays.stream(carNames)
                .map(String::trim) // 양옆 공백을 제거한다.
                .map(Car::new)
                .toList();
    }

    private void validateUserInput(String[] carNames){
        Arrays.stream(carNames).forEach(this::validateLength);
    }

    private void validateLength(String carName) {
        if (carName.length() > CAR_NAME_LIMIT){
            throw new IllegalArgumentException(NAME_LENGTH_INVALID);
        }
    }
}
