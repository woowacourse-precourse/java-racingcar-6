package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;
    public RacingGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }
    public void run(){
        Cars cars =  inputView.getCars();
        moveCars(cars);
        outputView.printWinner(cars.getWinner());

    }


    public void moveCars(Cars cars){
        int num = inputView.getNumberOfMoves();
        for(int i=0; i<num; i++){
            cars.moveCars();
            outputView.printCarPosition(cars.getCars());
        }
    }
}
