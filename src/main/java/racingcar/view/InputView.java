package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String inputCar() {                    //문자 열의 크기가 5자를 초과 할때 Exception 로직 필요
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public String inputChance() {                      //숫자 아닐 시 Exception 로직 필요
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }
}
