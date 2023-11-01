package racingcar.controller;

import racingcar.dto.Car;
import racingcar.model.Functions;
import racingcar.view.Display;

import java.util.ArrayList;
import java.util.List;


import static racingcar.model.Exceptions.nameLengthException;

public class Controller {
    private static String MILEAGE = "-";
    private static final Display DISPLAY = new Display();

    private static List<Car> cars = new ArrayList<Car>(0);
    private static Integer loop;

    public static void run() {
        startMessage();
        inGameMessage();
        Display.printResult(cars);
    }

    public static void startMessage() throws IllegalArgumentException {
        DISPLAY.printStartInfo();
        cars = splitCars();
        DISPLAY.printSelectLoop();
        loop = Functions.loopCount();
        DISPLAY.printRunning();
    }


    public static void inGameMessage() {
        for (int i = 0; i < loop; i++) {
            calculateMileage();
            for (int j = 0; j < cars.size(); j++) {
                System.out.println(cars.get(j).toString());
            }
            System.out.println();
        }
    }


    public static void calculateMileage() {
        for (Car racing : cars) {
            Integer number = Functions.getRandomNumber();
            if (Functions.checkDriving(number)) {
                racing.setMileage(MILEAGE);
            }
        }
    }

    public static List<Car> splitCars() {
        List<String> list = Functions.splitName();
        List<Car> cars = new ArrayList<Car>();
        for (int i = 0; i < list.size(); i++) {
            nameLengthException(list.get(i));
            cars.add(new Car(list.get(i)));
        }
        return cars;
    }



}
