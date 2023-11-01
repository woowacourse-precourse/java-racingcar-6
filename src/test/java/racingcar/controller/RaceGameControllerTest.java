package racingcar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import racingcar.OutputTestSupport;
import racingcar.dto.RaceGameInfoDto;
import racingcar.domain.car.Car;
import racingcar.domain.car.RaceCars;
import racingcar.dto.WinnerCarDto;
import racingcar.util.Randoms;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.*;

class RaceGameControllerTest extends OutputTestSupport {

    private RaceGameController raceGameController = new RaceGameController();

    @Test
    @DisplayName("사용자의 게임 정보를 얻을 수 있다.")
    public void startRaceGame() {
        // when
        userRequest();
        RaceGameInfoDto raceGameInfoDto = raceGameController.startRaceGame();
        // then
        List<Car> cars = raceGameInfoDto.raceCars().getCars();
        int attemptCount = raceGameInfoDto.attemptCount();

        assertThat(cars).hasSize(1)
                .extracting("name", "moveCount")
                .contains(
                        tuple("haen", 0)
                );
        assertThat(attemptCount).isEqualTo(2);
    }

    private void userRequest(){
        String input = "haen\n2";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        raceGameController = new RaceGameController();
    }

    @Test
    @DisplayName("게임을 진행하는 객체를 생성해서 실행한다.")
    public void run() {
        // given
        String result = "\n실행 결과\n" +
                        "haen : -\n" +
                        "\n" +
                        "haen : --\n\n";
        RaceCars raceCars = new RaceCars(List.of(new Car("haen")));


        try (final MockedStatic<Randoms> randoms = Mockito.mockStatic(Randoms.class)) {
            BDDMockito.given(Randoms.getNumber()).willReturn(4);
            // when
            raceGameController.run(new RaceGameInfoDto(raceCars,2));
        }
        //then
        assertThat(getOutput()).isEqualTo(result);
    }

    @Test
    @DisplayName("승리한 자동차의 이름을 출력할 수 있다.")
    public void printWinningCarNames() {
        // given
        String result = "최종 우승자 : haen";
        RaceCars raceCars = new RaceCars(List.of(new Car("haen")));
        // when
        raceGameController.printWinningCarNames(new WinnerCarDto(raceCars.getWinningCarNames()));
        // then
        assertThat(getOutput()).isEqualTo(result);
    }

}