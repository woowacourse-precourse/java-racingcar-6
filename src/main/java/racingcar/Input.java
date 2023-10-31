package racingcar;

import camp.nextstep.edu.missionutils.Console;


public class Input {
    private String input;

    private Validation validation = new Validation();

    public void input() {
        input = Console.readLine();
    }

    public Input() {

    }

    //테스트하기위한용도
    public Input(String input) {
        this.input = input;
    }

    //자동차 이름 입력
    public String[] inputCars() {
        if (validation.validateInput(Constant.CARSVALIDATE, input)) {
            String[] carArray = input.split(",");
            return carArray;
        } else {
            throw new IllegalArgumentException();
        }
    }

    // 몇번의 이동했는지 입력
    public String inputTime() {
        if (validation.validateInput(Constant.TIMEVALIDATE, input)) {
            return input;
        } else {
            throw new IllegalArgumentException();
        }
    }


}
