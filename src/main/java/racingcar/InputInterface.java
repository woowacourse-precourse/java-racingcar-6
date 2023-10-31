package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputInterface {

    public String[] getNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        if ("".equals(input)) {
            throw new IllegalArgumentException("자동차 이름을 입력하지 않았습니다.");
        }
        return input.split(",");
    }

    public int getTrial() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자 값이 아닙니다.");
        }
    }

    public void close() {
        Console.close();
    }


}
