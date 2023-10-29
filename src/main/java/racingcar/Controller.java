package racingcar;

import static racingcar.InputView.inputCarNames;
import static racingcar.InputView.inputTryNumber;
import static racingcar.OutputView.printPlayResult;

public class Controller {
    ValidatorCarName validatorCarName = new ValidatorCarName();
    ValidatorTryNumber validatorTryNumber = new ValidatorTryNumber();
    MakeCar makecar = new MakeCar();

    public void racingStart(){
        String carNames = inputCarNames();
        validatorCarName.checkCarName(carNames);
        makecar.makeCar(carNames);

        String tryNumber = inputTryNumber();
        validatorTryNumber.checkNum(tryNumber);
        validatorTryNumber.getTryNumber();

        printPlayResult();

    }
}
