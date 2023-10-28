package racingcar.controller;

import java.util.LinkedHashMap;
import java.util.List;
import net.bytebuddy.dynamic.scaffold.MethodGraph.Linked;
import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarGameController {

    private Game game;

    public CarGameController(){
        this.game = new Game();
    }

    public void start(){
        OutputView.printRequestCarNameMessage();
        String input = InputView.readCarName();
        List<String> carNameList= game.splitCarName(input);
        validateNameLength(carNameList);
        OutputView.printRequestTryNumberMessage();
        int tryNumber = Integer.parseInt(InputView.readTryNumber());
        OutputView.printResultStartMessage();





    }


    public static void validateNameLength(List<String> carNameList){
        for(int i = 0 ; i < carNameList.size();i++){
            if(carNameList.get(i).length()>5){
                throw new IllegalArgumentException();
            }
        }
    }



}
