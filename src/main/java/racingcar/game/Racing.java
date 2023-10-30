package racingcar.game;

import racingcar.utils.Converter;
import racingcar.utils.PrintUtil;
import racingcar.utils.UserInput;

public class Racing {
    private int turn;
    private final Cars cars;
    private final UserInput userInput;

    public Racing(){
        this.turn = 0;
        this.cars = new Cars();
        this.userInput = new UserInput();
    }

    public void play(){
        ready();
        start();
        end();
    }

    public void ready(){
        PrintUtil.printCarNamesPrompt();
        userInput.inputCarNames();

        PrintUtil.printTurnPrompt();
        userInput.inputTurns();

        // Cars + Turn 설정
        this.cars.initializeCars(userInput.getCarNames());
        this.turn = Converter.convertTurn(userInput.getTurns());
    }

    public void start(){
        PrintUtil.printPlayResult();

        for(int i=0; i<turn;i++){
            this.cars.goOrStop();
            PrintUtil.printTurnResult(this.cars);
        }
    }

    public void end(){
        PrintUtil.printWinner(this.cars.getWinner());
    }
}
