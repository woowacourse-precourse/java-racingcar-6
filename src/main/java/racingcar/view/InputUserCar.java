package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputUserCar {
    public static String inputName(){
        return Console.readLine();
    }
    public static String inputTrialNumber(){
        return Console.readLine();
    }

    public static int inputStringToInt(String inputValue){
        return Integer.parseInt(inputValue);
    }
}
