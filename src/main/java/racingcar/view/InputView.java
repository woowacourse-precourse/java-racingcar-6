package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    public static String carNames(){
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        return validateCarNames(Console.readLine());
    }

    public static String tryCount(){
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
        return validateTryCount(Console.readLine());
    }

    private static String validateCarNames(String names){
        isEmpty(names);
        isEndWithCOMMA(names);
        return names;
    }

    private static String validateTryCount(String tryCount){
        isEmpty(tryCount);
        return tryCount;
    }

    private static void isEndWithCOMMA(String names){
        if(names.charAt(names.length() - 1) == ','){
            throw new IllegalArgumentException();
        }
    }

    private static void isEmpty(String value){
        if(value.isEmpty()){
            throw new IllegalArgumentException();
        }
    }

}
