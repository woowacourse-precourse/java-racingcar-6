package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.CarInputProcess;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> cars = carsInput();
    }

    private static List<String> carsInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        CarInputProcess carInputProcess = new CarInputProcess();
        String input = Console.readLine();
        List<String> cars = carInputProcess.process(input);

        return cars;
    }
}
