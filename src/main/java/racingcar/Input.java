package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String[] setCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] nameArr = Console.readLine().split(",");
        for(int i=0; i<nameArr.length; i++) {
            ValidateInputName.validateNameLenth(nameArr[i]);
        }
        return nameArr;
    }

    public static int setAttemptNum() {
        System.out.println("시도할 회수는 몇회인가요?");
        int attemptNum = Integer.parseInt(Console.readLine());
        return attemptNum;
    }
}