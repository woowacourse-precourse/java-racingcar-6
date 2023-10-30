package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.InputException;

public class InputView {
    OutputView outputView;
    InputException inputException;
    public InputView(){
        outputView = new OutputView();
        inputException = new InputException();
    }

    public String inputCars() {
        outputView.inputCarsName();
        String carName = Console.readLine();
        inputException.inputEmpty(carName);
        inputException.sameName(carName);
        inputException.nameLengthOver(carName);

        return carName;
    }

    public int inputCount() {
        outputView.inputCount();
        return inputException.toNumber(Console.readLine());
    }
}