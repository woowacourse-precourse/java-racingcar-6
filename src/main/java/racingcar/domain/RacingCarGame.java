package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.message.GameMessage;


public class RacingCarGame {
    private Integer racingCnt;
    private UserInputHandler userInputHandler;
    private RoundManager roundManager;
    private Referee racingReferee;

    public  RacingCarGame(){
        userInputHandler = new UserInputHandler();
        racingReferee = new Referee();
    }
    public  void start(){
        setGame();
        System.out.println("\n"+GameMessage.PROGRESS_RESULT.getMessage());
        while(racingCnt-- > 0) {
            roundManager.roundPlay();
            roundManager.printRoundResult();
        }
        racingReferee.findWinner(roundManager.getRacingCars());
        System.out.println(racingReferee.getResult());
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
        roundManager = new RoundManager(racingCars);
    }
    private void setRacingCnt(){
        racingCnt = userInputHandler.getRacingCnt();
    }
}
