package racingcar;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.config.InputConfig;
import racingcar.model.Participants;
import racingcar.model.car.Car;
import racingcar.service.CarSaveService;
import racingcar.service.GetWinnersService;
import racingcar.service.raceservice.FixDistanceRaceService;
import racingcar.service.raceservice.RaceService;
import racingcar.service.raceservice.VariableDistanceRaceService;

public class RaceTest {
    private Participants participants;

    @BeforeEach
    void 참가자_저장() {
        String s = "a,b,c,d,e";
        String[] split = s.split(InputConfig.NAME_DELIMITER);
        participants = CarSaveService.save(split);
    }

    @DisplayName("0~3이 나오면 움직이지 않고, 4~9일때만 움직인다.")
    @Test
    void 고정거리_서비스_테스트() {
        RaceService raceService = new FixDistanceRaceService();
        Map<Car, Integer> result = raceService.runRace(participants);

        SoftAssertions softly = new SoftAssertions();
        result.entrySet().stream().forEach(entry -> {
            Integer carPosition = entry.getKey().getPosition();
            Integer distance = entry.getValue();

            softly.assertThat(distance).isIn(0,1,2,3,4,5,6,7,8,9);

            if (distance < 4) {
                softly.assertThat(carPosition).isEqualTo(0);
            }
            if (distance >= 4) {
                softly.assertThat(carPosition).isEqualTo(1);
            }
        });
        softly.assertAll();
    }

    @Test
    void 변동거리_서비스_테스트() {
        RaceService raceService = new VariableDistanceRaceService();
        Map<Car, Integer> result = raceService.runRace(participants);

        SoftAssertions softly = new SoftAssertions();
        result.entrySet().stream().forEach(entry -> {
            Integer carPosition = entry.getKey().getPosition();
            Integer distance = entry.getValue();

            softly.assertThat(distance).isIn(0,1,2,3,4,5,6,7,8,9);

            if (distance < 4) {
                softly.assertThat(carPosition).isEqualTo(0);
            }
            if (distance >= 4) {
                softly.assertThat(carPosition).isIn(4,5,6,7,8,9);
            }
        });
        softly.assertAll();
    }
}
