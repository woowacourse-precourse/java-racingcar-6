package racingcar;

import java.util.ArrayList;
import java.util.List;


import static racingcar.Exceptions.nameLengthException;

public class Controller {
    private static String MILEAGE = "-";
    private static final View view = new View();

    private static List<Car> cars = new ArrayList<Car>(0);
    private static Integer loop;

    public static void run() {
        startMessage();
        inGameMessage();
        gameResult();
        View.printResult(cars);
    }

    public static void startMessage() throws IllegalArgumentException {
        view.printStartInfo();
        cars = splitCars();
        view.printSelectLoop();
        loop = Functions.loopCount();
        view.printRunning();
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

    public static void gameResult() {

//        view.printResult();
//        printWinners();
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
