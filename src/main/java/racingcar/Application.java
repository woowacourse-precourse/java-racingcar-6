package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.CarInputProcess;
import racingcar.domain.RepeatInputProcess;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> cars = carsInput();
        int repeat = repeatInput();
    }

    private static List<String> carsInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        CarInputProcess carInputProcess = new CarInputProcess();
        String input = Console.readLine();
        List<String> cars = carInputProcess.process(input);

        return cars;
    }

    private static int repeatInput() {
        System.out.println("시도할 회수는 몇회인가요?");
        RepeatInputProcess repeatInputProcess = new RepeatInputProcess();
        String input = Console.readLine();
        int repeat = repeatInputProcess.process(input);

        return repeat;
    }
}
