package racingcar.domainTest;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.domain.Judgement;

public class JudgementTest extends NsTest{
    @Test
    void 우승자를_가리는_기능() {
        Judgement judgement = new Judgement();
        ArrayList<String> cars = new ArrayList<>(Arrays.asList("pobi","minju","java"));
        ArrayList<Integer> progressSoloWin = new ArrayList<>(Arrays.asList(1,2,1));
        ArrayList<Integer> progressDuoWin = new ArrayList<>(Arrays.asList(1,2,2));

        String result = judgement.whoisWinner(cars, progressSoloWin);
        assertThat(result).contains("minju");

        result = judgement.whoisWinner(cars, progressDuoWin);
        assertThat(result).contains("minju", "java");

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

