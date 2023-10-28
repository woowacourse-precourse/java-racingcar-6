package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.LinkedHashMap;

public class RacingGame {

    private static final String STARTING_PHRASE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPTING_PHRASE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_PHRASE = "실행 결과";
    private static final String WINNER_PHRASE = "최종 우승자 : ";

    LinkedHashMap<String, Integer> racingCars;
    int attemptingNum;

    public void startGame() {
        System.out.println(STARTING_PHRASE);
    }

    public Car[] getInput() {
        String[] carNames = Console.readLine().split(",");
    }

    public void getAttemptingNum() {
        System.out.println(ATTEMPTING_PHRASE);
        attemptingNum = Integer.parseInt(Console.readLine());
    }

}
