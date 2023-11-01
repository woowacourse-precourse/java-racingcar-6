package racingcar.view;

import java.util.List;

import static racingcar.constant.message.OutputMessage.*;

public class OutputView {
    static final String WINNER_SEPERATOR = ",";

    public static void printCarNameInputMessage(){
        System.out.println(CAR_NAME_INPUT_MESSAGE);
    }

    public static void printRacingCountInputMessage(){
        System.out.println(RACING_COUNT_INPUT_MESSAGE);
    }

    public static void printRacingResultStartMessage(){
        System.out.println(RACING_RESULT_START_MESSAGE);
    }

    public static void printAllCarNowDistance(List<String> carDistanceStringList){
        for(String carDistanceString : carDistanceStringList){
            System.out.println(carDistanceString);
        }
        System.out.println();

    }

    public static void printWinnerMessage(List<String> winnerList){
        String winners = String.join(WINNER_SEPERATOR, winnerList);
        System.out.printf(WINNER_MESSAGE + winners);
    }


}
