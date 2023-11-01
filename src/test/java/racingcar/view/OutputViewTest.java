package racingcar.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Game;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;



class OutputViewTest {

    @Nested
    class OuterNested {

        private static final String CAR_NAME_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
        private static final String ATTEMPT_COUNT_REQUEST_MESSAGE = "시도할 회수는 몇회인가요?";
        private static final String NO_WINNER_MESSAGE = "우승자가 없습니다.";
        
        private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        @BeforeEach
        void setUpStreams() {
            System.setOut(new PrintStream(outputStream));
        }

        @AfterEach
        void restoreStreams() {
            System.setOut(System.out);
            outputStream.reset();
        }

        @Test
        void 차_이름_입력요청_메시지_출력_테스트() {
            OutputView.printCarNameRequest();
            Assertions.assertThat(outputStream.toString().trim())
                    .isEqualTo(CAR_NAME_REQUEST_MESSAGE);
        }

        @Test
        void 시도횟수_입력요청_메시지_출력_테스트() {
            OutputView.printAttemptCountRequest();
            Assertions.assertThat(outputStream.toString().trim())
                    .contains(ATTEMPT_COUNT_REQUEST_MESSAGE);
        }

        @Nested
        class WinnerExist {
            Game game;

            @BeforeEach
            void setUp() {
                game = new Game(Arrays.asList(
                        new Car("Tom", () -> 4),
                        new Car("Jin", () -> 4),
                        new Car("Ive", () -> 3)),
                        1);
            }

            @Test
            void 레이스_상황_출력_테스트() {
                game.carRaceOnce();
                OutputView.printRaceStatus(game.getCars());
                Assertions.assertThat(outputStream.toString())
                        .contains("실행 결과", "Tom : -", "Jin : -", "Ive : ");
            }

            @Test
            void 우승자_출력_테스트() {
                while (!game.isGameOver()) {
                    game.carRaceOnce();
                }
                OutputView.printWinnerName(game.getWinners());
                Assertions.assertThat(outputStream.toString()).contains("Tom","Jin").doesNotContain("Ive");
            }

        }
        @Nested
        class NoWinnerClass{
            Game game;

            @BeforeEach
            void setUp() {
                game = new Game(Arrays.asList(
                        new Car("Tom", () -> 3),
                        new Car("Jin", () -> 3),
                        new Car("Ive", () -> 3)),
                        1);
            }

            @Test
            void 우승자_없음_출력_테스트(){
                while (!game.isGameOver()) {
                    game.carRaceOnce();
                }
                OutputView.printWinnerName(game.getWinners());
                Assertions.assertThat(outputStream.toString().trim()).isEqualTo(NO_WINNER_MESSAGE);
            }

        }
    }
}