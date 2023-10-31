package racingcar;

import camp.nextstep.edu.missionutils.Console;
public class Input {
    static final String ASK_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분)";
    static final String ASK_ROUND = "시도할 회수는 몇회인가요?";

    public String getCarName() {
        System.out.println(ASK_CAR_NAME);

        return Console.readLine();
    }

    public int getRound(){
        System.out.println(ASK_ROUND);

        return Integer.parseInt(Console.readLine());
    }

}
