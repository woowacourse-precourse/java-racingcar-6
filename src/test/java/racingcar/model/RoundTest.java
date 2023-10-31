package racingcar.model;

import org.junit.jupiter.api.*;
import racingcar.DTO.CarDTO;
import racingcar.system.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RoundTest {
    private final static int MOVEMENT_CONDITION = 4;
    private final static int INITIAL_POSITION = 0;
    private final static int ONE_MOVEMENT = 1;
    private final static int TEST_CAR_COUNT = 3;
    private final static int INITIAL_RACE_COUNT = 0;
    private final static int RACE_END_COUNT = 5;
    private final static int SOLE_WINNER_COUNT = 1;
    private final static int SHARED_WINNER_COUNT = 2;

    // RandomNumberGenerator의 대체 인터페이스 구현
    RandomNumberGenerator mockedGenerator = new RandomNumberGenerator() {
        @Override
        public int generate() {
            return MOVEMENT_CONDITION; // 항상 5를 반환
        }
    };

    @BeforeEach
    public void cleanupRound() {
        Round.resetCurrentRoundCount();
    }

    @Test
    @DisplayName("라운드가 시작되면 자동차는 전진 조건에서 전진한다.")
    public void 라운드_시작_전진_조건() {
        // given
        // 테스트 자동차 생성
        List<Car> cars = new ArrayList<>();
        Car car = new Car("Test");
        car.setRandomNumberGenerator(mockedGenerator);
        cars.add(car);

        // 라운드 시작
        Round round = new Round();

        // when
        int beforeCarPosition = car.getPosition();
        round.startRound(cars);
        int afterCarPosition = car.getPosition();

        // then
        Assertions.assertAll(
                () -> assertThat(beforeCarPosition).isEqualTo(INITIAL_POSITION),
                () -> assertThat(afterCarPosition).isEqualTo(ONE_MOVEMENT),
                () -> assertThat(afterCarPosition).isGreaterThan(beforeCarPosition)
        );
    }

    @Test
    @DisplayName("라운드 종료 후 전진 조건의 자동차의 이름과 위치 확인")
    public void 라운드_종료_후_결과_반환() {
        // given
        // 테스트 자동차 생성
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < TEST_CAR_COUNT; i++) {
            Car car = new Car("Test" + i);
            car.setRandomNumberGenerator(mockedGenerator);
            cars.add(car);
        }

        // when
        Round round = new Round();
        round.startRound(cars);
        List<CarDTO> roundResult = round.generateResult(cars);

        // then
        Assertions.assertAll(
                () -> assertThat(roundResult).size().isEqualTo(TEST_CAR_COUNT),
                () -> assertThat(roundResult)
                        .extracting("name", "position")
                        .contains(
                                tuple("Test0", 1),
                                tuple("Test1", 1),
                                tuple("Test2", 1)
                        )
        );
    }

    @Test
    @DisplayName("라운드가 종료된 횟수만큼 현재 라운드 수 증가 확인")
    public void 라운드가_종료되면_라운드_수_증가() {
        // given
        int firstRoundCount = Round.getCurrentRoundCount();

        for (int i = INITIAL_RACE_COUNT; i < RACE_END_COUNT; i++) {
            Round round = new Round();
            round.endRound();
        }

        // when
        int lastRoundCount = Round.getCurrentRoundCount();

        // then
        Assertions.assertAll(
                () -> assertThat(firstRoundCount).isEqualTo(INITIAL_RACE_COUNT),
                () -> assertThat(lastRoundCount).isEqualTo(RACE_END_COUNT)
        );
    }

    @Test
    @DisplayName("단독 우승자의 자동차 이름과 위치 정보 확인")
    public void 단독_우승자의_자동차_정보_확인() {
        // given
        // 각 라운드의 결과를 저장할 리스트
        List<List<CarDTO>> EachRoundResult = new ArrayList<>();

        // 각 라운드의 결과 저장
        for (int i = INITIAL_RACE_COUNT; i < RACE_END_COUNT; i++) {
            List<CarDTO> roundResult = Arrays.asList(
                    new CarDTO("kim", 0),
                    new CarDTO("lee", 0),
                    new CarDTO("son", 1 + i)
            );
            EachRoundResult.add(roundResult);
        }

        // when
        List<CarDTO> winner = Round.calculateFurthestCarInfo(EachRoundResult);

        // then
        Assertions.assertAll(
                () -> assertThat(winner).size().isEqualTo(SOLE_WINNER_COUNT),
                () -> assertThat(winner)
                        .extracting("name", "position")
                        .containsExactly(
                                tuple("son", RACE_END_COUNT)
                        )
        );
    }

    @Test
    @DisplayName("공동 우승자들의 자동차 이름과 위치 정보 확인")
    public void 공동_우승자의_자동차_정보_확인() {
        // given
        // 각 라운드의 결과를 저장할 리스트
        List<List<CarDTO>> EachRoundResult = new ArrayList<>();

        // 각 라운드의 결과 저장
        for (int i = INITIAL_RACE_COUNT; i < RACE_END_COUNT; i++) {
            List<CarDTO> roundResult = Arrays.asList(
                    new CarDTO("kim", 0),
                    new CarDTO("lee", 1 + i),
                    new CarDTO("son", 1 + i)
            );
            EachRoundResult.add(roundResult);
        }

        // when
        List<CarDTO> winner = Round.calculateFurthestCarInfo(EachRoundResult);

        // then
        Assertions.assertAll(
                () -> assertThat(winner).size().isEqualTo(SHARED_WINNER_COUNT),
                () -> assertThat(winner)
                        .extracting("name", "position")
                        .containsExactly(
                                tuple("lee", RACE_END_COUNT),
                                tuple("son", RACE_END_COUNT)
                        )
        );
    }
}