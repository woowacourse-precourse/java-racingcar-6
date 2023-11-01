package racingcar.input;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;
import racingcar.input.InputValidatorTest.InputValidator;

public class CarTest {
    private static final String 차이름 = "차1";
    private static final Car 차객체 = Car.inputCarname(차이름);

    public static class Car {
        private String carName;
        private StringBuilder driving;
        private static final char MOVE_FORMAT = '-';
        private static final int MOVE_CONDITION = 4;
        private static final int START_INCLUSIVE = 0;
        private static final int END_INCLUSIVE = 9;

        public static Car inputCarname(final String carName) {
            return new Car(carName);
        }

        private Car(final String carName) {
            InputValidator.validateCarname(carName);
            this.carName = carName;
            this.driving = new StringBuilder();
        }

        private Car() {

        }

        public void moveCar() {
            if (isMove()) {
                move();
            }
        }

        private boolean isMove() {
            int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);

            return randomNumber >= MOVE_CONDITION;
        }

        private void move() {
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

    @Test
    void 차_이동_가능여부_확인() {
        차객체.moveCar();
    }

}
