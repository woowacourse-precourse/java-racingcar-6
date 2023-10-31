package racingcar;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RacingCarTest {
    @Test
    public void 전진할_수_있는지_알아보는_기능_0_9사이에서_4이상일_경우에만_전진_가능하다() {
        RacingCar racingCar = new RacingCar("dummy");
        double error = 0.05;
        int tryCnt = 100000;
        int trueCnt = 0;
        int falseCnt = 0;

        for (int i = 0; i < tryCnt; i++) {
            boolean canMove = racingCar.isAvailableMove();
            if (canMove) {
                trueCnt += 1;
                continue;
            }
            falseCnt += 1;
        }

        Assertions.assertThat(trueCnt + falseCnt).isEqualTo(tryCnt);
        Assertions.assertThat((double) trueCnt / tryCnt).isGreaterThan(0.6 - error);
    }

    @Test
    public void 자동차를_전진하는_기능() {
        RacingCar racingCar = new RacingCar("dummy");
        int initialDistance = racingCar.getMoveDistance();
        for (int i = 0; i < 6; i++) {
            racingCar.moveForward();
        }

        Assertions.assertThat(racingCar.getMoveDistance()).isEqualTo(initialDistance + 6);
    }

    @Test
    public void 자동차_위치를_출력하는_기능() {
        RacingCar racingCar = new RacingCar("dummy");
        String moveString = "";

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        int initialDistance = racingCar.getMoveDistance();
        for (int i = 0; i < initialDistance; i++) {
            moveString += "-";
        }

        for (int i = 0; i < 6; i++) {
            racingCar.moveForward();
            moveString += "-";
        }
        racingCar.printLocation();

        Assertions.assertThat(out.toString()).isEqualTo(racingCar.getName() + " : " + moveString + "\n");

    }
}