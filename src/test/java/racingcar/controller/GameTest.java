package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.common.type.Names;
import racingcar.common.type.TrialCount;
import racingcar.domain.Car;
import racingcar.domain.RacingCars;
import racingcar.dto.output.AllRoundDTO;
import racingcar.dto.output.RoundDTO;

public class GameTest {

    @Test
    public void play_메서드_테스트() {
        // given
        Names names = Names.of(new String[]{"hyunjin", "pobi", "lefthand"});
        List<Car> carList = Car.createCarList(names);
        RacingCars newRacingCars = RacingCars.of(carList, () -> true);
        TrialCount newTrialCount = TrialCount.of("3");
        Game game = Game.of(newRacingCars);

        // when
        List<AllRoundDTO> allRoundResults = game.play(newTrialCount);

        // then, 마지막 라운드만 체크
        AllRoundDTO lastRound = allRoundResults.get(allRoundResults.size() - 1);
        List<RoundDTO> roundDTOs = lastRound.roundDTOs();

        List<String> roundStrings = roundDTOs
                .stream()
                .map(RoundDTO::toString)
                .collect(Collectors.toList());

        // 모든 차가 이동할 수 있으므로 각 차의 거리가 증가해야 함
        List<String> expectedRoundStrings = Arrays.asList("hyunjin : ---", "pobi : ---", "lefthand : ---");
        Assertions.assertEquals(expectedRoundStrings, roundStrings);
    }

}
