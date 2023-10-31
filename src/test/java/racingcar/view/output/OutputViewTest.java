package racingcar.view.output;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.dto.RoundResult;
import racingcar.model.dto.Winners;
import racingcar.model.gameinfo.CarInfo;

class OutputViewTest {

    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    protected final void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    protected final void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    protected final String output() {
        return captor.toString().trim();
    }

    private List<CarInfo> createCarInfos(Map<String, Integer> createInfo) {
        List<CarInfo> carInfos = new ArrayList<>();

        createInfo.forEach((name, position) -> {
            CarInfo carInfo = new CarInfo(name);
            setCarPosition(position, carInfo);
            carInfos.add(carInfo);
        });

        return carInfos;
    }

    private void setCarPosition(Integer position, CarInfo carInfo) {
        for (int i = 0; i < position; i++) {
            carInfo.proceed();
        }
    }

    @Test
    @DisplayName("라운드 결과 출력")
    public void resultOutput() {
        Map<String, Integer> createInfo = new HashMap<>();
        createInfo.put("A", 5);
        createInfo.put("B", 3);
        createInfo.put("C", 4);

        List<CarInfo> carInfos = createCarInfos(createInfo);
        RoundResult roundResult = new RoundResult(carInfos);
        OutputView outputView = new OutputView();

        outputView.printRoundResult(roundResult);
        Assertions.assertThat(output()).contains("A : -----", "B : ---", "C : ----");
    }

    @Test
    @DisplayName("라운드 결과 출력2")
    public void resultOutput2() {
        Map<String, Integer> createInfo = new HashMap<>();
        createInfo.put("A", 5);
        createInfo.put("B", 8);
        createInfo.put("C", 4);

        List<CarInfo> carInfos = createCarInfos(createInfo);
        RoundResult roundResult = new RoundResult(carInfos);
        OutputView outputView = new OutputView();
        outputView.printRoundResult(roundResult);

        Assertions.assertThat(output()).contains("A : -----", "B : --------", "C : ----");
    }

    @Test
    @DisplayName("우승자 출력 - 단일")
    public void winnerOutput() {
        List<String> winnerList = List.of("A");
        Winners winners = new Winners(winnerList);

        OutputView outputView = new OutputView();
        outputView.printWinner(winners);

        Assertions.assertThat(output()).contains("최종 우승자 : A");
    }

    @Test
    @DisplayName("우승자 출력 - 복수")
    public void winnerOutput2() {
        List<String> winnerList = List.of("A", "B");
        Winners winners = new Winners(winnerList);

        OutputView outputView = new OutputView();
        outputView.printWinner(winners);

        Assertions.assertThat(output()).contains("최종 우승자 : A, B");
    }
}