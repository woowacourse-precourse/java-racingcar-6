package racingcar;

import java.util.List;
import racingcar.model.Car;
import racingcar.view.messagePrinter;
import racingcar.view.userInput;
import java.util.ArrayList;




public class Application {

    static List<Car> cars = new ArrayList<>();


    public static void main(String[] args) {
        messagePrinter.printStartMessage();
        List<String> carNames = userInput.getCarNames();
        messagePrinter.askTryNumber();
        int tryNum = userInput.getTryNumber();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        messagePrinter.printResultTitle();
        for(int i=0;i<tryNum;i++) {
            moveAllCars(cars);
            messagePrinter.printResults(cars);
        }

        messagePrinter.printWinners(cars);

    }

    public static void moveAllCars(List<Car> cars){
        for(int i=0;i<cars.size();i++){
            cars.get(i).move();
        }

    }
}

