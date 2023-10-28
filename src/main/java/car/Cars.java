package car;

import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
    private final List<Car> carList;

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

    // TODO: 2023/10/28 VALIDATION 을 강화할 필요가 있을까? 고민을 좀 더 해봐야 함.
    private List<Car> initByStringInput(String userInput){
        String[] carNames = userInput.split(",");
        validateUserInput(carNames);
        return Arrays.stream(carNames)
                .map(String::trim) // 양옆 공백을 제거한다.
                .map(Car::new)
                .toList();
    }

    // TODO: 2023/10/28 private 매소드가 과도하게 많으면 클래스를 옮기는 것을 고려하라. 는 조언이 떠오른다.
    private void validateUserInput(String[] carNames){
        for (String carName : carNames) {
            validateLength(carName);
            validateNotBlank(carName);
        }
    }

    private void validateNotBlank(String carName) {
        if (StringUtils.isBlank(carName)){
            throw new IllegalArgumentException("공백은 입력할 수 없다");
        }
    }

    private void validateLength(String carName) {
        if (carName.length() > 5){
            throw new IllegalArgumentException("이름은 5자 이하만 가능하다.");
        }
    }
}
