package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Name;
import racingcar.utils.GeneratedRandomNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private static List<Car> cars;
    private static int attempts;

    public static void start(){

            cars = getCars(inputCarName());
            attempts = inputAttempts();

            while(attempts!=0){
                // 게임 시도
                play();
                // 시도 횟수 감소
                attempts--;
            }

            finishGame();
    }

    public static int inputAttempts(){
        return Integer.parseInt(InputView.attempts());
    }

    public static String inputCarName(){
        return InputView.carsName();
    }

    public static void play(){
        for(Car car : cars){
            car.addAdvances(GeneratedRandomNumber.getNumber());
        }

        OutputView.resultPerAttempt(cars);
        System.out.println();
    }

    public static void finishGame(){
        OutputView.executionResult();
        FindWinnerController findWinnerController = new FindWinnerController(cars);
        OutputView.winner(findWinnerController.getWinners());
    }

    public static List<Car> getCars(final String cars){
        List<Car> convertCars = new ArrayList<>();

        for (String carName : cars.split(",")){
            convertCars.add(new Car(new Name(carName)));
        }

        return convertCars;
    }
}
