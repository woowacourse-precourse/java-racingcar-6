package racingcar;

import java.util.Arrays;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public void set(String input){
        List<String> carNameList = parsingCarNames(input);
        storeCars(carNameList);
    }

    public List<String> parsingCarNames(String carNames){
        List<String> carNameList = splitAndConvertToList(carNames, ",");

        return carNameList;
    }

    public void storeCars(List<String> carList){
        for(String carName : carList){
            cars.add(new Car(carName, 0));
        }
    }

    public List<String> splitAndConvertToList(String input, String delimiter) {
        return Arrays.asList(input.split(delimiter));
    }
}
