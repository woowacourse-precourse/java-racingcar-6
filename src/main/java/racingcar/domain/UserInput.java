package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import camp.nextstep.edu.missionutils.Console;
import static racingcar.domain.Constants.*;

public class UserInput {

    public List<String> askCarList() {
        String input = Console.readLine();

        List<String> carTypeList = new ArrayList<String>();
        for (String carType : input.split(CAR_NAME_SEPARATOR)) {
            checkLength(carType);
            checkEmptyInput(carType);
            carTypeList.add(String.valueOf(carType));
        }
        return carTypeList;

    }

    public void checkLength(String carType) {
        if (carType.length() > MAX_CAR_NAME_LENGTH) {
            System.out.println(ERROR_CAR_NAME_LENGTH);
            throw new IllegalArgumentException(ERROR_CAR_NAME_LENGTH);
        }
    }

    public void checkEmptyInput(String carType){
        if (carType.isEmpty()){
            System.out.println(ERROR_EMPTY_INPUT);
            throw new IllegalArgumentException(ERROR_EMPTY_INPUT);
        }
    }

    public int askNumberGame() throws IllegalArgumentException {
        int numGame = Integer.parseInt(Console.readLine());
        return numGame;
    }


}
