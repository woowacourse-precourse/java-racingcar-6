package racingcar.service;

import org.junit.jupiter.api.Test;
import racingcar.entity.RacingCarEntity;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PrintResultServiceTest {
    private final PrintResultService printResultService = new PrintResultService();

    List<RacingCarEntity> racingCarEntityList =
            List.of(
                    new RacingCarEntity("pobi",0),
                    new RacingCarEntity("woni",2)
            );

    List<RacingCarEntity> TwoWinnerRacingCarEntityList =
            List.of(
                    new RacingCarEntity("pobi",1),
                    new RacingCarEntity("woni",1)
            );

    @Test
    void 단일_우승자_출력_테스트(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        printResultService.printGameResult(racingCarEntityList);
        String printedOutput = outContent.toString();
        assertThat(printedOutput.trim()).isEqualTo("최종 우승자 : woni");
    }

    @Test
    void 동시_우승자_출력_테스트(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        printResultService.printGameResult(TwoWinnerRacingCarEntityList);
        String printedOutput = outContent.toString();
        assertThat(printedOutput.trim()).isEqualTo("최종 우승자 : pobi, woni");
    }

    @Test
    void 단일_우승자_리턴_테스트(){
        List<String> cars = printResultService.getWinners(racingCarEntityList);
        assertThat(cars.get(0)).isEqualTo("woni");
    }

    @Test
    void 동시_우승자_리턴_테스트(){
        List<String> cars = printResultService.getWinners(TwoWinnerRacingCarEntityList);
        assertThat(cars.get(1)).isEqualTo("woni");
    }

    @Test
    void 최고값_확인_테스트(){
        Integer maxCount = printResultService.getMaxMoveCount(racingCarEntityList);
        assertThat(maxCount).isEqualTo(2);
    }

}
