package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        //printWinners();
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

//    public static void printWinners(){
//        System.out.println("enter");
//        if(cars.size() < 1) {
//            System.out.println("why?");
//            return;
//        }
//        List<String> winners = new ArrayList<String>();
//        Integer winnerMileageSize = cars.get(0).getMileage().length() ;
//        for(int i = 1 ; i < cars.size(); i++){
//            Integer compareOtherSize = cars.get(i).getMileage().length();
//            if(winnerMileageSize <= compareOtherSize){
//                if(winnerMileageSize.equals(compareOtherSize)) {
//                    System.out.println("zz");
//                    winners.add(cars.get(i).getName());
//                }
//                else { winnerMileageSize = compareOtherSize; }
//            }
//        }
//        System.out.println(String.join(", ", winners));
//    }


}
