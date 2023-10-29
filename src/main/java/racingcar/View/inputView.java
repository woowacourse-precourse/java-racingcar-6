package racingcar.View;

import camp.nextstep.edu.missionutils.Console;

public class inputView {
    private static final String INPUT_CARS_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_PLAY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    public String displayGameStartMessage(){
        System.out.println(INPUT_CARS_NAME_MESSAGE);
        return Console.readLine();
    }

    public String displayPlayCountMessage(){
        System.out.println(INPUT_PLAY_COUNT_MESSAGE);
        return Console.readLine();
    }
}
