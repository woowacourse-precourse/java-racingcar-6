package racingcar;

import static racingcar.InputView.inputCarNames;
import static racingcar.InputView.inputTryNumber;
import static racingcar.OutputView.printFinalWinner;
import static racingcar.OutputView.printPlayResult;

public class Controller {
    ValidatorCarName validatorCarName = new ValidatorCarName();
    ValidatorTryNumber validatorTryNumber = new ValidatorTryNumber();
    CarFuntion makecar = new CarFuntion();
    PlayRacing playRacing = new PlayRacing();

    public void racingStart(){
        String carNames = inputCarNames();
        validatorCarName.checkCarName(carNames);
        makecar.makeCar(carNames);

        String tryNumber = inputTryNumber();
        validatorTryNumber.checkNum(tryNumber);

        printPlayResult();
        playRacing.forwardRecord(validatorTryNumber.getTryNumber(), makecar.getCar());
        printFinalWinner();
        PlayRacing.selectWinner(makecar.getCar());

    }
}
