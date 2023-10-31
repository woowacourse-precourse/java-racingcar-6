package racingcar.View;

import static racingcar.util.StringToList.stringToList;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.Model.CarModel;

public class inputView {

    public static List<CarModel> getCarNameFromUser(){
        String input = Console.readLine();
        List<CarModel> carList = stringToList(input);
        return carList;
    }

}
