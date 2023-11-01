package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Model.CarModel;

import java.util.List;

import static racingcar.util.StringTo.stringToCarCntInteger;
import static racingcar.util.StringTo.stringToCarModelList;

public class InputView {
    public static List<CarModel> getCarNameFromUser(){
        String input = Console.readLine();
        List<CarModel> carList = stringToCarModelList(input);
        return carList;
    }

    public static Integer getCarCntFromUser(){
        String input = Console.readLine();
        Integer carCnt = stringToCarCntInteger(input);
        Console.close();
        return carCnt;
    }
}
