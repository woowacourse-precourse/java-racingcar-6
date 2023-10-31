package racingcar.View;

import static racingcar.util.StringToList.stringToList;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.Model.Car;

public class inputView {

    public static List<Car> getCarNameFromUser(){
        String input = Console.readLine();
        List<Car> carList = stringToList(input);
        return carList;
    }

}
