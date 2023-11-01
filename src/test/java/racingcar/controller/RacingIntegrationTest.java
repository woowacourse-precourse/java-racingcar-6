package racingcar.controller;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.common.type.TrialCount;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingWinners;
import racingcar.util.TestContext;
import racingcar.util.TestInitializer;

public class RacingIntegrationTest extends NsTest {
    private RacingCars racingCars;
    private RacingWinners racingWinners;

    @BeforeEach
    public void setUp() {
        TestContext context = new TestContext();
        TestInitializer.initializeAll(context);

        racingCars = context.getRacingCars();
        racingWinners = context.getRacingWinners();
    }

    @Override
    protected void runMain() {
        Racing racing = initRacing();
        TrialCount trialCount = TrialCount.of("3");
        racing.start(trialCount);
    }

    private Racing initRacing() {
        Game game = Game.of(racingCars);
        Result result = Result.of(racingWinners);
        return Racing.of(game, result);
    }

    @Test
    public void racing_start_테스트() {
        runMainAndAssertOutput();
    }

    private void runMainAndAssertOutput() {
        run();
        String actualOutput = output();
        String expectedOutput = generateExpectedOutput();
        Assertions.assertEquals(expectedOutput, actualOutput);
    }

    private String generateExpectedOutput() {
        return "실행 결과" +
                "\nhyunjin : -" +
                "\npobi : -" +
                "\nlefthand : -" +
                "\n" +
                "\nhyunjin : --" +
                "\npobi : --" +
                "\nlefthand : --" +
                "\n" +
                "\nhyunjin : ---" +
                "\npobi : ---" +
                "\nlefthand : ---" +
                "\n" +
                "\n최종 우승자 : hyunjin,pobi,lefthand";
    }
}
