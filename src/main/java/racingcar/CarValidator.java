package racingcar;

import racingcar.Input;
import racingcar.NumbersUtil;

import java.util.ArrayList;
import java.util.Arrays;

public class CarValidator {

    Input input = new Input();
    String carNames =  input.inputCarName();



    public ArrayList<String> CarList () {

        String[] carList = carNames.split(",");

        ArrayList<String> car = new ArrayList<>(Arrays.asList(carList));

        return car;
    }

    public void CarValid () {
        ArrayList<String> carList = CarList();

        //CarList().stream().filter(e -> e.length() < NumbersUtil.carNameMax).forEach(e ->System.out.println(e));
        for (String car:carList) {
            if (car.length() > NumbersUtil.carNameMax) {
                throw new IllegalArgumentException();
            }


        }
    }


}
