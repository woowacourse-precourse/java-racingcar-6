package racingcar;

import camp.nextstep.edu.missionutils.Console;


public class Racing {
    Utils utils = new Utils();
    Exceptions exceptions = new Exceptions();

    public void generateCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        utils.carNames(input);
//        System.out.println(utils.carNames(input).get(1).getName().length());
    }
}
