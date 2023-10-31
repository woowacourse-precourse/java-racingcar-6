package racingcar.domain;

import racingcar.model.exception;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cars {
    static List<Car> cars;

    public Cars(){
        this.cars = new ArrayList<>();
    }

    public void join(String carNames){
        try{
            String[] DoneCarNames = exception.isValidCarNames(carNames);
            for(String carName : DoneCarNames){
                cars.add(new Car(carName));
            }
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            join(InputView.getInputCar());
        }
    }

    public List<Car> getCars(){
        return cars;
    }

    public Car getMaxPosition(){
        return cars.stream().max(Comparator.comparingInt(Car::getPosition)).get();
    }
}
