package racingcar.input;

import camp.nextstep.edu.missionutils.Console;

public interface UserInput<T>{
    T input();

    default void close(){
        Console.close();
    }
}
