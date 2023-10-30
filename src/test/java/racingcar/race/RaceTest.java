package racingcar.race;

import java.util.Map;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.AppConfig;
import racingcar.model.Participants;
import racingcar.model.car.Car;
import racingcar.service.CarSaveService;
import racingcar.service.FixDistanceRaceService;
import racingcar.service.RaceService;
import racingcar.service.VariableDistanceRaceService;

public class RaceTest {
    private Participants participants;

    @BeforeEach
    void 참가자_저장() {
        String s = "a,b,c,d,e";
        String[] split = s.split(AppConfig.INPUT_DELIMITER);
        participants = CarSaveService.save(split);
    }

    @Test
    void 고정거리_서비스_테스트() {
        RaceService raceService = new FixDistanceRaceService();
        Map<Car, Integer> map = raceService.runRace(participants);

        SoftAssertions softly = new SoftAssertions();
        map.entrySet().stream().forEach(entry -> {
            Integer distance = entry.getValue();
            Integer position = entry.getKey().getPosition();
            if (distance < 4) {
                softly.assertThat(position).isEqualTo(0);
            }
            if (distance >= 4) {
                softly.assertThat(position).isEqualTo(1);
            }
        });
        softly.assertAll();
    }

    @Test
    void 변동거리_서비스_테스트() {
        RaceService raceService = new VariableDistanceRaceService();
        Map<Car, Integer> map = raceService.runRace(participants);

        SoftAssertions softly = new SoftAssertions();
        map.entrySet().stream().forEach(entry -> {
            Integer distance = entry.getValue();
            Integer position = entry.getKey().getPosition();
            if (distance < 4) {
                softly.assertThat(position).isEqualTo(0);
            }
            if (distance >= 4) {
                softly.assertThat(position).isIn(4,5,6,7,8,9);
            }
        });
        softly.assertAll();
    }
}
