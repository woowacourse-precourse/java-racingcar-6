package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class MyTest {

    @Test
    void FindMaxValue_Test() {
        Comp comp = new Comp();

        List<Car> cars = new ArrayList<>();

        cars.add(new Car("1"));
        cars.add(new Car("2"));
        cars.add(new Car("3"));
        cars.add(new Car("4"));
        cars.add(new Car("5"));

        cars.get(0).cnt = 0;
        cars.get(1).cnt = 1;
        cars.get(2).cnt = 2;
        cars.get(3).cnt = 3;
        cars.get(4).cnt = 4;

        int result = comp.FindMaxValue(cars);

        assertThat(result).isEqualTo(4);

    }

    @Test
    void InputCheckSame_Test() {

        Input in = new Input();


        String[] input = {"123", "123"};

        assertThatThrownBy(() -> in.CheckSame(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름이 중복되면 안됩니다.");

    }

    @Test
    void CheckCarNumException_Test(){

        Input in = new Input();

        String[] input = {"123"};

        assertThatThrownBy(() -> in.CheckCarNum(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차는 2대 이상이어야 합니다.");

    }

    @Test
    void CheckLengthException_Test_1(){

        Input in = new Input();

        String[] input = {"123567", "123"};

        assertThatThrownBy(() -> in.CheckLength(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5글자를 넘기면 안됩니다.");

    }

    @Test
    void CheckLengthException_Test_2(){

        Input in = new Input();

        String[] input = {"", "123"};


        assertThatThrownBy(() -> in.CheckLength(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1글자 이상이어야 합니다.");

    }

    @Test
    void CheckGameNumException_Test(){

        Input in = new Input();

        int num = 0;

        assertThatThrownBy(() -> in.CheckGameNumException(num))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1이상의 횟수가 입력되야 합니다.");

    }
}
