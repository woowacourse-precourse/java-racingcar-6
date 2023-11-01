package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void 수가_4_이상일_경우_전진횟수_증가() {
        Car car = new Car("honi", 2);
        int randomNumber = 5;

        int movingCount = car.updateMovingCountOrNot(randomNumber);
        assertThat(movingCount).isEqualTo(3);
    }

    @Test
    void 수가_4_미만일_경우_전진횟수_그대로() {
        Car car = new Car("honi", 2);
        int randomNumber = 3;

        int movingCount = car.updateMovingCountOrNot(randomNumber);
        assertThat(movingCount).isEqualTo(2);
    }

    @Test
    void 이름과_전진횟수만큼_하이픈_출력() {
        Car car = new Car("honi", 5);
        String movingWay = car.getResult();
        String resultWay = "honi : -----";
        assertThat(movingWay).isEqualTo(resultWay);
    }

    @Test
    void 우승자에_포함() {
        Car car = new Car("honi", 5);
        int maxCount = 5;
        boolean winnerCheck = car.isWinner(maxCount);

        assertThat(winnerCheck).isEqualTo(true);
    }

    @Test
    void 우승자에_포함_안됨() {
        Car car = new Car("honi", 3);
        int maxCount = 5;
        boolean winnerCheck = car.isWinner(maxCount);

        assertThat(winnerCheck).isEqualTo(false);
    }
}