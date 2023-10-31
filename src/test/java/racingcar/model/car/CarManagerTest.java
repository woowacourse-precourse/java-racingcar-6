package racingcar.model.car;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("[Car Manager]")
class CarManagerTest {

    @Test
    @DisplayName("생성자 테스트")
    public void constructorTest() {
        assertThat(new CarManager(List.of(
                new RacingCar("b"),
                new RacingCar("cd")))
        ).isEqualTo(new CarManager(List.of(
                new RacingCar("b"),
                new RacingCar("cd")))
        );

    }

    @Test
    @DisplayName("자동차 이름 정상적으로 입력")
    public void validCarNames() {
        final String carNames = "abc,def,자동차1,자동차2,자동차3";
        Assertions.assertDoesNotThrow(
                () -> new CarManager(carNames)
        );
        assertThat(
                new CarManager("abc,def,자동차1,자동차2,자동차3").getCars().size()).isEqualTo(5);
    }

    @Test
    @DisplayName("최종 우승자 가져오기")
    public void getWinner() {
        final RacingCar test1Car = new RacingCar("test1", 10);
        final RacingCar sangwonCar = new RacingCar("sang", 4);
        final RacingCar dddddCar = new RacingCar("ddddd", 10);


        final CarManager carManager =
                new CarManager(List.of(test1Car,sangwonCar,dddddCar));

        List<Car> winner = carManager.getWinner();

        assertThat(winner.size()).isEqualTo(2);
        Assertions.assertTrue(winner.contains(test1Car));
        Assertions.assertFalse(winner.contains(sangwonCar));
        Assertions.assertTrue(winner.contains(dddddCar));
        assertThat(winner.get(0)).isEqualTo(test1Car);
        assertThat(winner.get(1)).isEqualTo(dddddCar);
    }



}