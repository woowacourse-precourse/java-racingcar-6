package racingcar.domain.game;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.judgement.Judgement;
import racingcar.domain.judgement.RacingJudgement;
import racingcar.domain.player.RacingGameParticipant;
import racingcar.domain.player.RacingPlayer;
import racingcar.fake.FakeGameConsoleUtil;
import racingcar.fake.FakeRandomNumberUtil;

class RacingGameTest {
        private Game game;
        private OutputStream out;

        @BeforeEach
        void init() {
                Judgement judgement = new RacingJudgement();
                RacingPlayer player = new RacingGameParticipant(new FakeGameConsoleUtil("1"));
                game = new RacingGame(judgement, player);
                out = new ByteArrayOutputStream();
                System.setOut(new PrintStream(out));
        }

        @Test
        @DisplayName("성공: 게임을 시작")
        void call_start() {
                //given
                Judgement judgement = new RacingJudgement();
                RacingPlayer player = new RacingGameParticipant(new FakeGameConsoleUtil("1"));
                Game game = new RacingGame(judgement, player);
                OutputStream out = new ByteArrayOutputStream();
                System.setOut(new PrintStream(out));

                //when
                game.start();

                //then
                assertThat(out.toString()).contains("실행 결과\n1 : ");
        }

        @Test
        @DisplayName("성공: 게임을 종료")
        void call_finish() {
                //given

                //when
                game.finish();

                //then
                assertThat(out.toString()).contains("최종 우승자 : ");
        }


}
