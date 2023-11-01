package view;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import model.Cars;
import model.Winners;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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

        assertThat(out.toString()).isEqualTo(
                "실행 결과" + System.getProperty("line.separator")
                        + "pobi : -" + System.getProperty("line.separator")
                        + "jun : " + System.getProperty("line.separator")
                        + "woni : -" + System.getProperty("line.separator"));
    }

    @Test
    public void 최종우승자들_출력하는_테스트() {
        Cars cars = new Cars("pobi,jun,woni");
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        cars.getCars().get(0).tryMove(4);
        cars.getCars().get(1).tryMove(3);
        cars.getCars().get(2).tryMove(5);

        Winners winners= new Winners(cars.getCars());
        outputView.printWinner(winners);
        assertThat(out.toString()).isEqualTo(
                "최종 우승자 : pobi, woni");
    }
}
