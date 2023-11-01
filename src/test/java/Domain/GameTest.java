package Domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    @Test
    public void testGame() {
        // 자동차 객체 생성
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");

        // 게임 객체 생성
        Car[] cars = {car1, car2, car3};
        int tryCount = 5;
        Game game = new Game(cars, tryCount);

        // 초기 위치 확인
        for (Car car : cars) {
            assertThat(car.getPosition()).isEqualTo(0);
        }

        // 게임 실행
        game.runGame();

        for (Car car : cars) {
            String carName = car.getCarName();
            int position = car.getPosition();
            StringBuilder positionString = new StringBuilder();
            for (int i = 0; i < position; i++) {
                positionString.append("-");
            }
            System.out.println(carName + " : " + positionString);
        }

        // 우승자 확인
        String winners = game.getWinners();
        System.out.println("Winners: " + winners);

        // 우승자 검증
        for (Car car : cars) {
            if (car.getPosition() == game.getMaxPosition()) {
                assertThat(winners).contains(car.getCarName());
            }
        }
    }
}
