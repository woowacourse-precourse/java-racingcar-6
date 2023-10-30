package game;

import static org.assertj.core.api.Assertions.*;

import car.Car;
import org.junit.jupiter.api.Test;

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
        int result = game.randomNumber();

        assertThat(result).isBetween(0, 9);
    }


    @Test
    public void testMove(){
        Game game = new Game();
        int randNumber = game.randomNumber(5);

        List<String> people = game.addPerson("user1,user2");

        List<Car> carList = game.addCar(people);

        game.move(carList, randNumber);

        assertThat(carList.get(0).getCount()).isEqualTo(1);
        assertThat(carList.get(1).getCount()).isEqualTo(1);

    }
}
