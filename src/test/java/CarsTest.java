import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarsTest {
    @Test
    void isCorrect_자동차_이름이_옳바른값() {

        Cars cars = new Cars("aim,bim,cim");

        assertThat(cars.getCars().size()).isEqualTo(3);
        assertThat(cars.getCars().get(0).getCarName()).isEqualTo("aim");
        assertThat(cars.getCars().get(1).getCarName()).isEqualTo("bim");
        assertThat(cars.getCars().get(2).getCarName()).isEqualTo("cim");
    }

    @Test
    void 우승자_확인(){

        Cars cars = new Cars(List.of(
                new Car("one", 7),
                new Car("two", 7),
                new Car("three", 7)
        ));

        Cars racing = cars.winners();

        assertThat(racing.getCars().get(0).getCarName()).isEqualTo("one");
        assertThat(racing.getCars().get(1).getCarName()).isEqualTo("two");
        assertThat(racing.getCars().get(2).getCarName()).isEqualTo("three");
    }

}
