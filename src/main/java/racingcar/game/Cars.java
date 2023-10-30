package racingcar.game;

import racingcar.utils.Converter;
import racingcar.utils.RandomNumber;

import java.util.ArrayList;
import java.util.List;

import static racingcar.utils.RandomNumber.*;

public class Cars {
    private final List<Car> cars;
    private final Converter converter;

    public Cars(){
        this.cars = new ArrayList<>();
        this.converter = new Converter();
    }

    public void initializeCars(String carsName){
        String[] carsNameArray = converter.convertCarsName(carsName);

        for(String carName:carsNameArray){
            Car newCar = new Car();
            newCar.setName(carName);
            cars.add(newCar);
        }
    }

    public void goOrStop(){
        for(Car car:this.cars){
            int randomNumber = RandomNumber.getRandomNumber();

            if(randomNumber>=4) {
                car.addMoving();
            }
        }
    }
}
