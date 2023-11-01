package racingcar.output;

import static java.lang.System.*;

import racingcar.race.OutPutCommand;
import racingcar.output.contents.OutPutContents;
import racingcar.output.contents.OutPutContentsContext;

public class OutPutContext {
  private OutPutContext() {
  }
  public static void printOutPutContents(OutPutCommand outPutCommand) {
    OutPutContents outPutContents = OutPutContentsContext.createOutPutContents(outPutCommand);
    for (String roundContent : outPutContents.getRoundContents().getContents()) {
      out.println(roundContent);
      out.println();
    }
    out.println(outPutContents.getFinalWinnerContents().getFinalWinnerContents());
  }
}
