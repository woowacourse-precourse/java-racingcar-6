package racingcar.input;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {
    private static final String 차이름 = "차1";
    private static final Car 차객체 = Car.inputCarname(차이름);

    public static class Car {
        private String carName;
        private StringBuilder driving;
        private static final char MOVE_FORMAT = '-';

        public static Car inputCarname(String carName) {
            return new Car(carName);
        }

        private Car(String carName) {
            this.carName = carName;
            this.driving = new StringBuilder();
        }

        private Car() {

        }

        public void move() {
            this.driving.append(MOVE_FORMAT);
        }

        public String getCarName() {
            return this.carName;
        }

        public StringBuilder getDriving() {
            return this.driving;
        }
    }

    @Test
    void 차_이동_정상() {
        차객체.move();

        assertThat(차객체.getDriving().toString()).isEqualTo("-");
    }

    @Test
    void 차_이름_정상() {
        String carName = 차객체.getCarName();

        assertThat(차이름).isEqualTo(carName);
    }

}
