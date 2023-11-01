package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.RacingGameModel;
import racingcar.view.RacingGameView;

public class RacingGameController {

    private final RacingGameView racingGameView;
    private final RacingGameModel racingGameModel;
    private List<Car> cars;

    public RacingGameController(RacingGameView racingGameView, RacingGameModel racingGameModel){
        this.racingGameView = racingGameView;
        this.racingGameModel = racingGameModel;
    }

    // 1. 자동차 이름 입력받는 기능
    public String inputCarName(){
        String carName = Console.readLine();

        return carName;
    }

    // 2. 시도할 회수 입력받는 기능
    public Integer inputTrialNumber(){
        String inputValue = Console.readLine();

        return Integer.valueOf(inputValue);
    }

    // 게임을 실행하는 메서드
    public void playGame() {
        racingGameView.showCarNameInputMessage();
        String carNames = inputCarName();
        cars = racingGameModel.stringToList(carNames);

        racingGameView.showTrialNumberInputMessage();
        int trialNumber = inputTrialNumber();

        racingGameView.printResultMessage();
        for(int index=0;index<trialNumber;index++){
            racingGameModel.playOneRound(cars);
            racingGameView.printCarsLocation(cars);
        }

        List<Car> winners = racingGameModel.pickWinners(cars);
        racingGameView.printFinalWinners(winners);
    }
}
