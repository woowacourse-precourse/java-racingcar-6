package game;

import static org.assertj.core.api.Assertions.*;

import car.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class GameTest {

    private ByteArrayOutputStream outputStreamCaptor;

    @BeforeEach
    void setUp() {
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    protected String getOutput() {
        return outputStreamCaptor.toString();
    }

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

    @Test
    public void testResult(){
        Game game = new Game();
        int randNumber = game.randomNumber(5);

        List<String> people = game.addPerson("user1,user2");

        List<Car> carList = game.addCar(people);

        game.move(carList, randNumber);

        game.result(carList);

        assertThat(getOutput()).isEqualTo("user1 : -\nuser2 : -\n");

    }

    @Test
    public void testIsNumberSuccess(){
        Game game = new Game();
        String strNumber = "3";
        boolean isNumber = game.isNumber(strNumber);

        assertThat(isNumber).isTrue();
    }

    @Test
    public void testIsNumberFail(){
        Game game = new Game();
        String strNumber = "notNumber";
        boolean isNumber = game.isNumber(strNumber);

        assertThat(isNumber).isFalse();
    }

    @Test
    public void testCountSuccess(){
        Game game = new Game();
        systemIn("3");
        int count = game.count();

        assertThat(count).isEqualTo(3);
    }

    @Test
    public void testCountFail(){
        Game game = new Game();
        systemIn("notNumber");

        assertThatThrownBy(() -> game.count())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testGameResult(){
        Game game = new Game();

        int randNumber = game.randomNumber(5);

        List<String> people = game.addPerson("user1,user2");

        List<Car> carList = game.addCar(people);

        systemIn("3");
        int count = game.count();

        game.gameResult(carList, randNumber, count);

        assertThat(getOutput())
                .isEqualTo("시도할 횟수는 몇회인가요?\n" +
                        "실행 결과\n" +
                        "user1 : -\n" +
                        "user2 : -\n" +
                        "\n" +
                        "user1 : --\n" +
                        "user2 : --\n" +
                        "\n" +
                        "user1 : ---\n" +
                        "user2 : ---\n" +
                        "\n");
    }
}
