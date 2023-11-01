package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CarService {
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUBER = 9;
    
    private final List<Car> cars = new LinkedList<>();
    
    public List<Car> getCars(String userInput) {
        setUpCars(userInput);
        return cars;
    }
    
    public void raceCars(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUBER);
            car.go(randomNumber);
        }
    }
    
    private void setUpCars(String userInput) {
        String[] carNames = separateCarNamesByComma(userInput);
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        
        verifyCarNames();
    }
    
    private String[] separateCarNamesByComma(String userInput) {
        return userInput.split(",");
    }
    
    private void verifyCarNames() {
        if (hasDuplicatedName(cars)) {
            throw new IllegalArgumentException("Duplicated car names are exist.");
        }
    }
    
    private boolean hasDuplicatedName(List<Car> cars) {
        Set<String> nonDuplicatedCarNames = new HashSet<>();
        return cars.stream()
                .map(car -> car.name)
                .anyMatch(carName -> !nonDuplicatedCarNames.add(carName)); // 이미 이름이 존재하는 경우 true 반환
    }
}
