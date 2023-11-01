package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.constant.Constant;

public class InputView {
    private InputView(){
    }

    public static int parseInt(String input){
        try{
            return Integer.parseInt(input);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(Constant.ERROR_NUMBER_OF_ATTEMPT_MESSAGE);
        }
    }

    public static String isValid(String name){
        if(name.length() > Constant.MAX_NAME_LENGTH){
            throw new IllegalArgumentException(String.format(Constant.ERROR_CAR_NAME_MESSAGE, Constant.MAX_NAME_LENGTH));
        }
        return name;
    }

    public static List<String> inputCarNames(){
        System.out.println(Constant.INPUT_CAR_NAME_MESSAGE);
        return Arrays
                .stream(Console.readLine().split(","))
                .map(InputView::isValid)
                .toList();
    }

    public static Integer inputNumberOfTrial(){
        System.out.println(Constant.INPUT_NUMBER_OF_ATTEMPT_MESSAGE);
        return parseInt(Console.readLine());
    }
}
