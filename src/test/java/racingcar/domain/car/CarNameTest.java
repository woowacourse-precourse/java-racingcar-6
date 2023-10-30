package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarNameTest {

    @Test
    public void 이름이_5글자를_초과할시_예외(){
        assertThatThrownBy(()->new CarName("포비님은최고"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 이름에_빈_문자입력시_예외(){
        assertThatThrownBy(()->new CarName(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 이름에_null입력시_예외(){
        assertThatThrownBy(()->new CarName(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
