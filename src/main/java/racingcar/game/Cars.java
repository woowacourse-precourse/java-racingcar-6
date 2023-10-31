package racingcar.game;

import racingcar.controller.Dice;

import java.util.ArrayList;

public class Cars {
    ArrayList<Car> cars = new ArrayList<>();

    public Cars(ArrayList<String> inputList){
        for (String s : inputList) {
            cars.add(new Car(s));
        }
    }

    public void roundRace(){
        Dice dice = new Dice();

        for (Car car : cars) {
            if (dice.rollTheDice()) {
                car.moveForward();
            }
            car.stop();
        }
    }

    public void getCarNames(){
        for (Car car : cars) {
            System.out.printf("차 이름(%s) ", car.getCarName());
        }
    }

    public Integer getNumberOfCars(){
        return cars.size();
    }
}
