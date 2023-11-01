package racingcar.view;

import java.util.List;
import racingcar.dto.ResultEachTry;
import racingcar.dto.WinnersDTO;
import racingcar.util.StringUtil;

public class WinnersView {
    private final String HEADER = "최종 우승자 : ";
    private final String content;

    public WinnersView(WinnersDTO winnersDTO) {
        this.content = StringUtil.concatNamesByCommas(winnersDTO.getWinnerNames());
    }

    public void view(){
        System.out.print(HEADER + content);
    }
}
