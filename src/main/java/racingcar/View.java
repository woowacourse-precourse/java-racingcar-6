package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class View{
    private static final String CAR_NAME_PROMPT="경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_PROMPT="시도할 회수는 몇회인가요?";
    private static final String CONDUCT_MESSAGE="실행 결과";
    private static final String WINNER_MESSAGE="최종 우승자 :";

    public static String getCarNames(){
        System.out.println(CAR_NAME_PROMPT);
        return Console.readLine();
    }

    public static String getTryCount(){
        System.out.println(TRY_COUNT_PROMPT);
        return Console.readLine();
    }

    public static void printCarMove(String carName, int position){
        System.out.println(carName + " : " + "-".repeat(position));
    }

    public static void printResultAlarm(){
        System.out.println(CONDUCT_MESSAGE);
    }

    public static void printFinalWinner(String winners){
        System.out.println(WINNER_MESSAGE+winners);
    }
}