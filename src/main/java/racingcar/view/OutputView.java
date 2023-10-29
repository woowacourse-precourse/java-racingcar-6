package racingcar.view;

import racingcar.common.Consts.SystemMessage;

public class OutputView {
    public static void print(String text){
        System.out.print(text);
    }

    public static void println(String text){
        System.out.println(text);
    }

    public static void printErrMessage(String text){
        System.out.println(text);
    }

    public static void printInputCarMessage(){
        println(SystemMessage.INPUT_CAR_MESSAGE);
    }

    public static void printInputChanceNumberMessage(){
        println(SystemMessage.INPUT_CHANCE_NUMBER_MESSAGE);
    }

    public static void printExecutionResultMessage(){
        println(SystemMessage.EXECUTION_RESULT_MESSAGE);
    }

    public static void printFinalWinnerMessage(){
        println(SystemMessage.FINAL_WINNER_MESSAGE);
    }

}
