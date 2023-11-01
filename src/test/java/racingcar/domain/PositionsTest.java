package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.racing.car.Positions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionsTest {

    @Test
    public void 빈_Positions_객체_생성() {
        // when
        Positions positions = Positions.create();

        // then
        assertThat(positions).isNotNull();
    }

    @Test
    public void 마지막_위치인덱스_아무런위치값이없을때_마이너스1() {
        // given
        Positions positions = Positions.create();

        // when
        int lastIndex = positions.calcLastIndex();

        // then
        assertEquals(-1, lastIndex);
    }

    @Test
    public void 마지막_위치인덱스_0부터시작() {
        // given
        Positions positions = Positions.create();
        positions.addPositionByRandomNum(1);

        // when
        int lastIndex = positions.calcLastIndex();

        // then
        assertEquals(0, lastIndex);
    }

    @Test
    public void 마지막_위치값_아무런위치값이없을때_0반환() {
        // given
        Positions positions = Positions.create();

        // when
        int lastPosition = positions.calcLastPosition();

        // then
        assertEquals(0, lastPosition);
    }

    @Test
    public void 마지막_위치값() {
        // given
        Positions positions = Positions.create();
        positions.addPositionByRandomNum(4);

        // when
        int lastPosition = positions.calcLastPosition();

        // then
        assertEquals(1, lastPosition);
    }

    @Test
    public void 최대_위치값_아무런위치값이없을때_0반환() {
        // given
        Positions positions = Positions.create();

        // when
        int maxPosition = positions.calcMaxPosition();

        // then
        assertEquals(0, maxPosition);
    }

    @Test
    public void 최대_위치값() {
        // given
        Positions positions = Positions.create();
        positions.addPositionByRandomNum(2);
        positions.addPositionByRandomNum(4);

        // when
        int maxPosition = positions.calcMaxPosition();

        // then
        assertEquals(1, maxPosition);
    }

    @Test
    public void 턴에따른_위치값조회() {
        // given
        Positions positions = Positions.create();
        positions.addPositionByRandomNum(1);
        positions.addPositionByRandomNum(4);

        // when
        int positionAt0 = positions.findPositionAt(0);
        int positionAt1 = positions.findPositionAt(1);

        // then
        assertEquals(0, positionAt0);
        assertEquals(1, positionAt1);
    }

    @Test
    public void 현재위치값이_파라미터보다_크면참() {
        // given
        Positions positions = Positions.create();
        positions.addPositionByRandomNum(4);

        // when
        boolean result = positions.isCurrPositionSameOrOver(0);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void 현재위치값이_파라미터와_같으면면참() {
        // given
        Positions positions = Positions.create();
        positions.addPositionByRandomNum(4);

        // when
        boolean result = positions.isCurrPositionSameOrOver(1);

        // then
        assertThat(result).isTrue();
    }

    @Test
    public void 현재위치값이_파라미터보다_작으면거짓() {
        // given
        Positions positions = Positions.create();
        positions.addPositionByRandomNum(4);

        // when
        boolean result = positions.isCurrPositionSameOrOver(2);

        // then
        assertThat(result).isFalse();
    }
}
