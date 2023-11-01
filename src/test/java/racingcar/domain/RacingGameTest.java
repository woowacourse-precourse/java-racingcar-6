package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingGameTest {
    private RacingGame racingGame;
    private User user;
    private String[] carsNameArray = {"pobi", "woni", "jun"};

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame();
    }

    @Test
    void 자동차_배열_리스트로_변환() {
        List<String> carNameEntryKeyList = new ArrayList();
        List<Integer> scoreEntryValueList = new ArrayList();

        racingGame.setScoreEntryList(carsNameArray);
        for(Entry<String, Integer> entry : racingGame.getScoreEntryList()) {
            carNameEntryKeyList.add(entry.getKey());
            scoreEntryValueList.add(entry.getValue());
        }

        List<String> expectedKeyList = new ArrayList<>(Arrays.asList("pobi", "woni", "jun"));
        List<Integer> expectedValueList = new ArrayList<>(Arrays.asList(0, 0, 0));

        assertThat(carNameEntryKeyList)
                .isEqualTo(expectedKeyList);
        assertThat(scoreEntryValueList)
                .isEqualTo(expectedValueList);
    }

    @Test
    void 자동차_전진_테스트() {
        Integer testIndex = 0;
        racingGame.setScoreEntryList(carsNameArray);
        racingGame.carMoveOneStepForward(testIndex);

        assertThat(racingGame.getScoreEntryList().get(testIndex).getValue())
                .isEqualTo(1);
    }
}