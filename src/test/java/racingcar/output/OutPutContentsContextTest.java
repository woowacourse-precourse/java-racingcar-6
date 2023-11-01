package racingcar.output;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.race.OutPutCommand;
import racingcar.output.contents.OutPutContents;
import racingcar.output.contents.OutPutContentsContext;
import racingcar.race.totalRound.EachRoundRecords;
import racingcar.race.totalRound.FinalWinners;
import racingcar.race.totalRound.TotalRoundRecord;

class OutPutContentsContextTest {

  @DisplayName("우승자가 한 명일 때")
  @Test
  void createOutPutContents() {
    // given
    TotalRoundRecord totalRoundRecord = TotalRoundRecord.of(List.of("a","b","c"), EachRoundRecords.of(List.of(List.of(1,1,1),List.of(1,1,2), List.of(1,1,2))), FinalWinners.of(List.of("c")));
    OutPutCommand outPutCommand = OutPutCommand.of(totalRoundRecord);

    // when
    OutPutContents outPutContents = OutPutContentsContext.createOutPutContents(outPutCommand);

    // then
    assertThat(outPutContents.getRoundContents().getContents().get(0)).isEqualTo("a : -\nb : -\nc : -");
    assertThat(outPutContents.getRoundContents().getContents().get(1)).isEqualTo("a : -\nb : -\nc : --");
    assertThat(outPutContents.getRoundContents().getContents().get(2)).isEqualTo("a : -\nb : -\nc : --");
    assertThat(outPutContents.getFinalWinnerContents().getFinalWinnerContents()).isEqualTo("최종 우승자: c");
  }

  @DisplayName("우승자가 한 명 이상일 때")
  @Test
  void createOutPutContents_if_winner_more_than_one() {
    // given
    TotalRoundRecord totalRoundRecord = TotalRoundRecord.of(List.of("a","b","c"), EachRoundRecords.of(List.of(List.of(1,1,1),List.of(1,1,2), List.of(1,2,2))), FinalWinners.of(List.of("b","c")));
    OutPutCommand outPutCommand = OutPutCommand.of(totalRoundRecord);

    // when
    OutPutContents outPutContents = OutPutContentsContext.createOutPutContents(outPutCommand);

    // then
    assertThat(outPutContents.getRoundContents().getContents().get(0)).isEqualTo("a : -\nb : -\nc : -");
    assertThat(outPutContents.getRoundContents().getContents().get(1)).isEqualTo("a : -\nb : -\nc : --");
    assertThat(outPutContents.getRoundContents().getContents().get(2)).isEqualTo("a : -\nb : --\nc : --");
    assertThat(outPutContents.getFinalWinnerContents().getFinalWinnerContents()).isEqualTo("최종 우승자: b, c");
  }
}