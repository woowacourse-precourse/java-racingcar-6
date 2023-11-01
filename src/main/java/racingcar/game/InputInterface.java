package racingcar.game;

import static racingcar.game.TextResourceManager.INPUT_NAMES_TEXT;
import static racingcar.game.TextResourceManager.INPUT_TRIAL_TEXT;

import game.Input;
import game.Output;

public class InputInterface implements Input {
    private Input in;
    private Output out;

    public InputInterface(Input in, Output out) {
        this.in = in;
        this.out = out;
    }

    public String[] getNames() {
        out.println(INPUT_NAMES_TEXT);
        String input = in.readLine();
        if ("".equals(input)) {
            throw new IllegalArgumentException("자동차 이름을 입력하지 않았습니다.");
        }
        return input.split(",");
    }

    public int getTrial() {
        out.println(INPUT_TRIAL_TEXT);
        String input = in.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자 값이 아닙니다.");
        }
    }

    @Override
    public String readLine() {
        return in.readLine();
    }
}
