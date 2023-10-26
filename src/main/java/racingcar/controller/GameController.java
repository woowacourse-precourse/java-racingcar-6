package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Name;
import racingcar.utils.GeneratedRandomNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private static int CAR_ADVANCE_NUMBER = 4;

    private static List<Car> cars;
    private static int attempts;

    public static void start(){

            cars = getCars(inputCarName());
            attempts = inputAttempts();

            while(attempts!=0){
                // 게임 시도
                playAttempt();
                // 시도 횟수 감소
                attempts--;
            }

            finishGame();
    }

    private static int inputAttempts(){
        return Integer.parseInt(InputView.attempts());
    }

    private static String inputCarName(){
        return InputView.carsName();
    }

    private static void playAttempt(){
        for(Car car : cars){
            if(isValidateAdvance()){
                car.addAdvances();
            }
        }

        OutputView.resultPerAttempt(cars);
        System.out.println();
    }

    private static void finishGame(){
        OutputView.executionResult();
        FindWinnerController findWinnerController = new FindWinnerController(cars);
        OutputView.winner(findWinnerController.getWinners());
    }

    private static boolean isValidateAdvance(){
        return GeneratedRandomNumber.getNumber() >= CAR_ADVANCE_NUMBER;
    }

    private static List<Car> getCars(String cars){
        cars.replaceAll(" ","");
        List<Car> convertCars = new ArrayList<>();

        for (String carName : cars.split(",")){
            convertCars.add(new Car(new Name(carName)));
        }

        return convertCars;
    }
}
