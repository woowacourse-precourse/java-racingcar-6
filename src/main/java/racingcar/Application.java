package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Circuit circuit = new Circuit();
        String input = Console.readLine();
        circuit.makeCarList(input);
    }
}
