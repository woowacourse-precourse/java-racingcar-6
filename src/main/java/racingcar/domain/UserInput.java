package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import static racingcar.domain.Constants.*;

public class UserInput {

    public List<String> askCarList() {
        String input = Console.readLine();

        List<String> carTypeList = new ArrayList<String>();
        HashSet<String> carSet = new HashSet<>();
        checkEmptyInput(input);
        checkInvalidCarTypeInput(input);
        String[] carArr = input.split(CAR_NAME_SEPARATOR);
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
        if (carType.length() > MAX_CAR_NAME_LENGTH) {
            System.out.println(ERROR_CAR_NAME_LENGTH);
            throw new IllegalArgumentException(ERROR_CAR_NAME_LENGTH);
        }
    }

    public void checkEmptyInput(String carArr){
        if (carArr.isEmpty()){
            System.out.println(ERROR_EMPTY_INPUT);
            throw new IllegalArgumentException(ERROR_EMPTY_INPUT);
        }
    }

    public void checkInvalidCarTypeInput(String carType){
        char lastChar = carType.charAt(carType.length()-1);
        char firstChar = carType.charAt(0);

        if(lastChar == CAR_NAME_SEPARATOR.charAt(0)){
            System.out.println(ERROR_CAR_NAME_INPUT_ETC);
            throw new IllegalArgumentException(ERROR_CAR_NAME_INPUT_ETC);
        }
        if (carType.contains(",,") || firstChar == CAR_NAME_SEPARATOR.charAt(0)){
            System.out.println(ERROR_CAR_NAME_INPUT_ETC);
            throw new IllegalArgumentException(ERROR_CAR_NAME_INPUT_ETC);
        }
    }

    public void checkCarNameFrontBlank(String carType) {
        if (carType.charAt(0) == ' ') {
            System.out.println(ERROR_CAR_NAME_FRONT_BLANK);
            throw new IllegalArgumentException(ERROR_CAR_NAME_FRONT_BLANK);
        }
    }

    public void checkCarNameDuplicate(String carName, HashSet<String> carSet) {
        if (carSet.contains(carName)) {
            System.out.println(ERROR_CAR_NAME_DUPLICATE);
            throw new IllegalArgumentException(ERROR_CAR_NAME_DUPLICATE);
        }
    }

    public int askNumberGame() throws IllegalArgumentException {
        int numGame = Integer.parseInt(Console.readLine());
        return numGame;
    }


}
