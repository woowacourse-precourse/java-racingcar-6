package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MoveCountTest {

    @DisplayName("입력값이 4 이상이면 하나 증가한다.")
    @ParameterizedTest(name ="{0}를 입력시 count가 1증가한다.")
    @ValueSource(ints = {4,5,6,7,8,9})
    public void move(int controlValue) {
        // given
        MoveCount moveCount = new MoveCount(); //기본 count 값은 0이다.
        // when
        moveCount.controlMovement(controlValue);
        // then
        int result = moveCount.getMoveCount();
        assertThat(result).isOne();
    }

    @DisplayName("입력값이 4 미만이면 증가하지 않는다.")
    @ParameterizedTest(name ="{0}를 입력시 count가 증가하지 않는다.")
    @ValueSource(ints = {0,1,2,3})
    public void stop(int controlValue) {
        // given
        MoveCount moveCount = new MoveCount(); //기본 count 값은 0이다.
        // when
        moveCount.controlMovement(controlValue);
        // then
        int result = moveCount.getMoveCount();
        assertThat(result).isZero();
    }

    @Test
    @DisplayName("움직인 횟수를 얻을 수 있다.")
    public void getMoveCount() {
        // given
        MoveCount moveCount = new MoveCount();
        moveCount.controlMovement(4);
        // when
        int result = moveCount.getMoveCount();
        // then
        assertThat(result).isOne();
    }

    @TestFactory
    @DisplayName("움직인 횟수를 비교할 수 있다.")
    public Collection<DynamicTest> compareTo() {

        return List.of(
                DynamicTest.dynamicTest("움직인 거리의 차이가 출력된다. (1-0)=1", () -> {
                    //given
                    MoveCount moveCountA = new MoveCount();
                    moveCountA.controlMovement(4);
                    MoveCount moveCountB = new MoveCount();
                    //when
                    int result = moveCountA.compareTo(moveCountB);
                    //then
                    assertThat(result).isOne();
                }),
                DynamicTest.dynamicTest("움직인 거리가 같으면 0이 출력된다. (0-0)=0", () -> {
                    //given
                    MoveCount moveCountA = new MoveCount();
                    MoveCount moveCountB = new MoveCount();
                    //when
                    int result = moveCountA.compareTo(moveCountB);
                    //then
                    assertThat(result).isZero();
                }),
                DynamicTest.dynamicTest("움직인 거리의 차이가 출력된다. (0-1)=-1", () -> {
                    //given
                    MoveCount moveCountA = new MoveCount();
                    MoveCount moveCountB = new MoveCount();
                    moveCountB.controlMovement(4);
                    //when
                    int result = moveCountA.compareTo(moveCountB);
                    //then
                    assertThat(result).isEqualTo(-1);
                })
        );
    }

    @Test
    @DisplayName("움직인 거리가 같으면 True가 반환된다.")
    public void findSameCarTrue() {
        // given
        MoveCount moveCountA = new MoveCount();
        MoveCount moveCountB = new MoveCount();
        // when
        boolean isSame = moveCountA.findSameMoveCount(moveCountB);
        // then
        assertThat(isSame).isTrue();
    }

    @Test
    @DisplayName("움직인 거리가 다르면 False가 반환된다.")
    public void findSameCarFalse() {
        // given
        MoveCount moveCountA = new MoveCount();
        MoveCount moveCountB = new MoveCount();
        moveCountA.controlMovement(4);
        // when
        boolean isSame = moveCountA.findSameMoveCount(moveCountB);
        // then
        assertThat(isSame).isFalse();
    }

}