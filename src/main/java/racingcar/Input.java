package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String inputCarName(){
        String carName = Console.readLine();
        ErrorExcept.errorInputCarName(carName);
        return carName;
    }

    public static int inputGameCount(){
        String strNum = Console.readLine();
        return ErrorExcept.errorNaN(strNum);
    }

}
