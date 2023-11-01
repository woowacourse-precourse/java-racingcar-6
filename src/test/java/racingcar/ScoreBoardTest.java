package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.CarData;
import racingcar.model.GameModel;

public class ScoreBoardTest {

    @ParameterizedTest
    @ValueSource(strings = {"lsw  ", "  lsw", " lsw ", "lsw"})
    void 이름에_포함된_공백_제거_확인(String inputNames) {

        GameModel gameModel = new GameModel(inputNames, "1");

        for (CarData car : gameModel.aggregateRoundScore()) {
            String carName = car.getName();
            assertEquals("lsw", carName);
        }

    }

    
}
