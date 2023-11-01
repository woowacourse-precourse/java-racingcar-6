package Domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    public void testCar() {
        Car car = new Car("TestCar");

        assertThat(car.getPosition()).isEqualTo(0); // 초기 위치는 0이어야 합니다.

        int numberOfMoves = 5; // 시도 횟수
        int successfulMoves = 0; // 이동 성공의 횟수

        for (int i = 0; i < numberOfMoves; i++) {
            boolean canMove = car.move();
            System.out.println("\ncanMove: " + canMove);
            if (canMove) {
                car.setPosition(car.getPosition() + 1);
                System.out.println("getPosition: " + car.getPosition());
                successfulMoves++;
            }
        }

        assertThat(successfulMoves).isBetween(0, 10); // 이동 성공 횟수는 0에서 10 사이여야 합니다.
        assertThat(car.getCarName()).isEqualTo("TestCar"); // 자동차 이름이 "TestCar" 여야 합니다.
        assertThat(car.getPosition()).isEqualTo(successfulMoves); // 이동 후 위치는 이동 성공 횟수와 같아야 합니다.

        System.out.println("\nCar Name: " + car.getCarName());
        System.out.println("Car Position: " + car.getPosition());
    }
}
