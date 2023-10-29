package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.domain.StringConstant.CARS_SPLIT_DELIMITER;

class GameServiceTest {
    static List<RacingCar> racingCars1;
    static String[] names;

    @BeforeEach
    void setUp() {
        names = new String[] {"두산베어스", "한화이글스", "KT위즈"};
        racingCars1 = new ArrayList<>();

        for (int i = 0; i < 3; i++)
            racingCars1.add(RacingCar.createRacingCar(names[i]));
    }

    @DisplayName("레이싱카 생성")
    @Test
    void createRacingCars_입력값에_맞는_개수와_이름으로_RacingCar_리스트_생성() {
        // GIVEN, WHEN
        ByteArrayInputStream in = new ByteArrayInputStream(String.join(CARS_SPLIT_DELIMITER, names).getBytes());
        System.setIn(in);

        List<RacingCar> racingCars2 = GameService.createRacingCars();

        // THEN
        for (int i = 0; i < racingCars2.size(); i++)
            assertThat(racingCars1.get(i).getName()).isEqualTo(racingCars2.get(i).getName());
    }

    // 도저히 메서드의 로직이 제대로 돌아가는지 확인할 방법이 없다.
    // playGameForTimes()는 아무런 데이터도 반환하지 않는다.
    // 게다가, 0부터 9까지의 수를 임의로 뽑기 때문에, 지속적으로 0이 나올 경우 "자동차가 움직였는가"를 가지고 로직을 테스트할 수도 없는 노릇이다.
//    @DisplayName("일정한 횟수만큼 게임 진행")
//    @Test
//    void playGameForTimes_입력값에_맞는_횟수만큼_게임_진행() {
//        // GIVEN, WHEN
//        GameService.playGameForTimes((long)10, racingCars1);
//        long maxLocationInRacingCars1 = 0;
//
//        for (RacingCar racingCar : racingCars1)
//            maxLocationInRacingCars1 = Math.max(maxLocationInRacingCars1, racingCar.getLocation());
//
//        // THEN
//        assertThat().isEqualTo(maxLocationInRacingCars1);
//    }

    @DisplayName("최종 우승자 반환")
    @Test
    void findFinalWinner() {
        // GIVEN
        long maxLocation = 10;

        for (int i = 0; i < maxLocation; i++)
            racingCars1.get(0).putForward();

        // WHEN
        List<RacingCar> winners = GameService.findWinners(racingCars1);

        // THEN
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0).getName()).isEqualTo(racingCars1.get(0).getName());
    }
}