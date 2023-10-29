package racingcar.racingCar;

import racingcar.controller.checkWinner.CheckWinner;
import racingcar.controller.distinguish.Distinguish;
import racingcar.controller.random.RandomMove;
import racingcar.view.Input;
import racingcar.view.Output;

public class RacingCarGame {

    Output output;
    Input input;
    Distinguish distinguishNum;
    Distinguish distinguishName;
    CheckWinner checkWinner;
    RandomMove randomMove;

    public RacingCarGame(Distinguish distinguishNum,Distinguish distinguishName, CheckWinner checkWinner, RandomMove randomMove) {
        this.distinguishNum = distinguishNum;
        this.distinguishName = distinguishName;
        this.checkWinner = checkWinner;
        this.randomMove = randomMove;
        input = new Input();
        output = new Output();
    }

    public void playGame(){
        output.startGame();

        String playersName = input.getPlayerName();

        distinguishName.distinguish(playersName);

        String numberOfRepetitions = input.getNumberOfRepetitions();

        distinguishNum.distinguish(numberOfRepetitions);


    }
}
