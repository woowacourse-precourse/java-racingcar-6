package classTest;

import org.junit.jupiter.api.RepeatedTest;
import racingcar.controller.CarRaceGame;
import racingcar.model.Cars;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class CarRaceGameTest {
    private final CarRaceGame carRaceGame = new CarRaceGame();

    @RepeatedTest(10)
    void show_경기_경과_출력_테스트() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // private method 임시로 허용
        Method showRaceStepsMethod = CarRaceGame.class.
                getDeclaredMethod("showRaceSteps", Cars.class, int.class);
        showRaceStepsMethod.setAccessible(true);

        // given
        Cars cars = new Cars(Arrays.asList("jiyun","test","hoho"));
        int repeat = 4;

        // when
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // 기능 테스트 할때만 메서드 public으로 변경
        showRaceStepsMethod.invoke(carRaceGame,cars,repeat);

        // then
        assertThat(out.toString()).contains("jiyun : -","test : -", "hoho : -");
    }
}
