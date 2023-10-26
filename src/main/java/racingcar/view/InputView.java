package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class InputView {

    public String[] inputPlayers() {
        String[] players = Console.readLine().split(",");
        return players;
    }

    public int inputTimes() {
        int number_of_times = Integer.parseInt(Console.readLine());
        return number_of_times;
    }

}
