package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputPlayers() {
        String players = Console.readLine();
        return players;
    }

    public String inputTimes() {
        String number_of_times = Console.readLine();
        return number_of_times;
    }

}
