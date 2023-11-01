package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UserInput {

    public List<String> askCarList(String input) {

        List<String> carTypeList = new ArrayList<>();
        HashSet<String> carSet = new HashSet<>();
        checkEmptyInput(input);
        checkInvalidCarTypeInput(input);
        String[] carArr = input.split(Constants.CAR_NAME_SEPARATOR);
        for (String carType : carArr) {
            checkLength(carType);
            checkCarNameFrontBlank(carType);
            checkCarNameDuplicate(carType, carSet);

            carTypeList.add(carType);
            carSet.add(carType);
        }

        return carTypeList;

    }

    public void checkLength(String carType) {
        if (carType.length() > Constants.MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(Constants.ERROR_CAR_NAME_LENGTH);
        }
    }

    public void checkEmptyInput(String carArr){
        if (carArr.isEmpty()){
            throw new IllegalArgumentException(Constants.ERROR_EMPTY_INPUT);
        }
    }

    public void checkInvalidCarTypeInput(String carType){
        char lastChar = carType.charAt(carType.length()-1);
        char firstChar = carType.charAt(0);

        if(lastChar == Constants.CAR_NAME_SEPARATOR.charAt(0)){
            throw new IllegalArgumentException(Constants.ERROR_CAR_NAME_INPUT_ETC);
        }
        if (carType.contains(",,") || firstChar == Constants.CAR_NAME_SEPARATOR.charAt(0)){
            throw new IllegalArgumentException(Constants.ERROR_CAR_NAME_INPUT_ETC);
        }
    }

    public void checkCarNameFrontBlank(String carType) {
        if (carType.charAt(0) == ' ') {
            throw new IllegalArgumentException(Constants.ERROR_CAR_NAME_FRONT_BLANK);
        }
    }

    public void checkCarNameDuplicate(String carName, HashSet<String> carSet) {
        if (carSet.contains(carName)) {
            throw new IllegalArgumentException(Constants.ERROR_CAR_NAME_DUPLICATE);
        }
    }

    public int askNumberGame(String gameNum) throws IllegalArgumentException {
        return Integer.parseInt(gameNum);
    }
}


