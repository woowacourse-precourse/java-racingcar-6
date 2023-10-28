package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.InputException;

public class InputView {
    OutputView outputView = new OutputView();
    InputException inputException = new InputException();
    public String inputCars(){
        outputView.inputCarsName();
        String carName = Console.readLine();
        inputException.sameName(carName);
        inputException.nameLengthOver(carName);

        return carName;
    }
    public int inputCount(){
        outputView.inputCount();
        return Integer.parseInt(Console.readLine());
    }
}