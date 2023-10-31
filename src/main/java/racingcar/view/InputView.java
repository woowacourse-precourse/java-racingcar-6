package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    InputVaildator inputVaildator = new InputVaildator();
    public List<String> getName(){
        String car = Console.readLine();
        List<String> carList = Arrays.asList(car.split(","));

        inputVaildator.isNameLessThan5Char(carList);
        return carList;
    }

    public int getNumberOfRound(){
        String numStr = Console.readLine();
        return Integer.parseInt(numStr);
    }
}
