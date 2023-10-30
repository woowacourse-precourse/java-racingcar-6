package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RegexTest {
    @ParameterizedTest
    @ValueSource(strings = {"abc", "019", "파v워"})
    void 닉네임_성공(String name) {
        String regex = "^(?=.*[a-z0-9가-힣])[a-z0-9가-힣]{1,5}$";
        Pattern pattern = Pattern.compile(regex);
        assertThatCode(() -> pattern.matcher(name).matches()).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"특#수@", "공 백"})
    void 닉네임_실패(String name) {
        String regex = "^(?=.*[a-z0-9가-힣])[a-z0-9가-힣]{1,5}$";
        Pattern pattern = Pattern.compile(regex);
        assertThatThrownBy(() -> {
            if(!pattern.matcher(name).matches()) {
                throw new IllegalArgumentException("닉네임 아님");
            }
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("닉네임 아님");
    }

    @Test
    void regex_공부() {
        String target = "1how.com";

        String regex = "^[0-9].*com$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(target);

        assertThat(matcher.matches()).isTrue();

        target = "1e11";

        regex = "^(?=.*[a-z0-9])[a-z0-9]*$";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(target);

        assertThat(matcher.matches()).isTrue();
    }

    @Test
    void 공백체크() {
        String target = "noTabNoSpace131";

        String regex = "^[\\S]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(target);

        assertThat(matcher.matches()).isTrue();
    }


}
