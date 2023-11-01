package Domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    public void testCar() {
        Car car = new Car("TestCar");

        assertThat(car.getPosition()).isEqualTo(0); // 초기 위치 0

        int numberOfMoves = 5; // 시도 횟수
        int successfulMoves = 0; // 이동 성공의 횟수

        // 시도 횟수에 따라 4 이상이면 Move 실행
        for (int i = 0; i < numberOfMoves; i++) {
            boolean canMove = car.move();
            System.out.println("\ncanMove: " + canMove);
            if (canMove) {
                car.setPosition(car.getPosition());
                System.out.println("getPosition: " + car.getPosition());
                successfulMoves++;
            }
        }

        assertThat(successfulMoves).isBetween(0, 10); // 이동 성공 횟수는 0에서 10 사이
        assertThat(car.getCarName()).isEqualTo("TestCar");
        assertThat(car.getPosition()).isEqualTo(successfulMoves); // 이동 후 위치는 이동 성공 횟수와 같아야 함

        System.out.println("\nCar Name: " + car.getCarName());
        System.out.println("Car Position: " + car.getPosition());
    }
}
