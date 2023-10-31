package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputInterface {
    Input in;
    Output out;

    InputInterface(Input in, Output out) {
        this.in = in;
        this.out = out;
    }

    public String[] getNames() {
        out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = in.readLine();
        if ("".equals(input)) {
            throw new IllegalArgumentException("자동차 이름을 입력하지 않았습니다.");
        }
        return input.split(",");
    }

    public int getTrial() {
        out.println("시도할 회수는 몇회인가요?");
        String input = in.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자 값이 아닙니다.");
        }
    }

}
