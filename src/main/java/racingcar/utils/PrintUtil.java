package racingcar.utils;

import static racingcar.constValue.ConstValue.*;

public class PrintUtil {
    private void printCarNamesPrompt(){
        System.out.println(CAR_NAMES_PROMPT_MESSAGE);
    }
    private void printTurnPrompt(){
        System.out.println(TURN_PROMPT_MESSAGE);
    }
    private void printPlayResult(){
        System.out.println(RESULT_MESSAGE);
    }
    private void printTurnResult(){
        // 입력 : Cars
        // TODO : Cars 출력하기
        System.out.println();
    }
    private void printWinner(String racingWinner){
        System.out.println(WINNER_MESSAGE + racingWinner);
    }
}
