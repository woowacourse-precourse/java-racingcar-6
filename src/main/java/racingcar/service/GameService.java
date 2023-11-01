package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.view.TextInterface;

import java.util.List;

public class GameService {
    TextInterface textInterface = new TextInterface();
    Game game = new Game();

    public int enterAttempts(){
        textInterface.inputAttemptsMessage();
        return setAttempts(Console.readLine());
    }
    public int setAttempts(String input){
        game.createAttempts(input);
        return game.getAttempts();
    }

    public Game getGame(){
        return game;
    }

    public void racing(int attempts, List<Car> cars){
        textInterface.resultMessage();
        for(int cycle = 0;cycle<attempts;cycle++){
            forwardAndPrintCar(cars);
            System.out.println();
        }
    }

    public void forwardAndPrintCar(List<Car> cars){
        for(Car car : cars){
            car.randomForward(Randoms.pickNumberInRange(0,9));
            car.printForward();
        }
    }

}
