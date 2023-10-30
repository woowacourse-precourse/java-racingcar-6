package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.exception.InputException;
import racingcar.util.GameUtil;

import java.util.ArrayList;

public class InputView {
    OutputView outputView;
    InputException inputException;
    GameUtil gameUtil;
    public InputView(){
        outputView = new OutputView();
        inputException = new InputException();
        gameUtil = new GameUtil();
    }

    public String inputCars() {
        outputView.inputCarsName();
        String carName = Console.readLine();
        inputException.inputEmpty(carName);
        ArrayList<Car> carArrayList = gameUtil.splitNameArrayList(carName);
        inputException.sameName(carArrayList);
        for(int i=0;i<carArrayList.size();i++){
            inputException.nameLengthOver(carArrayList.get(i).getName());
            inputException.splitNameEmpty(carArrayList.get(i).getName());
        }
        return carName;
    }

    public int inputCount() {
        outputView.inputCount();
        return inputException.toNumber(Console.readLine());
    }
}