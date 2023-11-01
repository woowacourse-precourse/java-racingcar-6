package racingcar;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {

    @Test
    void get_자동차_리스트() {
        User user = new User();
        List<Car> carList = user.getCarList("pobi,woni,jun,honi");
        List<Car> expectedList = new ArrayList<>();
        expectedList.add(new Car("pobi", 0));
        expectedList.add(new Car("woni", 0));
        expectedList.add(new Car("jun", 0));
        expectedList.add(new Car("honi", 0));

        assertThat(carList).isEqualTo(expectedList);
    }

    @Test
    void 이름_5글자_이상인_경우_에러() {
        User user = new User();
        assertThatThrownBy(() -> user.getCarList("pobiwonijun,honi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자 이하 이름만 가능");
    }

    @Test
    void 중복된_이름_존재시_에러() {
        User user = new User();
        assertThatThrownBy(() -> user.getCarList("pobi,honi,pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 이름 존재");
    }

    @Test
    void 이름에_빈_값_존재하는_경우() {
        User user = new User();
        List<Car> carList = user.getCarList("pobi,woni,,,jun,honi");
        List<Car> expectedList = new ArrayList<>();
        expectedList.add(new Car("pobi", 0));
        expectedList.add(new Car("woni", 0));
        expectedList.add(new Car("jun", 0));
        expectedList.add(new Car("honi", 0));

        assertThat(carList).isEqualTo(expectedList);
    }

    @Test
    void 이름이_공백으로만_존재() {
        User user = new User();
        List<Car> carList = user.getCarList("pobi,woni,   ,jun,honi");
        List<Car> expectedList = new ArrayList<>();
        expectedList.add(new Car("pobi", 0));
        expectedList.add(new Car("woni", 0));
        expectedList.add(new Car("jun", 0));
        expectedList.add(new Car("honi", 0));

        assertThat(carList).isEqualTo(expectedList);
    }

    @Test
    void 자동차_리스트가_빈_경우() {
        User user = new User();
        assertThatThrownBy(() -> user.getCarList(",  ,  ,,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("적절한 이름이 존재하지 않음");
    }

}