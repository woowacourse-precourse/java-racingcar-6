package racingcar.game;


import racingcar.utils.Converter;
import racingcar.utils.RandomNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.utils.RandomNumber.*;
import racingcar.utils.Converter.*;

public class Cars {
    private final List<Car> cars;

    public Cars(){
        this.cars = new ArrayList<>();
    }

    public void initializeCars(String carsName){
        String[] carsNameArray = Converter.convertCarsName(carsName);

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

    private int getMaxMoving(){
        int maxMoving = 0;

        for(Car car:this.cars){
            if(maxMoving < car.getMoving()){
                maxMoving = car.getMoving();
            }
        }

        return maxMoving;
    }
    public String getWinner(){
        int maxMoving = getMaxMoving();

        List<String> winners = cars.stream()
                .filter(car -> car.getMoving() == maxMoving)
                .map(Car::getName)
                .collect(Collectors.toList());

        return String.join(", ", winners);
    }
    public List<Car> getCars(){
        return cars;
    }
}
