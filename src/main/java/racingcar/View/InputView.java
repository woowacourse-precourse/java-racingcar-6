package racingcar.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static String RACING_START = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static String ATTEMPT_QUESTION = "시도할 회수는 몇회인가요?";
    private static String NEGATIVE_NUMBER = "게임을 시작할 수 없는 숫자입니다.";


    public static int RaceCount() {
        System.out.println(ATTEMPT_QUESTION);
        int raceCount = Integer.parseInt(Console.readLine());
        NegativeNumber(raceCount);
        return raceCount;
    }

    public static void NegativeNumber(int raceCount) {
        if(raceCount<0){
            throw new IllegalArgumentException(NEGATIVE_NUMBER);
        }
    }

    public static String getCarName() {
        System.out.println(RACING_START);
        return Console.readLine();
    }
}
