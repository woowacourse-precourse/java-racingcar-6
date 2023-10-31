package racingcar.view;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.OneGameResultsDto;
import racingcar.service.domain.Car;
import racingcar.service.domain.CarEngine;
import racingcar.service.domain.RacingCars;

class OutputViewTest {

    PrintStream standardOut;
    OutputStream outputStream;

    OutputView outputView = new OutputView();

    static final String pobi = "pobi";
    static final String jungi = "jungi";
    static final String leo = "leo";

    static final String expectedOutput = """
                      
            실행 결과
            pobi :\s
            jungi : -
            leo :\s
                        
            pobi : -
            jungi : --
            leo :\s
                        
            pobi : --
            jungi : --
            leo :\s
                        
            최종 우승자 : pobi, jungi""";

    @BeforeEach
    void beforeEach() {
        standardOut = System.out;
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void afterEach() {
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("총 3라운드 게임 진행했을 때의 출력 메시지")
    void printResultTest() {
        // given
        RacingCars racingCars = getCustomEngineRacingCars();
        // when
        outputView.printPlayResultText();
        playGame(racingCars);
        List<String> winners = racingCars.findWinners();
        outputView.printFinalWinners(winners);
        // then
        Assertions.assertThat(outputStream.toString()).isEqualTo(expectedOutput);
    }

    private void playGame(RacingCars racingCars) {
        for (int round = 0; round < 3; round++) {
            List<Car> endCars = racingCars.doRace();
            OneGameResultsDto oneGameResultsDto = new OneGameResultsDto(endCars);
            outputView.printResult(oneGameResultsDto);
        }
    }

    private RacingCars getCustomEngineRacingCars() {
        List<String> carNameList = Arrays.asList(pobi, jungi, leo);
        return new RacingCars(carNameList, new CustomCarEngine());
    }

    static class CustomCarEngine implements CarEngine {
        List<Integer> enginePowers1 = Lists.newArrayList(1, 4, 1);
        List<Integer> enginePowers2 = Lists.newArrayList(4, 6, 3);
        List<Integer> enginePowers3 = Lists.newArrayList(5, 1, 2);

        @Override
        public int generateNumber() {
            if (!enginePowers1.isEmpty()) {
                return enginePowers1.remove(0);
            }
            if (!enginePowers2.isEmpty()) {
                return enginePowers2.remove(0);
            }
            return enginePowers3.remove(0);
        }
    }
}