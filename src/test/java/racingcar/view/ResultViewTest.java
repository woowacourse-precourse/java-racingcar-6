package racingcar.view;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import racingcar.model.CarModel;

public class ResultViewTest {

    @Test
    void 최종우승자_여러명일때_출력_테스트() {
        String expectedResult = "최종 우승자 : carA, carB\n";
        OutputStream out = initIOStream();

        ResultView resultView = new ResultView();
        ArrayList<CarModel> carModels = new ArrayList<>();

        //given
        carModels.add(new CarModel("carA"));
        carModels.add(new CarModel("carB"));

        //when
        resultView.showWinnerCars(carModels);

        //then
        assertThat(out.toString()).isEqualTo(expectedResult);
    }

    @Test
    void 최종우승자_한명일때_출력_테스트() {
        String expectedResult = "최종 우승자 : carA\n";
        OutputStream out = initIOStream();

        ResultView resultView = new ResultView();
        ArrayList<CarModel> carModels = new ArrayList<>();

        //given
        carModels.add(new CarModel("carA"));

        //when
        resultView.showWinnerCars(carModels);

        //then
        assertThat(out.toString()).isEqualTo(expectedResult);
    }
    private static OutputStream initIOStream() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        return out;
    }
}
