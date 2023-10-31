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