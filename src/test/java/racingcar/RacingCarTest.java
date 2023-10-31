package racingcar;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

    @Test
    void createTest_인스턴스_생성_성공() {
        String name = "test";
        RacingCar racingCar = new RacingCar(name);

        Assertions.assertThat(racingCar.getName()).isEqualTo("test");
    }

    @Test
    void createTest_인스턴스_생성_실패_5글자_이상() {
        String name = "test11";

        Assertions.assertThatThrownBy(() -> new RacingCar(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void carMoveTest_1칸_움직이기_테스트() {
        RacingCar racingCar = new RacingCar("test");
        racingCar.moveOneBlock();

        Assertions.assertThat(racingCar.getCount()).isEqualTo(1);
    }

    @Test
    void printCurrentResultTest_현재_결과_출력_테스트() {
        String result = "test : -\n";
        RacingCar racingCar = new RacingCar("test");
        racingCar.moveOneBlock();

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        racingCar.printCurrentResult();
        Assertions.assertThat(out.toString()).isEqualTo(result);

    }


}
