package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class ValidCarsImpl implements ValidCars{

    public List<Car> getValidCars() {

        InputView inputView=new InputView();
        String s=inputView.inputCarsName();

        String[] carNames=s.split(",");

        List<Car> cars=new ArrayList<Car>();
        Car car;

        for(String carName:carNames){
            if(carName.length()<=5){
                car=new Car(carName);
                cars.add(car);
            }else if(carName.length()>5){
                throw new IllegalArgumentException("자동차 이름의 길이가 5보다 깁니다");
            }
        }

        return cars;

    }
}
