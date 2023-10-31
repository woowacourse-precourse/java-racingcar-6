package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputViewImpl implements InputView {
    private static InputViewImpl instance = new InputViewImpl();

    private InputViewImpl() {
    }

    public static InputViewImpl getInstance() {
        return instance;
    }

    @Override
    public String readLine() {
        return Console.readLine();
    }
}

