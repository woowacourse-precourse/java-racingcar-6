package racingcar;

import racingcar.controller.*;
import racingcar.view.InputView;
import racingcar.view.InputViewImpl;
import racingcar.view.OutputView;
import racingcar.view.OutputViewImpl;

public class AppConfig {

    public FindWinners findWinners(){
        return new FindWinnersImpl();
    }

    public PlayEachRacingGame playEachRacingGame(){
        return new PlayEachRacingGameImpl(outputView());
    }

    public PlayRacingGame playRacingGame(){
        return new PlayRacingGameImpl(findWinners(),playEachRacingGame(),validCars(),
                validRacingCount(),outputView(),inputView());
    }

    public ValidCars validCars(){
        return new ValidCarsImpl(inputView());
    }

    public ValidRacingCount validRacingCount(){
        return new ValidRacingCountImpl(inputView());
    }

    public InputView inputView(){
        return new InputViewImpl();
    }

    public OutputView outputView(){
        return new OutputViewImpl();
    }

}
