package racingcar;

import static racingcar.Enum.COMMA;
import static racingcar.Enum.DUPLICATED_INPUT_ERROR;
import static racingcar.Enum.INPUT_ERROR;
import static racingcar.Enum.INPUT_SPACE_ERROR;
import static racingcar.Enum.MIN_INPUT_ERROR;
import static racingcar.Enum.SPACE;

import java.util.ArrayList;


public class CheckValidation {

    public static ArrayList<String> checkCarName(String input) {
        ArrayList<String> carNameList = new ArrayList<>();
        String[] carNameArr = input.split(COMMA.getMessage());

        if (carNameArr.length < 2) {
            throw new IllegalArgumentException(MIN_INPUT_ERROR.getMessage());
        }

        for (String carName : carNameArr) {
            if (carName.contains(SPACE.getMessage())) {
                throw new IllegalArgumentException();
            }
            if (carName.length() > 5) {
                throw new IllegalArgumentException(INPUT_SPACE_ERROR.getMessage());
            }
            if (!carNameList.contains(carName)) {
                carNameList.add(carName);
            } else {
                throw new IllegalArgumentException(DUPLICATED_INPUT_ERROR.getMessage());
            }
        }
        return carNameList;
    }

    public static int checkIfIntAndReturnIntForm(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(INPUT_ERROR.getMessage());
        }
    }
}