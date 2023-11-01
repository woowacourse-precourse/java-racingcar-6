package racingcar.model;

import java.util.List;
import racingcar.view.messagePrinter;
import racingcar.view.userInput;
import java.util.ArrayList;




public class GameManager {
    static List<Car> cars = new ArrayList<>();

    public static void run(){

        messagePrinter.printStartMessage();
        List<String> carNames = userInput.getCarNames();
        messagePrinter.askTryNumber();
        int tryNum = userInput.getTryNumber();
        createCars(carNames);
        messagePrinter.printResultTitle();
        for(int i=0;i<tryNum;i++) {
            moveAllCars(cars);
            messagePrinter.printResults(cars);
        }

        messagePrinter.printWinners(cars);
    }

    public static void createCars(List<String> carNames){
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

    }

    public static List<Car> getCars(){
        return cars;
    }

    public static void moveAllCars(List<Car> cars){
        for(int i=0;i<cars.size();i++){
            cars.get(i).tryToMove();
        }

    }




}

