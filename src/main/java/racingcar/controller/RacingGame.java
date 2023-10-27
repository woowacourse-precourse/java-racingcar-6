package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.util.Validator;
import racingcar.view.InputView;

import java.util.StringTokenizer;

public class RacingGame {
    Game game;
    int repetitions=0;

    public void startGame(){
        game = new Game();

        StringTokenizer st = new StringTokenizer(InputView.inputCalNames());
        while (st.hasMoreTokens()){
            String carName = st.nextToken(",");
            Validator.validateCarLength(carName);
            game.addCar(new Car(carName, ""));
        }
        String inputRepetitions = InputView.inputRepetitions();
        Validator.validateIsNumber(inputRepetitions);
        repetitions = Integer.parseInt(inputRepetitions);

        for(int i=0;i<repetitions;i++){
            playGame();
        }
    }

    public void playGame(){
        //todo 게임 시작
    }
}
