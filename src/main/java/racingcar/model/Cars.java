package racingcar.model;

import racingcar.validator.CarNameValidator;
import racingcar.view.InputView;

import java.util.ArrayList;

public class Cars {

    public static ArrayList<String> cars;

    public Cars(){
        CarNameValidator validator = new CarNameValidator(InputView.getCarName());
        cars = validator.NAMES;
    }
}
