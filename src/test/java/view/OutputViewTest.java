package view;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import model.Cars;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
    OutputView outputView = new OutputView();

    @Test
    public void 실행_결과_테스트() {
        Cars cars = new Cars("pobi,jun,woni");
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        cars.getCars().get(0).tryMove(4);
        cars.getCars().get(1).tryMove(3);
        cars.getCars().get(2).tryMove(9);

        outputView.printCarsPosition(cars);

        Assertions.assertThat(out.toString()) .isEqualTo(
                "실행 결과"+System.getProperty("line.separator")
                        + "pobi : -"+System.getProperty("line.separator")
                        + "jun : "+System.getProperty("line.separator")
                        + "woni : -"+System.getProperty("line.separator"));
    }
}
