package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.message.GameMessage;


public class RacingCarGame {
    private Integer racingCnt;
    private UserInputHandler userInputHandler;

    public  RacingCarGame(){
        userInputHandler = new UserInputHandler();
    }
    public  void start(){
        setGame();
    }

    private void setGame(){
        setRacingCars();
        setRacingCnt();
    }

    private void setRacingCars(){
        List<Car> racingCars = new ArrayList<>();
        List<String> carNames = userInputHandler.getCarNameInput();
        for (String name: carNames){
            racingCars.add(new Car(name));
        }
    }
    private void setRacingCnt(){
        racingCnt = userInputHandler.getRacingCnt();
    }
}
