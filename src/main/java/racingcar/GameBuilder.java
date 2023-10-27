package racingcar;


import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import racingcar.constant.ExceptionMessage;

public class GameBuilder {
    String[] names;

    public GameBuilder getCarsName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        this.names = Console.readLine().split(",");
        InputValidator.validateCarsName(this.names);
        return this;
    }


    //TODO : GameBuilder getCarsName() throws IllegalArgumentException

    //TODO : GameBuilder getRoundNumber()throws IllegalArgumentException

    //TODO : Game build()
}
