package racingcar;

import racingcar.Model.Cars;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class Controller {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Cars cars = new Cars();

    private int trialNumber;

    public void run(){
        setRacing();
        playRacing(trialNumber);
        endRacing();
    }

    private void setRacing(){
        cars.addCar(inputView.printStart());
        trialNumber = inputView.printTrial();
        outputView.printResultStart();
    }

    private void playRacing(int trialNumber){
        for(int i = 0; i < trialNumber; i++){
            cars.racingOne();
            racingResult();
        }
    }

    private void racingResult(){
        for (int i = 0; i < cars.carsLength(); i++){
            outputView.printRacingResult(cars.getCarName(i), cars.getCarPositionIcon(i));
        }
        System.out.println();
    }

    private void endRacing(){
        outputView.printWinner(cars.getWinner());
    }
}
