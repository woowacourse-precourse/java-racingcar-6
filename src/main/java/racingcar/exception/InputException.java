package racingcar.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static racingcar.Config.*;

public class InputException {
    public InputException() {
    }

    private static class LazyHolder {
        public static final InputException instance = new InputException();
    }

    public static InputException getinstance() {
        return LazyHolder.instance;
    }

    public List<String> carListException(String input) {
        checkInputIsNull(input);

        String[] values = input.split(",");
        List<String> carList = new ArrayList<>();

        for (String value : values) {
            if (!value.isEmpty()) {
                carList.add(value);
            }
        }

        for (String car : carList) {
            car = car.trim();
            carNameSizeException(car);
        }
        carListSizeException(carList);

        return carList;
    }

    public void checkInputIsNull(String input) {
        if (input == "") {
            throw new IllegalArgumentException(Input_Null_Exception);
        }
        return;
    }

    public List<String> carListSizeException(List<String> carList) {
        if (carList.size() > 2000000000) {
            throw new IllegalArgumentException(Car_List_MAX_Exception);
        }
        if (carList.size() > 0) {
            return carList;
        } else {
            throw new IllegalArgumentException(Car_List_MIN_Exception);
        }
    }

    public void carNameSizeException(String car) {
        if (car.length() > Car_Name_LENGTH) {
            throw new IllegalArgumentException(Car_Name_Length_Exception);
        }
        return;
    }

    public int RoundException(String input) {
        int numOfRound = formatOfRoundException(input);
        return numOfRoundException(numOfRound);
    }

    public int numOfRoundException(int input) {
        if (input < 0) {
            throw new IllegalArgumentException(Num_Of_Round_Exception);
        } else if (input > 2000000000) {
            throw new IllegalArgumentException(Num_Of_Round_MAX_Exception);
        }
        return input;
    }

    public int formatOfRoundException(String input) {
        input = input.trim();
        try {
            int numOfRound = Integer.parseInt(input);
            return numOfRound;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Format_Of_Round_Exception);
        }
    }


}
