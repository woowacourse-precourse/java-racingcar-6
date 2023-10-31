package racingcar.view;

import org.junit.jupiter.api.Test;
import racingcar.domain.Name;
import racingcar.domain.Position;
import racingcar.domain.dto.CarResult;
import racingcar.domain.dto.RaceResult;
import racingcar.domain.dto.RoundResult;

import java.util.List;


class OutputViewTest {
    @Test
    void 자동차_이름_입력_요청_메시지를_출력한다(){
        OutputView outputView = new OutputView();
        outputView.printRequestCarNames();
    }

    @Test
    void 라운드_횟수_입력_요청_메시지를_출력한다(){
        OutputView outputView = new OutputView();
        outputView.printRequestTotalRound();
    }

    @Test
    void 레이싱_게임_결과를_출력한다(){
        RaceResult raceResult = RaceResult.of(List.of(
                RoundResult.of(List.of(
                        CarResult.of(new Name("pobi"), new Position(1)),
                        CarResult.of(new Name("crong"), new Position(1))
                )),
                RoundResult.of(List.of(
                        CarResult.of(new Name("pobi"), new Position(2)),
                        CarResult.of(new Name("crong"), new Position(2))
                ))
        ));
        OutputView outputView = new OutputView();
        outputView.printRaceResult(raceResult);
    }
}