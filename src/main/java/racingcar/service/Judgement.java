package racingcar.service;

import java.util.ArrayList;
import racingcar.domain.RacingBoard;

public interface Judgement {
    boolean isGameSet(int count);
    ArrayList<String> judgeWinner(RacingBoard racingBoard);
}
