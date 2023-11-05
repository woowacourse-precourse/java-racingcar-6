package racingcar.Controller;


import static racingcar.Controller.Module.Validator.validateInputIsNumber;
import static racingcar.Controller.Module.Validator.validateNameInput;
import static racingcar.View.inputView.displayGameStartMessage;
import static racingcar.View.inputView.displayPlayCountMessage;
import static racingcar.View.outputView.displayPlayResult;
import static racingcar.View.outputView.displayWinner;

import java.util.ArrayList;
import java.util.List;
import racingcar.Model.Car;

public class RaceGame {
    public static ArrayList<String> getCarsName(){
        String CarsNameString = displayGameStartMessage();
        return validateNameInput(CarsNameString);
    }

    public static int getPlayCount(){
        return validateInputIsNumber(displayPlayCountMessage());
    }

    private static ArrayList<String> getWinners(ArrayList<Car> cars) {
        int maxCount = 0;
        ArrayList<String> winners = new ArrayList<>();
        for (Car car : cars) {
            int count = car.getCount();
            if (count > maxCount) {
                maxCount = count;
                winners.clear();
                winners.add(car.getName());
            } else if (count == maxCount) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public static void playGame(){
        ArrayList<String> carNames = getCarsName();
        int count = getPlayCount();
        ArrayList<Car> cars = new ArrayList<>();

        for(String carName: carNames){
            cars.add(new Car(carName));
        }

        System.out.println("\n실행 결과");
        for(int i = 0; i< count; i++){
            for(Car car: cars){
                car.putCarResult();
            }
            displayPlayResult(cars);
            System.out.println();
        }
        displayWinner(getWinners(cars));
    }

}
