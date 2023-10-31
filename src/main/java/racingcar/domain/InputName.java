package racingcar.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputName {
    private final static String message= "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private String input;

    public InputName(){
        print();
        input();
    }

    private void print(){
        System.out.println(message);
    }

    private void input(){
        this.input = readLine();
    }

    public String getInput(){
        return input;
    }
}
