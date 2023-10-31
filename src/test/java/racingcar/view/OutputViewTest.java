package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCars;
import racingcar.dto.output.AllRoundDTO;
import racingcar.dto.output.WinnerDTO;
import racingcar.util.TestContext;
import racingcar.util.TestInitializer;

public class OutputViewTest extends NsTest {
    private TestContext context;

    @BeforeEach
    public void setUp() {
        context = new TestContext();
        TestInitializer.initializeAll(context);
    }

    @Override
    protected void runMain() {
        // 테스트용 데이터 준비
        RacingCars racingCars = context.getRacingCars();
        List<AllRoundDTO> allRoundDTOs = List.of(AllRoundDTO.of(racingCars.cars()));
        WinnerDTO winnerDTO = WinnerDTO.of(context.getRacingWinners().getWinnerNames());

        // 실제 출력 실행
        OutputView.printAllRoundResults(allRoundDTOs);
        OutputView.printWinner(winnerDTO);
    }

    @Test
    public void printAllRoundResults_테스트() {
        run();

        String expected = "hyunjin : \npobi : \nlefthand : ";
        String actual = String.join("\n", output().split("\n")[1], output().split("\n")[2], output().split("\n")[3]);
        // 두 번째, 세 번째, 네 번째 줄을 추출하여 합침
        assertEquals(expected, actual);
    }


    @Test
    public void printWinner_테스트() {
        run();

        String expected = "최종 우승자 : hyunjin,pobi,lefthand";
        String actual = output().split("\n")[5]; // 두 번째 줄만 추출하여 비교
        assertEquals(expected, actual);
    }
}
