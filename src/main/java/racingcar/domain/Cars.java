package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
    private final String DELIMITER = ",";

    private final List<Car> cars = new ArrayList<>();

    public Cars(String input){
        List<String> carNames =  Arrays.asList(input.split(DELIMITER));
        validateDuplicateName(carNames);
    }

    public List<Car> getCars(){
        return cars;
    }

    private void validateDuplicateName(List<String> carNames) {
        if(carNames.size() != carNames.stream().distinct().count()){
            throw new IllegalArgumentException();
        }
    }
}
