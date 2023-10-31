package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.component.Car;
import racingcar.component.Inputter;
import racingcar.component.Printer;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private Inputter inputter;
    private Printer printer;

    @BeforeEach
    void initAll() {
        this.inputter = Inputter.getInputter();
        this.printer = Printer.getPrinter();
    }


    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도할 횟수 입력에 대한 예외 테스트")
    void 시도할_회수_예외_처리() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "two"))
                .isInstanceOf(IllegalArgumentException.class)
        );
        System.out.println();
    }

    @Test
    @DisplayName("차량 전진 기능 테스트")
    void 차량_전진_테스트() {
        Car car = new Car("wj");
        assertThat(car.getProgress()).isEqualTo("");
        car.go();
        assertThat(car.getProgress()).isEqualTo("-");
    }

    @Test
    @DisplayName("실행 결과 출력이 올바른지에 대한 테스트")
    void 실행_결과_출력() {
        Car car1 = new Car("wj");
        Car car2 = new Car("pobi");
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        car1.go();
        car2.go();
        car2.go();

        List<Car> carList = new ArrayList<>(List.of(car1, car2));
        printer.printCurrent(carList);

        assertThat(out.toString()).isEqualTo("""
            wj : -
            pobi : --
            
            """);
    }

    @Test
    @DisplayName("최종 우승자 출력이 올바른지에 대한 테스트")
    void 최종_우승_출력() {
        Car car1 = new Car("wj");
        Car car2 = new Car("pobi");
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        car1.go();
        car2.go();
        car2.go();

        List<Car> carList = new ArrayList<>(List.of(car1, car2));
        printer.printWinner(carList);

        assertThat(out.toString()).isEqualTo("최종 우승자 : pobi\n");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
