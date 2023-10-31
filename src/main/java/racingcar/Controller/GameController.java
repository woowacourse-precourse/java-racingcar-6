package racingcar.Controller;

import racingcar.Domain.Car;
import racingcar.Service.RacingGame;
import racingcar.View.InputView;
import racingcar.View.OutputView;

import java.lang.reflect.Array;
import java.util.List;

public class GameController {

    private RacingGame game;
    private InputView inputView;
    private OutputView outputView;
    private Integer tryCount;

    //클래스 다이어그램에 추가하기
    public GameController(){

        this.inputView = new InputView();
        this.outputView = new OutputView();

    }

    public void playGame(){

        String carsName = inputView.getCarsName();
        this.tryCount = inputView.getTryCount();

        this.game = new RacingGame(carsName);

        while(tryCount > 0){
            tryCount--;
            List<Car> racingResult= game.racing();
        }


    }


}
