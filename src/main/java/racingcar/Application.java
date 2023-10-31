package racingcar;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

import racingcar.view.messagePrinter;
import racingcar.view.userInput;


public class Application {

    static List<Car> cars = new ArrayList<>();


    public static void main(String[] args) {
        messagePrinter.printStartMessage();
        List<String> carNames = userInput.getCarNames();
        messagePrinter.askTryNumber();
        int tryNum = userInput.getTryNumber();
        for(int i=0;i<tryNum;i++){
            cars.add(new Car(carNames.get(i)));
        }
        messagePrinter.printResultTitle();
        for(int i=0;i<tryNum;i++) {
            moveAllCars(cars);
        }

    }

    public static void moveAllCars(List<Car> cars){
        for(int i=0;i<cars.size();i++){
            cars.get(i).move();
        }

    }
}

 class Car {
    public String carName;
    public int raceStatus;
    public Car(String carNameInput){
        this.carName = carNameInput;
        this.raceStatus = 0;
    }

    public void move(){
        int randResult = Randoms.pickNumberInRange(0,9);
        if(randResult>=4){
            raceStatus++;
        }
    }

}

