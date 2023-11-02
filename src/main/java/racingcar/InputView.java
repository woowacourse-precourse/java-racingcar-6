package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static void inputCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        User.carNameList = Console.readLine();
    }

    public static void inputPlayNum(){
        System.out.println("시도할 횟수는 몇번인가요?");
        User.getPlayCount = Console.readLine();
    }
}
