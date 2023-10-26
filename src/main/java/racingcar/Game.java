package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    public void start() {
        String[] nameArr = inputName();
        int number = inputNumber();

    }

    public String[] inputName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String name = Console.readLine();
        if (name.isBlank()) {
            throw new IllegalArgumentException();
        }
        if (name.charAt(0) == ',' || name.charAt(name.length() - 1) == ',') {
            throw new IllegalArgumentException();
        }
        return name.split(",");
    }

    public int inputNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        String number = Console.readLine();
        if (number.length() == 1 && Character.isDigit(number.charAt(0))) {
            return Integer.parseInt(number);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
