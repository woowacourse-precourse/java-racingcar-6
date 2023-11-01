package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String enterCarNames() {
        System.out.print("경주할 자동차 이름을 입력해주세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameList = Console.readLine();
        return carNameList;
    }

    public static String enterMatchTimes() {
        System.out.print("시도할 횟수는 몇회인가요?");
        String times = Console.readLine();
        return times;
    }
}
