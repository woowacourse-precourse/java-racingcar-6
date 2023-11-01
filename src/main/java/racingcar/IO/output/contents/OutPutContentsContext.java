package racingcar.IO.output.contents;

import static racingcar.IO.PunctuationMarks.*;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.IntStream;
import racingcar.race.OutPutCommand;
import racingcar.race.totalRound.FinalWinners;
import racingcar.race.totalRound.TotalRoundRecord;

public class OutPutContentsContext {

  private OutPutContentsContext() {
    throw new IllegalArgumentException();
  }

  public static OutPutContents createOutPutContents(OutPutCommand outPutCommand) {
    TotalRoundRecord totalRoundRecord = outPutCommand.getTotalRoundRecord();
    List<List<Integer>> eachRoundRecord = totalRoundRecord.eachRoundRecord();
    FinalWinners winners = totalRoundRecord.getFinalWinners();
    List<String> carNames = totalRoundRecord.getCarNames();

    return OutPutContents.of(createRoundContents(eachRoundRecord, carNames, new ArrayList<>()),
        creteWinnerContents(winners, VictoryMessages.VICTORY_MESSAGES.message()));
  }

  private static RoundContents createRoundContents(List<List<Integer>> eachRoundRecord,
      List<String> carNames,
      List<String> roundContent) {
    for (List<Integer> list : eachRoundRecord) {
      StringJoiner stringJoiner = new StringJoiner(NEW_LINE.mark());
      IntStream.range(0, list.size())
          .forEach(i -> stringJoiner.add(roundResult(list, carNames, i)));
      roundContent.add(stringJoiner.toString());
    }
    return RoundContents.of(roundContent);
  }

  private static String roundResult(List<Integer> list, List<String> carNames, int i) {
    String repeatedMinus = MINUS.mark().repeat(list.get(i));
    return String.join(EMPTY_COLON_EMPTY.mark(), carNames.get(i), repeatedMinus);
  }

  private static FinalWinnerContents creteWinnerContents(FinalWinners winners, String winnerGuide) {
    if (winners.isMultipleWinners()) {
      StringJoiner stringJoiner = new StringJoiner(COMMA_SPACE.mark());
      winners.getWinners().forEach(stringJoiner::add);
      return FinalWinnerContents.of(winnerGuide + stringJoiner);
    }
    return FinalWinnerContents.of(winnerGuide + String.join(EMPTY.mark(), winners.getWinners()));
  }
}
