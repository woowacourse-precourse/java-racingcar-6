package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class CarValidator {

    Input input = new Input();
    String carNames =  input.inputCarName();
    String tryNumbers = input.inputTryNumber();

    final static String pattern = "^[0-9]*$";



    public ArrayList<String> CarList () {

        String[] carList = carNames.split(",");

        return new ArrayList<>(Arrays.asList(carList));
    }

    public ArrayList<String> CarValid () {
        ArrayList<String> carList = CarList();

        for (String car:carList) {
            errorInTry(car.length() > NumbersUtil.carNameMax);

            if (car.contains(" ")) {
                System.out.println(MessageUtil.Empty_Error_Message);
                throw new IllegalArgumentException();
            }

            if (carNameDistinct(carList)) {
                System.out.println(MessageUtil.Same_Name_Message);
                throw new IllegalArgumentException();
            }

        }
        return carList;
    }

    public boolean carNameDistinct(ArrayList<String> carList) {
        return carList.size() != carList.stream().distinct().count();
    }

    public void tryValid() {

        boolean numberCheck = Pattern.matches(pattern, tryNumbers);

        errorInTry(tryNumbers.isEmpty());

        errorInTry(!numberCheck);


    }

    public int getIntNumber() {
        return Integer.parseInt(tryNumbers);
    }

    public void errorInTry(boolean tryNumbers) {
        if (tryNumbers) {
            throw new IllegalArgumentException();
        }
    }

    public Integer intTryNumber () {
        tryValid();

        return getIntNumber();
    }




}
