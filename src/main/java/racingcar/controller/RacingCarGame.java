package racingcar.controller;

import static racingcar.view.Input.askCarNames;
import static racingcar.view.Input.askNumberOfGames;
import static racingcar.view.Print.showGameWinner;
import static racingcar.view.Print.showUser;
import static racingcar.view.constant.ConstPrint.ASK_ATTEMPT;
import static racingcar.view.constant.ConstPrint.GAME_START;
import static racingcar.view.constant.ConstPrint.PRINT_RESULT;
import static racingcar.view.constant.ConstPrint.PRINT_WINNER;

import racingcar.service.CarService;

public class RacingCarGame{
    private CarService carService = CarService.getInstance();
    private String cars;
    public void startGame(){
        showUser(GAME_START);
        cars = askCarNames();
        carService.parkParkingLot(cars);
        showUser(ASK_ATTEMPT);
        int Count = askNumberOfGames();
        showUser(PRINT_RESULT);
        while(Count >0){
            playGame();
            Count--;
        }
        showGameWinner(PRINT_WINNER, carService.getWinner());
    }

    private void playGame(){
        carService.generateRandomNumbers();
        carService.confirmRandomNumbers();
        carService.callResultMethod();
    }
}
