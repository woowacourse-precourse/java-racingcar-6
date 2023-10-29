package input;

import org.junit.jupiter.api.Test;
import racingcar.model.CarList;

import static org.assertj.core.api.Assertions.*;

public class InputTest {

    @Test
    void 올바른_자동차_이름들_TEST(){

        assertThatCode(()-> new CarList("pobi"))
                .doesNotThrowAnyException();

        assertThatCode(()-> new CarList("pobi,woni,jun"))
                .doesNotThrowAnyException();

        CarList carList = new CarList("pobi,woni,jun");

        assertThat(carList.getCars()).hasSize(3);

        assertThat(carList.getCars().get(0).getName()).isEqualTo("pobi");
        assertThat(carList.getCars().get(1).getName()).isEqualTo("woni");
        assertThat(carList.getCars().get(2).getName()).isEqualTo("jun");

    }

    @Test
   void 잘못된_자동차_이름들_test(){
        assertThatThrownBy(() -> new CarList(",pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백이 존재합니다.");

        assertThatThrownBy(() ->new CarList("pobi, "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백이 존재합니다");

        assertThatThrownBy(()->new CarList("pobi,pobiee"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름의 길이는 1 ~ 5 범위여야 합니다.");
    }

}
