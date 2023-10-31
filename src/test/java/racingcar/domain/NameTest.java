package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Test
    void 올바르지_않은_이름을_사용(){
        //given
        String s1 = "";
        String s2 = null;
        String s3 = "나는야유정이";

        //when,then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Name(s1);
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Name(s2);
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Name(s3);
        });
    }

    @Test
    void 올바른_이름을_사용한_경우(){
        //give
        String s1 = "유정이";

        //when
        Name name = new Name(s1);

        //then
        assertThat(s1).isEqualTo(name.getName());
    }
}