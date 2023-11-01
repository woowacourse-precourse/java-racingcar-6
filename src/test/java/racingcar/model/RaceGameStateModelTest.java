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
            assertThat(distance).isEqualTo(0);
        }
    }

    /**
     * Tests method getTotalRound
     */
    @Test
    void getTotalRoundTest() {
        // then
        assertThat(raceGameStateModel.getTotalRound()).isEqualTo(5);
    }

    /**
     * Tests method getUserCarDistance(String key) if it gets the value correctly
     */
    @Test
    void getUserCarDistanceWithKeyTest() {
        // then
        assertThat(raceGameStateModel.getUserCarDistance("poby")).isEqualTo(0);
        assertThat(raceGameStateModel.getUserCarDistance("wony")).isEqualTo(0);
        assertThat(raceGameStateModel.getUserCarDistance("jun")).isEqualTo(0);
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
        assertThat(raceGameStateModel.getUserCarDistance()).isEqualTo(userCarDistance);
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
        assertThat(raceGameStateModel.getUserCarDistance("poby")).isEqualTo(1);
        assertThat(raceGameStateModel.getUserCarDistance("wony")).isEqualTo(2);
        assertThat(raceGameStateModel.getUserCarDistance("jun")).isEqualTo(3);
    }
}