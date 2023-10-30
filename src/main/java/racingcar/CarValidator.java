package racingcar;

import org.mockito.internal.matchers.Null;
import racingcar.Input;
import racingcar.NumbersUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class CarValidator {

    Input input = new Input();
    String carNames =  input.inputCarName();
    String tryNumbers = input.inputTryNumber();



    public ArrayList<String> CarList () {

        String[] carList = carNames.split(",");

        return new ArrayList<>(Arrays.asList(carList));
    }

    public ArrayList<String> CarValid () {
        ArrayList<String> carList = CarList();

        //CarList().stream().filter(e -> e.length() < NumbersUtil.carNameMax).forEach(e ->System.out.println(e));
        for (String car:carList) {
            if (car.length() > NumbersUtil.carNameMax) {
                throw new IllegalArgumentException();
            }

        }
        return carList;
    }

    public void tryValid() {
        String pattern = "^[0-9]*$";
        boolean numberCheck = Pattern.matches(pattern, tryNumbers);

        if(tryNumbers.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (!numberCheck) {
            throw new IllegalArgumentException();
        }
    }

    public Integer intTryNumber () {
        tryValid();

        return Integer.parseInt(tryNumbers);
    }




}
