package racingcar;

import java.util.List;

public class Controller {

    public void run() {
        CarList carList;
        carList = new CarList(readRound(), readCarName());

    }

    public List<String> readCarName(){
        return InputView.inputCarName();
    }
    public int readRound() {
        return InputView.inputRound();
    }


}
