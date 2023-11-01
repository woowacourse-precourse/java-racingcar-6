package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class RefereeTest{
    Referee referee;
    private List<Racer> group;

    @BeforeEach
    void setUp() {
        referee = new Referee();
        group = new ArrayList<>();
    }

    @Test
    void readPlayer_정상_입력_값에_대한_group_생성_확인() {
        String strValue = "kim,lee,park";
        referee.readPlayer(strValue);

        List<Racer> expect = new ArrayList<>();
        expect.add(new Racer("kim"));
        expect.add(new Racer("lee"));
        expect.add(new Racer("park"));

        List<Racer> result = referee.getGroup();

        assertThat(result).usingRecursiveComparison().isEqualTo(expect);
        // usingRecursiveComparison() = 관련된 객체의 필드를 모두 재귀적으로 돌면서 값만을 비교
    }

    @Test
    void readPlayer_단일_입력_값에_대한_group_생성_확인() {
        String strValue = "kim";
        referee.readPlayer(strValue);

        List<Racer> expect = new ArrayList<>();
        expect.add(new Racer("kim"));

        List<Racer> result = referee.getGroup();

        assertThat(result).usingRecursiveComparison().isEqualTo(expect);

    }

    @Test
    void splitMember_메서드_사용시_구분자가_포함되지_않은_경우_값을_그대로_반환() {
        String input = "kim";
        String[] result = referee.splitMember(input); // splitMember : "," 구분자를 기준으로 문자열 배열로 변환

        String[] expect = new String[]{"kim"};

        assertThat(result).usingRecursiveComparison().isEqualTo(expect);
    }

    @Test
    void addGroup_그룹_생성_확인() {
        referee.addGroup("kim");

        List<Racer> expect = new ArrayList<>();
        expect.add(new Racer("kim"));

        List<Racer> result = referee.getGroup();
        assertThat(result).usingRecursiveComparison().isEqualTo(expect);
    }

    @Test
    void readGameCount_정상_입력_값에_대한_변환_확인() {
        String strValue = "5";

        assertThatCode(() -> referee.readGameCount(strValue))
                .doesNotThrowAnyException();
        // readGameCount : 입력값이 숫자일경우 int로 변환하여 반환

        int result = referee.getGameCount();
        int expect = 5;

        assertThat(result).isEqualTo(expect);
    }

    @Test
    void readGameCount_입력_값이_문자일경우_예외_처리_확인() {
        String strValue = "abc";

        assertThatThrownBy(() -> {
            referee.readGameCount(strValue);
        }).isInstanceOf(IllegalArgumentException.class).
                hasMessage("잘못된 값 입력 : " + strValue);
    }
}