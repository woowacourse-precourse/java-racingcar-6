package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RoundNumberInput {
    public static Integer roundNumInput(){
        System.out.println("시도할 회수는 몇회인가요?");
        String stringRoundNum = Console.readLine();
        validateNum(stringRoundNum);
        return Integer.parseInt(stringRoundNum);
    }

    public static void validateNum(String roundNum){
        try {
            Integer.parseInt(roundNum);
        }catch (Exception e){
            throw new IllegalArgumentException("숫자를 입력하세요.");
        }
    }
}
