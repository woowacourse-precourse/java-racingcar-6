package game;

import car.Car;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class GameTest {

    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    protected final void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    protected final void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    protected final String output() {
        return captor.toString().trim();
    }

    @Test
    @DisplayName("사람 이름 나누기 테스트")
    public void testPersonSplit(){
        Game game = new Game();
        String[] checkPerson = {"park", "kim", "lee"};
        String persons = "park,kim,lee";
        String[] personArray = game.personSplit(persons);
        for(int i = 0; i < checkPerson.length; i++){
            assertThat(personArray[i]).isEqualTo(checkPerson[i]);
        }
    }
    @Test
    @DisplayName("사람 추가 테스트")
    public void testAddPersonSuccess(){
        Game game = new Game();
        String[] checkPerson = {"park", "kim", "lee"};
        List<String> people = game.addPerson(checkPerson);
        for(int i = 0; i < checkPerson.length; i++){
            assertThat(people.get(i)).isEqualTo(checkPerson[i]);
        }
    }

    @Test
    @DisplayName("사람 추가 실패 테스트")
    public void testAddPersonFail(){
        Game game = new Game();
        String[] persons = {",abcdef", null, "", ","};
        assertThatThrownBy(() -> game.addPerson(persons))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("랜덤 숫자 뽑기 테스트")
    public void testRandomNumber(){
        Game game = new Game();
        int randomNumber = game.randomNumber();
        assertThat(randomNumber).isBetween(0, 9);
    }

    @Test
    @DisplayName("랜덤 숫자 넣기 테스트")
    public void testRandomNumberInput(){
        Game game = new Game();
        int randomNumber = game.randomNumber(3);
        assertThat(randomNumber).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차 움직임 테스트")
    public void testMove(){
        Game game = new Game();
        String[] persons = {"park", "kim", "lee"};
        List<Car> carList = new ArrayList<>();
        for(int i = 0; i < persons.length; i++){
            carList.add(new Car(persons[i]));
        }

        game.move(carList, 5);

        for(int i = 0; i < carList.size(); i++){
            assertThat(carList.get(i).getCount()).isEqualTo(1);
        }
    }

    @Test
    @DisplayName("숫자 확인 테스트")
    public void testIsNumber(){
        Game game = new Game();
        String[] numbers = {"1", "a"};
        boolean isNumber = game.isNumber(numbers[0]);
        boolean isNumber2 = game.isNumber(numbers[1]);
        assertThat(isNumber).isTrue();
        assertThat(isNumber2).isFalse();
    }

    @Test
    @DisplayName("실행 횟수 테스트")
    public void testCountSuccess(){
        Game game = new Game();
        String strNumber = "3";
        // 임의로 숫자 지정 - 기본은 Console.readLine()
        int count = game.count(strNumber);
        assertThat(count).isEqualTo(3);
    }

    @Test
    @DisplayName("실행 횟수 실패 테스트")
    public void testCountFail(){
        Game game = new Game();
        String[] strNumbers = {"a", "0"};
        for(int i = 0; i < strNumbers.length; i++){
            String strNumber = strNumbers[i];
            assertThatThrownBy(() -> game.count(strNumber))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    @DisplayName("실행 결과 테스트")
    public void testGameResult(){
        Game game = new Game();
        String[] persons = {"park", "kim", "lee"};
        List<Car> carList = new ArrayList<>();
        for(int i = 0; i < persons.length; i++){
            carList.add(new Car(persons[i]));
        }
        game.gameResult(carList, 1, 4);
        assertThat(output()).contains("park : -", "kim : -", "lee : -");
    }

    @Test
    @DisplayName("가장 큰 숫자 가리기 테스트")
    public void testMaxCount(){
        Game game = new Game();
        Car car1 = new Car("park");
        for(int i = 0; i < 3; i++){
            car1.move(5);
        }
        Car car2 = new Car("kim");
        for(int i = 0; i < 6; i++){
            car2.move(5);
        }
        Car car3 = new Car("lee");
        for(int i = 0; i < 1; i++){
            car3.move(5);
        }
        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        int maxCount = game.maxCount(carList);
        assertThat(maxCount).isEqualTo(6);

    }

    @Test
    @DisplayName("우승자 가리기 테스트")
    public void testWinner(){
        Game game = new Game();
        String[] persons = {"park", "kim", "lee"};
        List<Car> carList = new ArrayList<>();
        for(int i = 0; i < persons.length; i++){
            carList.add(new Car(persons[i]));
        }
        game.gameResult(carList, 1, 4);
        String[] check = {"park", "kim", "lee"};
        for(int i = 0; i < check.length; i++){
            assertThat(carList.get(i).getName()).isEqualTo(check[i]);
        }
    }

    @Test
    @DisplayName("우승자 출력 테스트")
    public void testPrintWinner(){
        Game game = new Game();
        List<String> winnerList = new ArrayList<>();
        winnerList.add("park");
        winnerList.add("lee");
        game.printWinner(winnerList);
        assertThat(output()).contains("최종 우승자 : park, lee");
    }

}
