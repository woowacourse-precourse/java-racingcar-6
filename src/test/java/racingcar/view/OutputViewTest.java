package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class OutputViewTest {

    OutputView outputView = OutputView.getInstance();

    @Test
    void 자동차_전진_개수에_대한_위치_출력_테스트() {
        Car car1 = new Car("제네시스");
        car1.setAdvanceCount(3);

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        outputView.printCurrentCarPosition(car1);
        assertThat(out.toString()).contains("---");
    }

    @Test
    void 자동차_이름_출력_테스트() {
        Car car1 = new Car("제네시스");

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        outputView.printCarName(car1);
        assertThat(out.toString()).contains("제네시스 : ");
    }

    @Test
    void 최종_우승자_출력_문구_테스트() {

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        outputView.printFinalWinner(List.of("제네시스", "소나타"));
        assertThat(out.toString()).contains("최종 우승자 : 제네시스, 소나타");
    }
}