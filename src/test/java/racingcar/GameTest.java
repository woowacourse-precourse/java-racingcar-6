package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class GameTest {

    static class FixedMoveStrategy implements MoveStrategy {
        private List<Boolean> movables;
        private int index = 0;

        public FixedMoveStrategy(List<Boolean> movables) {
            this.movables = movables;
        }

        @Override
        public boolean determineMovable() {
            if (index >= movables.size()) {
                return false;
            }

            return movables.get(index++);
        }
    }

    @Nested
    class CreateGame {
        @Test
        void 참가_자동차_수가_1보다_작으면_예외발생() {
            List<Car> cars = List.of(new Car("자동차이름"));

            assertThatThrownBy(() -> new Game(cars, 1))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 경주_횟수가_1_이상이_아니면_예외발생() {
            List<Car> cars = List.of(new Car("자동차01"), new Car("자동차02"));

            assertThatThrownBy(() -> new Game(cars, 0))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class PlayGame {
        List<Car> cars;
        int raceCount = 5;
        GameResult gameResult;
        GameResult gameResultToCompare;

        @BeforeEach
        void setUp() {
            Car car1 = new Car("자동차1", new FixedMoveStrategy(List.of(true, true, true, true, false)));
            Car car2 = new Car("자동차2", new FixedMoveStrategy(List.of(true, true, true, true, false)));
            Car car3 = new Car("자동차3", new FixedMoveStrategy(List.of(true, true, true, false, false)));
            Car car4 = new Car("자동차4", new FixedMoveStrategy(List.of(true, true, false, false, false)));
            Car car5 = new Car("자동차5", new FixedMoveStrategy(List.of(true, false, false, false, false)));
            Car car6 = new Car("자동차6", new FixedMoveStrategy(List.of(false, false, false, false, false)));
            cars = List.of(car1, car2, car3, car4, car5, car6);

            Game game = new Game(cars, raceCount);

            gameResult = game.play();

            gameResultToCompare = new GameResult(
                    List.of(
                            new RaceSnapshot(1, List.of(
                                    new CarSnapshot("자동차1", 1),
                                    new CarSnapshot("자동차2", 1),
                                    new CarSnapshot("자동차3", 1),
                                    new CarSnapshot("자동차4", 1),
                                    new CarSnapshot("자동차5", 1),
                                    new CarSnapshot("자동차6", 0)
                            )),
                            new RaceSnapshot(2, List.of(
                                    new CarSnapshot("자동차1", 2),
                                    new CarSnapshot("자동차2", 2),
                                    new CarSnapshot("자동차3", 2),
                                    new CarSnapshot("자동차4", 2),
                                    new CarSnapshot("자동차5", 1),
                                    new CarSnapshot("자동차6", 0)
                            )),
                            new RaceSnapshot(3, List.of(
                                    new CarSnapshot("자동차1", 3),
                                    new CarSnapshot("자동차2", 3),
                                    new CarSnapshot("자동차3", 3),
                                    new CarSnapshot("자동차4", 2),
                                    new CarSnapshot("자동차5", 1),
                                    new CarSnapshot("자동차6", 0)
                            )),
                            new RaceSnapshot(4, List.of(
                                    new CarSnapshot("자동차1", 4),
                                    new CarSnapshot("자동차2", 4),
                                    new CarSnapshot("자동차3", 3),
                                    new CarSnapshot("자동차4", 2),
                                    new CarSnapshot("자동차5", 1),
                                    new CarSnapshot("자동차6", 0)
                            )),
                            new RaceSnapshot(5, List.of(
                                    new CarSnapshot("자동차1", 4),
                                    new CarSnapshot("자동차2", 4),
                                    new CarSnapshot("자동차3", 3),
                                    new CarSnapshot("자동차4", 2),
                                    new CarSnapshot("자동차5", 1),
                                    new CarSnapshot("자동차6", 0)
                            ))
                    ),
                    List.of(
                            new CarSnapshot("자동차1", 4),
                            new CarSnapshot("자동차2", 4)
                    )
            );
        }

        @Test
        void 게임_종료_후_게임결과를_반환한다() {
            assertThat(gameResult)
                    .isEqualTo(gameResultToCompare);
        }

        @Test
        void 경주마다_경주_스냅샷을_히스토리에_추가한다() {
            assertThat(gameResult.history())
                    .hasSize(5);
        }

        @Test
        void 게임_경주단계는_1부터_경주횟수까지_1씩_증가한다() {
            assertThat(gameResult.history())
                    .extracting(RaceSnapshot::race)
                    .containsExactly(1, 2, 3, 4, 5);
        }

        @Test
        void 경주_스냅샷은_현재_경주단계의_모든_자동차_스냅샷이다() {
            assertThat(gameResult.history())
                    .usingRecursiveComparison()
                    .isEqualTo(gameResultToCompare.history());
        }

        @Test
        void 게임_종료_후_우승자를_결정한다() {
            assertThat(gameResult.winners())
                    .usingRecursiveComparison()
                    .isEqualTo(gameResultToCompare.winners());
        }
    }
}
