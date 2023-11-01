package racingcar.domain;
import camp.nextstep.edu.missionutils.Console;

public class Game {

    public static void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNames = Console.readLine();
        try {
            StaticInputs.carNamesArray = Input.carNamesToArray(inputCarNames);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("시도할 회수는 몇회인가요?");
        String inputCount = Console.readLine();
        try {
            StaticInputs.intCount = Input.inputCountToInt(inputCount);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        System.out.println();
    }
    public static void result() {
        System.out.println("실행 결과");
        Output.view();

    }
}
