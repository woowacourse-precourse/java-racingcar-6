package racingcar;

import java.util.ArrayList;
import java.util.LinkedHashMap;


public class RacingGame {
    CarValidator carValidator = new CarValidator();
    ArrayList<String> racingCars = carValidator.CarValid();
    LinkedHashMap<String, Integer> cars = movingCars();



    public Integer checkMove (Integer number) {
        Integer result=0;

        if (number > NumbersUtil.moveMin) {
            result ++;
        }

        return result;
    }

    public LinkedHashMap<String, Integer> movingCars () {
        LinkedHashMap<String, Integer> movingCars = new LinkedHashMap<>();

        for (String cars:racingCars) {
            movingCars.put(cars,0);
        }

        return movingCars;
    }

    public void validMoving () {
        for (String car:racingCars) {
            cars.put(car, cars.get(car)+checkMove(RandomNumberGenerator.RandomNumber()));
        }
    }

    public void tryNumberRacing () {
        for (int i=0;i< carValidator.intTryNumber();i++) {
            validMoving();
            racingOutput();
            System.out.println("");
        }

    }

    public void racingOutput () {
        for (String car:racingCars) {
            String movingProceed = "-".repeat(cars.get(car));
            System.out.println(car+" : "+ movingProceed);
        }
    }


}
