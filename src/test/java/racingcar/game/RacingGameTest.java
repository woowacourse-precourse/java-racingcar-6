package racingcar.game;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {

    @Test
    @DisplayName("Car 이름을 입력받아 저장할 수 있다.")
    void inputGame() {
        String inputCars = "woo,wa,cour,se";
        List<Car> cars = RacingGame.saveCars(inputCars);

        assertAll(
                () -> assertThat(cars.size()).isEqualTo(4),
                () -> assertThat(cars.get(0).getName()).isEqualTo("woo"),
                () -> assertThat(cars.get(1).getName()).isEqualTo("wa"),
                () -> assertThat(cars.get(2).getName()).isEqualTo("cour"),
                () -> assertThat(cars.get(3).getName()).isEqualTo("se")
        );
    }

    @Test
    @DisplayName("0~9 범위의 랜덤 숫자를 생성할 수 있다.")
    void generateRandomNumber() {
        int first = Randoms.pickNumberInRange(0, 9);
        int second = Randoms.pickNumberInRange(0, 9);
        int third = Randoms.pickNumberInRange(0, 9);

        assertAll(
                () -> assertThat(first).isLessThanOrEqualTo(9).isGreaterThanOrEqualTo(0),
                () -> assertThat(second).isLessThanOrEqualTo(9).isGreaterThanOrEqualTo(0),
                () -> assertThat(third).isLessThanOrEqualTo(9).isGreaterThanOrEqualTo(0)
        );
    }

    @Test
    @DisplayName("Car의 움직인 횟수를 '-'로 표현할 수 있다.")
    void convertMovementToString() {
        Car woo = new Car("woo");
        woo.updateMovingCount();
        woo.updateMovingCount();
        woo.updateMovingCount();

        String footprint = RacingGame.convertMovementToString(woo);

        assertThat(footprint).isEqualTo("---");
    }
}
