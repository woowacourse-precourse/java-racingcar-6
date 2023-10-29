package stringutils;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import utils.StringUtils;


public class StringUtilsTest {

    @Test
    void 플레이어_이름_입력시_공백_불허_컴마_조인_확인() {
        //given
        List<String> playersName = new ArrayList<>();
        Collections.addAll(playersName,"kim", "seong", "han");
        //when
        String result = StringUtils.joinWithoutBlank(playersName);
        // then
        assertThat(result).contains("kim", "han", "seong");
        assertThat(result).isEqualTo("kim,seong,han");
    }
    @Test
    void 우승자_출력시_공백_존재_컴마_조인_확인() {
        //given
        List<String> winners = new ArrayList<>();
        Collections.addAll(winners ,"kim", "seong");
        //when
        String result = StringUtils.joinWithBlank(winners);
        // then
        assertThat(result).contains("seong", "kim");
        assertThat(result).isEqualTo("kim, seong");
    }

}

