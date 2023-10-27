package racingcar.game.inputgenerateManager;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.game.enums.NumberSize;

public class InputGenerateManagerImpl implements InputGenerateManager {
    @Override
    public int generateRandomInt() {
        return Randoms.pickNumberInRange(NumberSize.START_INCLUSIVE.getSize(), NumberSize.END_INCLUSIVE.getSize());
    }

    @Override
    public int generateInputStringToInt() {
        return 0;
    }

    @Override
    public List<String> generateInputStringSplitWithComma() {
        return null;
    }
}
