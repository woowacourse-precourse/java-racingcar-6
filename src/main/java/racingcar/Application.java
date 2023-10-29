package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        UserInput userInput = new UserInput();
        userInput.receiveUserInput();
        RacingCarGame.play(userInput.carNames, userInput.tries);

    }

}

