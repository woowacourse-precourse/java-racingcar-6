package racingcar.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class JudgementTest {

    @Test
    void getNamesFromUser5글자이하의이름을입력한경우정상실행() {
        Assertions.assertThat(Judgement.getNamesFromUser("강아지,고양이,너구리")).containsExactly("강아지","고양이","너구리");
    }

    @Test
    void getNamesFromUser5글자를초과한이름을입력한경우에러발생() {
        Assertions.assertThatThrownBy(() -> Judgement.getNamesFromUser("티라노사우르스,오리너구리"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}