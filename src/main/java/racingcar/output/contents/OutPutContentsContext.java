package racingcar.output.contents;

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
    List<String> list = new ArrayList<>();
    RoundContents roundContents = createRoundContents(eachRoundRecord, carNames, list);
    FinalWinnerContents finalWinnerContents = creteWinnerContents(winners, VictoryMessages.VICTORY_MESSAGES.message());

    return OutPutContents.of(roundContents, finalWinnerContents);
  }

  private static RoundContents createRoundContents(List<List<Integer>> eachRoundRecord,
      List<String> carNames,
      List<String> roundContent) {
    for (List<Integer> list : eachRoundRecord) {
      StringJoiner stringJoiner = new StringJoiner(PunctuationMarks.NEW_LINE.mark());
      IntStream.range(0, list.size())
          .forEach(i -> stringJoiner.add(roundResult(list, carNames, i)));
      roundContent.add(stringJoiner.toString());
    }
    return RoundContents.of(roundContent);
  }

  private static String roundResult(List<Integer> list, List<String> carNames, int i) {
    String repeatedMinus = PunctuationMarks.MINUS.mark().repeat(list.get(i));
    return String.join(PunctuationMarks.EMPTY_COLON_EMPTY.mark(), carNames.get(i), repeatedMinus);
  }

  private static FinalWinnerContents creteWinnerContents(FinalWinners winners, String winnerGuide) {
    if (winners.isMultipleWinners()) {
      StringJoiner stringJoiner = new StringJoiner(", ");
      winners.getWinners().forEach(stringJoiner::add);
      return FinalWinnerContents.of(winnerGuide + stringJoiner);
    }
    return FinalWinnerContents.of(winnerGuide + String.join("", winners.getWinners()));
  }
}
