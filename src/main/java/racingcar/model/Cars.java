package racingcar.model;

import racingcar.validator.CarNameValidator;
import racingcar.view.InputView;

import java.util.ArrayList;

public class Cars {

    public static ArrayList<Car> cars = new ArrayList<Car>();

    public Cars(){
        CarNameValidator validator = new CarNameValidator(InputView.getCarName());
        for (String Name:validator.NAMES){
            Car car = new Car(Name);
            cars.add(car);
        }
    }
}
