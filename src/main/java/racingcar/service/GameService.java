package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.view.TextInterface;

import java.util.List;

public class GameService {
    private TextInterface textInterface = new TextInterface();
    private CarService carService = new CarService();
    private Game game = new Game();

    public int enterAttempts(){
        textInterface.inputAttemptsMessage();
        return setAttempts(Console.readLine());
    }
    public int setAttempts(String input){
        game.createAttempts(input);
        return game.getAttempts();
    }

    public void racing(int attempts, List<Car> cars){
        textInterface.resultMessage();
        for(int cycle = 0;cycle<attempts;cycle++){
            carService.forwardAndPrintCar(cars);
            System.out.println();
        }
    }

    public void winnerPrint(List<Car> cars){
        int winForward = carService.findWinForward(cars);
        int winner = carService.countWinner(cars, winForward);
        carService.printWinner(cars, winner, winForward);
    }

}
