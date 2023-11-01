package racingcar;

import camp.nextstep.edu.missionutils.Console;


public class Input {
    private final Validation validation = new Validation();
    private String input;

    public Input() {

    }

    //테스트하기위한용도
    public Input(String input) {
        this.input = input;
    }

    public void input() {
        input = Console.readLine();
    }

    //자동차 이름 입력
    public String[] inputCarNames() {
        if (validation.validateInput(Constant.CARS_VALIDATE, input)) {
            String[] carArray = input.split(",");
            return carArray;
        } else {
            throw new IllegalArgumentException();
        }
    }

    // 몇번의 이동했는지 입력
    public String inputRounds() {
        if (validation.validateInput(Constant.TIME_VALIDATE, input)) {
            return input;
        } else {
            throw new IllegalArgumentException();
        }
    }


}
