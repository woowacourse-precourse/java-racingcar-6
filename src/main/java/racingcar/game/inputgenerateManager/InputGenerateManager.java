package racingcar.game.inputgenerateManager;

import java.util.List;

public interface InputGenerateManager {
    Integer generateRandomInt();
    Integer generateInputStringToInt(String rawData);
    List<String> generateInputStringSplitWithComma(String rawData);
}
