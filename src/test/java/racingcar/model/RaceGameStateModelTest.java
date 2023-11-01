package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests class RaceGameStateModel method function correctly
 */
class RaceGameStateModelTest {

    ArrayList<String> userCarNames;
    private RaceGameStateModel raceGameStateModel;

    /**
     * Initialize raceGameStateModel to test methods
     */
    @BeforeEach
    void initializedRaceGameStateModel() {
        // given
        userCarNames = new ArrayList<>();
        userCarNames.add("poby");
        userCarNames.add("wony");
        userCarNames.add("jun");
        int totalRound = 5;
        raceGameStateModel = new RaceGameStateModel(totalRound, userCarNames);
    }

    /**
     * Tests method initializeUserCarDistance if it initializes the value with zero
     */
    @Test
    void initializeUserCarDistanceTest() {
        // when
        raceGameStateModel.initializeUserCarDistance(userCarNames);

        // then
        for (String userCarName : userCarNames) {
            Integer distance = raceGameStateModel.getUserCarDistance(userCarName);
            assertThat(0).isEqualTo(distance);
        }
    }

    /**
     * Tests method getTotalRound
     */
    @Test
    void getTotalRoundTest() {
        // then
        assertThat(5).isEqualTo(raceGameStateModel.getTotalRound());
    }

    /**
     * Tests method getUserCarDistance(String key) if it gets the value correctly
     */
    @Test
    void getUserCarDistanceWithKeyTest() {
        // then
        assertThat(0).isEqualTo(raceGameStateModel.getUserCarDistance("poby"));
        assertThat(0).isEqualTo(raceGameStateModel.getUserCarDistance("wony"));
        assertThat(0).isEqualTo(raceGameStateModel.getUserCarDistance("jun"));
    }

    /**
     * Test method getUserCarDistance if it gets userCarDistance correctly
     */
    @Test
    void getUserCarDistanceTest() {
        HashMap<String, Integer> userCarDistance = new HashMap<>();
        userCarDistance.put("poby", 0);
        userCarDistance.put("wony", 0);
        userCarDistance.put("jun", 0);

        // then
        assertThat(userCarDistance).isEqualTo(raceGameStateModel.getUserCarDistance());
    }

    /**
     * Test method updateUserDistance if it updates the value correctly
     */
    @Test
    void updateUserDistanceTest() {
        // when
        raceGameStateModel.updateUserDistance("poby", 1);
        raceGameStateModel.updateUserDistance("wony", 2);
        raceGameStateModel.updateUserDistance("jun", 3);

        // then
        assertThat(1).isEqualTo(raceGameStateModel.getUserCarDistance("poby"));
        assertThat(2).isEqualTo(raceGameStateModel.getUserCarDistance("wony"));
        assertThat(3).isEqualTo(raceGameStateModel.getUserCarDistance("jun"));
    }
}