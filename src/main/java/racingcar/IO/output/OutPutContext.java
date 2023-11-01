package racingcar.IO.output;

import static java.lang.System.*;

import racingcar.IO.output.contents.OutPutContents;
import racingcar.IO.output.contents.OutPutContentsContext;
import racingcar.race.OutPutCommand;

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
