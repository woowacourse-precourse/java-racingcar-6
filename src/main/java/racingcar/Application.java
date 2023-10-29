package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        try {
            // TODO: 프로그램 구현
            System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
            ArrayList<String> carNames = InputProcessor.carNameInputProcess(Console.readLine());

            System.out.println("시도할 회수는 몇회인가요?");
            int tryCount = InputProcessor.tryCountInputProcess(Console.readLine());

            // verify console input
            System.out.println("carNames : " + carNames);
            System.out.println("tryCount : " + tryCount);

            // carNames : [pobi, woni, jun]
            // tryCount : 5

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
