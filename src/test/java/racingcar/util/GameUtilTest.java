package racingcar.util;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameUtilTest {

    @Test
    public void 숫자생성_범위_검사() {
        assertThat(GameUtil.generateRandomNumber()).isLessThan(10).isGreaterThan(-1);
    }

    @Test
    public void 잘못된_사용자이름_검사() {
        assertThatThrownBy(() -> GameUtil.isIllegalPlayerInfo(new String[]{"Heejong", "jqrefrs"}))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> GameUtil.isIllegalPlayerInfo(new String[]{"Heejo", "mjun "}))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> GameUtil.isIllegalPlayerInfo(new String[]{" Heej"}))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> GameUtil.isIllegalPlayerInfo(new String[]{""}))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 입력_라운드_수_검사() {
        assertThatThrownBy(() -> GameUtil.isIllegalRoundInfo("he"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> GameUtil.isIllegalRoundInfo("0"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> GameUtil.isIllegalRoundInfo("-5"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
