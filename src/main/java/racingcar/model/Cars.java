package racingcar.model;

import racingcar.validator.CarNameValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

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

    public void move(){
        for(Car car:cars){
            car.move();
        }
    }

    public void carsState(){
        for(Car car:cars){
            OutputView.carNameShow(car);
            OutputView.positionShow(car);
        }
    }
}
