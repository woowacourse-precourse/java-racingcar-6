package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.view.ResultView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

class GameAdminTest {
    @Test
    void 게임_시작_테스트() {
        Round round = Round.from(1);
        Cars cars = Cars.from(Arrays.stream("pobi,yd".split(","))
                .collect(Collectors.toList()));
        MovableStrategy movableStrategy = FixMoveStrategy.createStrategy(NumberGenerator.generateNumber());

        // 콘솔 출력을 확인하기 위해 System.out을 임시로 ByteArrayOutputStream으로 변경
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        GameAdmin gameAdmin = GameAdmin.from(round);
        gameAdmin.startGame(cars, movableStrategy);

        // 예상되는 콘솔 출력과 실제 콘솔 출력이 일치하는지 확인
        assertEquals("\n실행 결과\n" +
                "pobi : -\n" +
                "yd : -\n\n".replaceAll("\\r\\n", "\n"), outputStreamCaptor.toString().replaceAll("\\r\\n", "\n"));
    }

    @Test
    void 우승자_발표_테스트() {
        Round round = Round.from(1);
        Cars cars = Cars.from(Arrays.stream("pobi,yd".split(","))
                .collect(Collectors.toList()));
        GameAdmin gameAdmin = GameAdmin.from(round);
        Winners winners = Winners.from(cars);

        gameAdmin.presentWinner(cars);

        assertEquals("pobi, yd", winners.getWinnerName());
    }
}