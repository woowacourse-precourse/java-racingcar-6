package racingcar.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class JudgementTest {

    @Test
    void getNamesFromUser5글자이하의이름을입력한경우() {
        Assertions.assertThat(Judgement.getNamesFromUser("강아지,고양이,너구리")).containsExactly("강아지", "고양이", "너구리");
    }

    @Test
    void getNamesFromUser5글자를초과한이름을입력한경우() {
        Assertions.assertThatThrownBy(() -> Judgement.getNamesFromUser("티라노사우르스,오리너구리"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getPlayCountFromUser숫자를입력하지않은경우() {
        Assertions.assertThatThrownBy(() -> Judgement.getPlayCountFromUser("숫자"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getPlayCountFromUser올바른입력을한경우(){
        Assertions.assertThat(Judgement.getPlayCountFromUser("10")).isEqualTo(10);
    }

}