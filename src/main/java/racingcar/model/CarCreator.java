package racingcar.model;

import java.util.Arrays;
import java.util.List;

public class CarCreator {
    public List<String> createCarList(String inputItem){
        List<String> carNames = Arrays.asList(inputItem.split(","));
        validateNameLength(carNames);
        return carNames;
    }

    private void validateNameLength(List<String> carNames){
        for (int i = 0; i < carNames.size(); i++){
            if(carNames.get(i).length() > NumberEnum.MAX_LENGTH.getNumber() ){
                throw new IllegalArgumentException(MessageEnum.MAX_LENGTH_EXCEEDED.getMessage());
            }
        }
    }
}
