package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    OutputView outputView = new OutputView();
    public String inputCars(){
        outputView.inputCarsName();
        return Console.readLine();
    }
    public int inputCount(){
        outputView.inputCount();
        return Integer.parseInt(Console.readLine());
    }
}