package racingcar.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        validateDuplicate(carNames);
        this.cars = carNames.stream()
                .map(name -> new Car(name, 0))
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    private void validateDuplicate(List<String> listOfNames) {
        Set<String> setOfNames = new HashSet<>(listOfNames);
        int sizeOfSet = setOfNames.size();
        int sizeOfList = listOfNames.size();

        if(sizeOfList != sizeOfSet){
            throw new IllegalArgumentException("자동차 이름들은 중복될 수 없습니다.");
        }
    }
}
