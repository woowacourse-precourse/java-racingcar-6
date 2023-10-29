package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.*;
import org.mockito.MockedStatic;
import racingcar.dto.RoundResponse;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;
import static racingcar.fixture.NameFixture.VALID_KOREAN;

@DisplayName("[Name Test] - Domain Layer")
class CarTest {
    private static final Integer START_SCORE = 0;
    private static final Integer FORWARD_SCORE = 1;

    private static final Integer NUMBER_LOWER_BOUND_CONSTRAINT = 0;
    private static final Integer NUMBER_UPPER_BOUND_CONSTRAINT = 9;
    private static final Integer FORWARD_MOVEMENT_LOWER_BOUND_CONDITION = 4;

    private static MockedStatic<Randoms> randoms;

    @BeforeAll
    static void beforeSetUp() {
        randoms = mockStatic(Randoms.class);
    }

    @AfterAll
    static void afterAll() {
        randoms.close();
    }


    @Nested
    @DisplayName("[create Test - Constructor Static Factory Method]")
    class createTest {

        @Test
        @DisplayName("[Success] 차량 이름이 조건에 부합해 차량 생성에 성공합니다.")
        void Given_ValidName_When_Create_Then_Success() {
            //given
            String validName = VALID_KOREAN.getName();

            //when
            Car car = Car.create(validName);

            //then
            assertThat(car.getName()).isEqualTo(validName);
        }
    }

    @Nested
    @DisplayName("[move Test - Move Condition을 바탕으로 차량을 움직입니다.]")
    class moveTest {

        @Test
        @DisplayName("[Success] 전진 가능한 조건이라면, 차량을 1칸 전진합니다.")
        void Given_ForwardCondition_When_Create_Then_SuccessMove() {
            //given
            when(Randoms.pickNumberInRange(NUMBER_LOWER_BOUND_CONSTRAINT, NUMBER_UPPER_BOUND_CONSTRAINT))
                    .thenReturn(FORWARD_MOVEMENT_LOWER_BOUND_CONDITION);

            Car car = Car.create(VALID_KOREAN.getName());

            //when
            car.move();

            //then
            assertThat(car.getScore()).isEqualTo(FORWARD_SCORE);
        }

        @Test
        @DisplayName("[Success] 전진 가능한 조건이 아니라면, 차량을 움직이지 않습니다.")
        void Given_StopCondition_When_Move_Then_DoNothing() {
            //given
            when(Randoms.pickNumberInRange(NUMBER_LOWER_BOUND_CONSTRAINT, NUMBER_UPPER_BOUND_CONSTRAINT))
                    .thenReturn(FORWARD_MOVEMENT_LOWER_BOUND_CONDITION - 1);

            Car car = Car.create(VALID_KOREAN.getName());

            //when
            car.move();

            //then
            assertThat(car.getScore()).isEqualTo(START_SCORE);
        }
    }


    @Nested
    @DisplayName("[isSameScore - 같은 점수인지 비교하여 결과를 boolean으로 리턴합니다.]")
    class isSameScoreTest {

        @Test
        @DisplayName("[Success] Score가 같다면 true를 리턴합니다.")
        void Given_SameScore_When_isSameScore_Then_ReturnTrue() {
            //given
            Car car = Car.create(VALID_KOREAN.getName());

            //when
            Integer score = car.getScore();
            boolean isSame = car.isSameScore(score);

            //then
            assertThat(isSame).isTrue();
        }

        @Test
        @DisplayName("[Success] Score가 다르다면 false를 리턴합니다.")
        void Given_DifferentScore_When_isSameScore_Then_ReturnFalse() {
            //given
            Car car = Car.create(VALID_KOREAN.getName());

            //when
            Integer score = car.getScore();
            boolean isSame = car.isSameScore(++score);

            //then
            assertThat(isSame).isFalse();
        }
    }

    @Nested
    @DisplayName("[generateRoundResponse - 라운드 결과를 RoundResponse DTO 형태로 리턴합니다.]")
    class generateRoundResponseTest {

        @Test
        @DisplayName("[Success] RoundResponse를 정상적으로 리턴합니다.")
        void Given_SameScore_When_isSameScore_Then_ReturnTrue() {
            //given
            Car car = Car.create(VALID_KOREAN.getName());

            //when
            RoundResponse roundResponse = car.generateRoundResponse();
            assertAll(
                    () -> assertThat(roundResponse.name()).isEqualTo(car.getName()),
                    () -> assertThat(roundResponse.score()).isEqualTo(car.getScore())
            );
        }
    }
}
