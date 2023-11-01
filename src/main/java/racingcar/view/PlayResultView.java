package racingcar.view;

import java.util.List;
import racingcar.dto.NameLocationPair;
import racingcar.dto.PlayResultDTO;
import racingcar.dto.ResultEachTry;
import racingcar.util.StringUtil;

public class PlayResultView {
    private final String HEADER = "실행 결과\n";
    private final StringBuilder content;

    public PlayResultView(PlayResultDTO playResultDTO) {
        content = new StringBuilder();
        buildContent(playResultDTO.getPlayResults());
    }

    public void view(){
        System.out.print(HEADER + content);
    }

    private void buildContent(List<ResultEachTry> playResults) {
        for (ResultEachTry result : playResults) {
            addFormEachTry(result);
        }
    }

    private void addFormEachTry(ResultEachTry result) {
        for (NameLocationPair pair : result.getNameLocationPairs()) {
            addFormEachName(pair);
        }
        changeLine();
    }

    private void addFormEachName(NameLocationPair pair) {
        content
                .append(StringUtil.concatTag(pair.getName()))
                .append(StringUtil.drawLine(pair.getLocation()));
        changeLine();
    }

    private void changeLine(){
        content.append("\n");
    }
}
