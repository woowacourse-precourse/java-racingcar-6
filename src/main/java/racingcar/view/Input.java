package racingcar.view;

import static racingcar.constant.Constant.GAME_START_MESSAGE;
import static racingcar.constant.Constant.PLAY_TIME_QUESTION;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.InputValidator;

public class Input {

    private InputValidator inputValidator;

    public Input() {
    }

    public void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printPlayTimeQuestion() {
        System.out.println(PLAY_TIME_QUESTION);
    }

    public List<String> writeCarNames() {
        validateCarNames(Console.readLine());
        return inputValidator.convertList();
    }

    private void validateCarNames(String carNames) {
        inputValidator = new InputValidator(carNames);
        inputValidator.validateCarNames();
    }

    public Integer writePlayTime() {
        validatePlayTime(Console.readLine());
        return inputValidator.getPlayTime();
    }

    private void validatePlayTime(String playTime) {
        inputValidator = new InputValidator();
        inputValidator.validateTime(playTime);
    }

    public void close() {
        Console.close();
    }

}
