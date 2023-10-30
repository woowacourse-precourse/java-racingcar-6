package racingcar.race;

import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.AppConfig;
import racingcar.InputConfig;
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

    @Test
    void 우승자_테스트() {
        RaceService raceService = new FixDistanceRaceService();
        raceService.runRace(participants);
        List<String> winnersNames = GetWinnersService.getWinnersNames(participants);
        Assertions.assertThat(winnersNames).containsAnyOf("a","b","c","d","e");
    }
}
