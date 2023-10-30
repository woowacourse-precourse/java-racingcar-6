package game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Randoms;
import car.Car;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class GameTest {

    @Test
    public void testAddPerson(){
        Game game = new Game();

        List<String> result = game.addPerson("user1,user2");

        assertThat(result).containsExactly("user1", "user2");
    }

    @Test
    public void testAddPersonException(){
        Game game = new Game();

        assertThatThrownBy(() -> game.addPerson("user1,userLongName"))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    public void testAddCar(){
        Game game = new Game();

        List<String> people = game.addPerson("user1,user2");

        List<Car> carList = game.addCar(people);

        assertThat(carList).hasSize(2);

        assertThat(carList.get(0).getName()).isEqualTo("user1");
        assertThat(carList.get(1).getName()).isEqualTo("user2");
    }

    @Test
    public void testRandomNumber(){
        Game game = new Game();

        Randoms mockRandoms = Mockito.mock(Randoms.class);
        Mockito.when(mockRandoms.pickNumberInRange(0, 9)).thenReturn(5);

        // Inject the mockRandoms into yourClass
        game.setRandoms(mockRandoms);

        // When
        int result = game.randomNumber();

        // Then
        assertThat(result).isBetween(0, 9); // 0 이상 9 이하인지 확인
        assertThat(result).isEqualTo(5); // 예시로 고정된 값이 5인지 확인


//        int result = game.randomNumber();
//
//        assertThat(result).isBetween(0, 9);
    }
}
