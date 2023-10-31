package racingcar.Controller;

import camp.nextstep.edu.missionutils.Console;

public class InputController {
    ErrorController errorController = null;

    public InputController(){
        errorController = new ErrorController();
    }

    public String[] inputCarNames(){
        String str = Console.readLine();
        errorController.carNamesException(str);
        String[] names = str.split(",");

        return names;
    }

    public int inputTimes(){
        String times = Console.readLine();
        errorController.gameTimesException(times);
        return Integer.parseInt(times);
    }
}
