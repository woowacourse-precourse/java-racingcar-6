package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.constant.GameStringConstant;
import racingcar.utils.dto.Names;

class RacingCarManagerTest {

    private List<String> nameList = List.of("pobi", "woni", "jun");
    private int playerSize;
    private Names names = new Names(nameList);
    private RacingCarManager racingCarManager;

    @BeforeEach
    void setUp() {
        racingCarManager = RacingCarManager.ofNames(names);
        playerSize = nameList.size();
    }

    @Test
    void Names_로_레이싱카관리자를_생성한다() {
        RacingCarManager comp = RacingCarManager.ofNames(names);

        assertThat(comp).usingRecursiveComparison()
                .isEqualTo(racingCarManager);
    }

    @Test
    void 게임결과를_출력할때_이름과_점수구분자_점수_형태로_출력한다() {
        int playRound = 10;
        for (int i = 0; i < playRound; i++) {
            racingCarManager.playOneRound();
        }

        String roundResult = racingCarManager.getScoreBoard();
        String[] dividedByNewLine = roundResult.split("\n");

        for (int i = 0; i < playerSize; i++) {
            String[] dividedByBlank = dividedByNewLine[i].split(" ");

            for (int j = 0; j < 3; j++) {
                assertThat(dividedByBlank[0]).isEqualTo(names.names().get(i));
                assertThat(dividedByBlank[1]).isEqualTo(GameStringConstant.SCORE_DIVDER.getValue());
                assertThat(dividedByBlank[2]).contains(GameStringConstant.SCORE_BAR.getValue());
            }
        }
    }

    @Test
    void 최종우승자들의_이름은_점수가_가장높은_차들의_이름들이다() {
        int playRound = 10;
        for (int i = 0; i < playRound; i++) {
            racingCarManager.playOneRound();
        }
        List<String> winnerNameList = new ArrayList<>();

        String finalResult = racingCarManager.getScoreBoard();
        String[] dividedByNewLine = finalResult.split("\n");
        int highestScore = -1;
        for (int i = 0; i < dividedByNewLine.length; i++) {
            String[] dividedByBlank = dividedByNewLine[i].split(" ");
            highestScore = Integer.max(highestScore, dividedByBlank[2].length());
        }

        for (int i = 0; i < dividedByNewLine.length; i++) {
            String[] dividedByBlank = dividedByNewLine[i].split(" ");
            int curScore = dividedByBlank[2].length();

            if (curScore == highestScore) {
                winnerNameList.add(dividedByBlank[0]);
            }
        }

        Names winnerNames = racingCarManager.getWinnerNames();

        assertThat(winnerNames.names()).usingRecursiveComparison()
                .isEqualTo(winnerNameList);
    }
}