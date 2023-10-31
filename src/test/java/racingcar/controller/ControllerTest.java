package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.model.RacingModel;

public class ControllerTest {

    private RacingModel racingModel;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private StringBuilder sb = new StringBuilder();


    @BeforeEach()
    void setEach() {
        System.setOut(new PrintStream(out));
    }

    @ParameterizedTest
    @CsvSource({"4,4,3,kimlee", "1,2,3,son", "1,1,1,kimleeson"})
    void 결과_출력_테스트(int distance1, int distance2, int distance3, String winner) { // 우승자에 따른 결과 출력이 올바른지 확인하는 테스트코드

        int[] movingDistance = {distance1, distance2, distance3};
        List<String> players = new ArrayList<>(Arrays.asList(new String[]{"kim", "lee", "son"}));
        racingModel = new RacingModel(players, 0);
        racingModel.setMoving_distance(movingDistance);
        RacingController racingController = new RacingController(racingModel);
        sb.append(winner);

        for (int num = winner.length() - 3; num > 2; num -= 3) {
            sb.insert(num, ", ");
        }

        racingController.racingResult();
        assertThat("최종 우승자 : " + sb).isEqualTo(out.toString());

    }

}
