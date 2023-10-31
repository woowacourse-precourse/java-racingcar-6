package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_NAME_MEMBER = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_NUM_TRY = "시도할 횟수는 몇회인가요?";

    public String enterGameMembersName(){
        System.out.println(INPUT_NAME_MEMBER);
        return Console.readLine();
    }

    public int enterGameNumber(){
        System.out.println(INPUT_NUM_TRY);
        return Integer.parseInt(Console.readLine());
    }

}
