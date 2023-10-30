package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        Circuit circuit = new Circuit();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        circuit.makeCarList(input);
        System.out.println("시도할 회수는 몇회인가요?");
        String repeat = Console.readLine();
        circuit.setRepeat(repeat);

        System.out.println("실행 결과");
        circuit.race();
        circuit.printResult();
    }
}
