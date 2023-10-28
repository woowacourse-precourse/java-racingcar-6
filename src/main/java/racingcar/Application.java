package racingcar;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import racingcar.input.Typing;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<String> s = Typing.inputCarName();
        System.out.println(s);

        int n = Typing.inputNumberOfAttempts();
        System.out.println(n);
    }
}