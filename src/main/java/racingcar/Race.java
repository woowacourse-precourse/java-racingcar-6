package racingcar;

import static racingcar.io.ErrorHandler.checkLength;
import static racingcar.io.ErrorHandler.checkRound;
import static racingcar.io.ErrorHandler.checkUnique;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Race {
    private String userInput;
    public static List<String> players;

    public void run() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        userInput = Console.readLine();
        separatePlayers(userInput);
    }

    public void separatePlayers(String userInput) {
        players = List.of(userInput.replaceAll("\\s+", "").split(","));
        for (String player : players) {
            checkLength(player);
        }
    }
}
