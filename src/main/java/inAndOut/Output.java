package inAndOut;

import racingcar.car.Car;

public class Output {

    public void printResult(Car car) {
        System.out.printf("%s : ",car.getName());
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.printf("%c",'-');
        }
        System.out.println("");
    }
}
