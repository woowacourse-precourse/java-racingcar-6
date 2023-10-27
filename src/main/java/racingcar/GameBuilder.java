package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import racingcar.constant.ExceptionMessage;

public class GameBuilder {
    String[] names;

    public GameBuilder getCarsName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        this.names = Console.readLine().split(",");
        validateCarsName(this.names);

        return this;
    }

    private void validateCarsName(String[] names){
        validateEachName(names);
        validateDuplication(names);
    }

    private void validateDuplication(String[] names) {
        int distinctNum = (int)Arrays.stream(names)
                .distinct()
                .count();

        if(distinctNum != names.length){
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_DUPLICATED);
        }
    }

    private void validateEachName(String[] names) {
        for(String name : names){
            if(name.isBlank()){
                throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_CANT_NOT_BLANK);
            }
            if(name.length() > 5){
                throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_IS_TOO_LONG);
            }
        }
    }
    //TODO : GameBuilder getCarsName() throws IllegalArgumentException

    //TODO : GameBuilder getRoundNumber()throws IllegalArgumentException

    //TODO : Game build()
}
