package racingcar.controller;

import java.util.LinkedHashMap;
import java.util.List;
import net.bytebuddy.dynamic.scaffold.MethodGraph.Linked;
import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarGameController {

    Car car;
    Game game;
    LinkedHashMap<String,Integer> locations;

    public CarGameController(){
        this.car = new Car(locations);
        this.game = new Game();
    }

    public void start(){
        locations = new LinkedHashMap<>();
        OutputView.printRequestCarNameMessage();
        String input = InputView.readCarName();
        List<String> carNameList= game.splitCarName(input);
        OutputView.printRequestTryNumberMessage();
        int tryNumber = Integer.parseInt(InputView.readTryNumber());
        OutputView.printResultStartMessage();
        car.createLocationMap(carNameList);
        for(int i = 0 ; i < tryNumber; i++){
            locations = car.moveForward(carNameList);
            OutputView.printGameResultMessage(carNameList,locations);
        }
        List<String>winners = game.judgeWinner(carNameList,locations);
        OutputView.printFinalWinner(winners);

    }






}
