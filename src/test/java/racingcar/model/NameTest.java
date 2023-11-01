package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.NameDto;

class NameTest {

    @DisplayName("toDto() 테스트 : Car를 CarDto로 변환한다.")
    @Test
    void toDto() {
        Name name = new Name("홍길동");

        NameDto nameDto = name.toDto();

        assertThat(nameDto).isEqualTo(new NameDto("홍길동"));
    }

    @DisplayName("Name(name) 생성 테스트 : Name 생성 시 이름을 부여할 수 있다.")
    @Test
    void create_생성자에_이름이_주어짐() {
        Name name = new Name("홍길동");
        assertThat(name).isEqualTo(new Name("홍길동"));
    }

    @DisplayName("Name(name) 생성 예외 테스트 : 5초과라면 IllegalArgumentException가 발생한다.")
    @Test
    void 예외발생_이름크기가_5자_초과인경우() {
        assertThatThrownBy(() -> new Name("일이삼사오육"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[Error] 이름 크기는 5이하여야 합니다.");
    }
}