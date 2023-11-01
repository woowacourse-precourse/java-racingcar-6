package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Computer {
    public static final String PROMPT_FOR_CAR_NAMES = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분)";
    public static final String ATTEMPT_COUNT_PROMPT = "시도할 회수는 몇회인가요?";


    public String getInputCarNames() {
        System.out.println(PROMPT_FOR_CAR_NAMES);
        return Console.readLine();
    }

    public int getInputRaceCount() {
        System.out.println(ATTEMPT_COUNT_PROMPT);
        return Integer.parseInt(Console.readLine());
    }
}
