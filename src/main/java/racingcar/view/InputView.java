package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.utils.Constant.*;

public class InputView {
    public String[] getCarNames() {
        System.out.println(MSG_CAR_NAMES);
        String names = Console.readLine();
        return names.split(COMMA);
    }

    public int getCount() {
        System.out.println(MSG_COUNT);
        try {
            return Integer.parseInt(Console.readLine());
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        }
    }
}
