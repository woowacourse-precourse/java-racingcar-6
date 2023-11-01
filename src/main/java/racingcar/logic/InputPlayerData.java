package racingcar.logic;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import racingcar.validation.Validation;

public class InputPlayerData {
    Validation validation = new Validation();

    public ArrayList<String> inputData() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String playerName = Console.readLine();
        ArrayList<String> players = new ArrayList<>();
        String[] comma = playerName.split(",");
        for (int i = 0; i < comma.length; i++) {
            validation.playerNameValidation(comma[i]);
            players.add(comma[i]);
        }
        return players;
    }
}
