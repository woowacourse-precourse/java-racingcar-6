package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        CarNames carNames = new CarNames();
        Message.startMessage();
        List<String> playerList = carNames.inputCarnames();
        System.out.println(playerList);
    }
}
