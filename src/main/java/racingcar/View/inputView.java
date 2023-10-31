package racingcar.View;

import static racingcar.util.StringTo.stringToCarCntInteger;
import static racingcar.util.StringTo.stringToCarModelList;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.Model.CarModel;

public class inputView {

    public static List<CarModel> getCarNameFromUser(){
        String input = Console.readLine();
        List<CarModel> carList = stringToCarModelList(input);
        return carList;
    }

    public static Integer getCarCntFromUser(){
        String input = Console.readLine();
        Integer carCnt = stringToCarCntInteger(input);
        return carCnt;
    }

}
