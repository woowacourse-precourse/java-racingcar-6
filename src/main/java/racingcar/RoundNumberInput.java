package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RoundNumberInput {
    public static Integer roundNumInput(){
        System.out.println("시도할 회수는 몇회인가요?");
        String stringRoundNum = Console.readLine();
        CheckValidation.validateNum(stringRoundNum);
        CheckValidation.validateZero(stringRoundNum);
        return Integer.parseInt(stringRoundNum);
    }

}
