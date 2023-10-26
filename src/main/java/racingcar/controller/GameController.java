package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
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
    }

    private static void finishGame(){
        OutputView.executionResult();
        OutputView.winner();
    }

    private static boolean isValidateAdvance(){
        return GeneratedRandomNumber.getNumber() >= CAR_ADVANCE_NUMBER;
    }

    private static List<Car> getCars(String cars){
        return Arrays.stream(cars.split(",")).map(carName -> new Car(carName)).collect(Collectors.toList());
    }
}
