package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

/**
 * Gets input from the user
 */
public class InputReceiver {

    /**
     * Reads car names from the user.
     * @return a raw string the user has input.
     */
    public String readCarNames() {
        return Console.readLine();
    }

    /**
     * Reads the number indicates how many cars would try to proceed.
     * @return a raw string which is an integer.
     */
    public String readNumOfTries() {
        return Console.readLine();
    }
}
