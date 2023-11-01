package racingcar.view;

import static racingcar.domain.Verification.validateNonNumeric;

import camp.nextstep.edu.missionutils.Console;

public class input {

    public static int tryNumber=0;
    public static String inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }
    public static int inputNumberCarsRace(){
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        validateNonNumeric(input);
        tryNumber = Integer.valueOf(input);
        return tryNumber;
    }
}
