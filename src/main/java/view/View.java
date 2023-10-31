package view;

import camp.nextstep.edu.missionutils.Console;
import validate.Validate;

public class View {
    static Validate validate = new Validate();
    public static String getInputLineOfCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return validate.validateInputLineOfCarNames(Console.readLine());
    }
    public static int getNumberOfAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(validate.checkNumberOfAttemptsForm(Console.readLine()));
    }


    public static void printHeadResult() {
        System.out.println("\n실행 결과");
    }
}
