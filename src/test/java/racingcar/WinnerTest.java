package racingcar;

import java.util.List;
import java.util.stream.IntStream;
import org.assertj.core.api.Assertions;
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

public class WinnerTest {

    private Participants participants;

    @BeforeEach
    void 참가자_저장() {
        String s = "a,b,c,d,e";
        String[] split = s.split(InputConfig.NAME_DELIMITER);
        participants = CarSaveService.save(split);
    }

    @Test
    @DisplayName("참가자중 가장 Position 값이 높은 사람들이 우승자가 된다.")
    void 우승자_테스트() {
        RaceService raceService = new FixDistanceRaceService();
        for(int i=0; i<5; i++){
            raceService.runRace(participants);
        }

        int highestPosition = IntStream.range(0, participants.size())
                .mapToObj(i -> participants.getCar(i))
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();

        List<String> strings = IntStream.range(0, participants.size())
                .mapToObj(i -> participants.getCar(i))
                .filter(car -> car.getPosition() == highestPosition)
                .map(Car::getName)
                .toList();

        List<String> winnersNames = GetWinnersService.getWinnersNames(participants);

        Assertions.assertThat(winnersNames).isEqualTo(strings);
    }
}
