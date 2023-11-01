package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {
    private RacingGame racingGame;
    private static ByteArrayOutputStream outputMessage;
    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream(); // OutputStream 생성
        System.setOut(new PrintStream(outputMessage)); // 생성한 OutputStream 으로 설정
        racingGame = new RacingGame(5, 4, 0, 9);
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out); // 원상복귀
    }

    @Test
    void 리스트에_차가_한_대일_때_makeCars() {
        // 전제로 사용자의 차 입력에 대해서는 사전 테스트를 거쳤으므로, 유효한 입력값만 들어온다고 가정.
        Optional<String> input = Optional.of("hi");
        List<Car> cars = racingGame.makeCars(input);

        assertThat(cars.size()).isEqualTo(1);
        assertThat(cars.get(0)).isInstanceOf(Car.class);
        assertThat(cars.get(0).getName()).isEqualTo("hi");
    }

    @Test
    void 리스트에_차가_여러_대일_때_makeCars() {
        // 전제로 사용자의 차 입력에 대해서는 사전 테스트를 거쳤으므로, 유효한 입력값만 들어온다고 가정.
        Optional<String> input = Optional.of("hi,hi1,hi2");
        List<Car> cars = racingGame.makeCars(input);

        assertThat(cars.size()).isEqualTo(3);
        assertThat(cars.get(0).getName()).isEqualTo("hi");
        assertThat(cars.get(1).getName()).isEqualTo("hi1");
        assertThat(cars.get(2).getName()).isEqualTo("hi2");
    }

    @Test
    void 우승자가_한명일_때_패자_없음_forward_0_finish(){

        Car car1 = new Car("car1");
        List<Car> cars = new ArrayList<>();
        cars.add(car1);

        racingGame.setCars(cars);
        racingGame.finish();

        assertThat("최종 우승자 : car1\n").isEqualTo(outputMessage.toString());
    }

    @Test
    void 우승자가_한_명일_때_패자_있음_forward_0_finish(){

        Car car1 = new Car("car1");
        car1.incrementForwardCount();
        Car car2 = new Car("car2");
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);

        racingGame.setCars(cars);
        racingGame.finish();

        assertThat("최종 우승자 : car1\n").isEqualTo(outputMessage.toString());
    }

    @Test
    void 우승자가_여러_명일_때_패자_없음_forward_0_finish(){

        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);

        racingGame.setCars(cars);
        racingGame.finish();

        assertThat("최종 우승자 : car1, car2\n").isEqualTo(outputMessage.toString());
    }

    @Test
    void 우승자가_여러_명일_때_패자_있음_forward_0_finish(){

        Car car1 = new Car("car1");
        car1.incrementForwardCount();
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        car3.incrementForwardCount();
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        racingGame.setCars(cars);
        racingGame.finish();

        assertThat("최종 우승자 : car1, car3\n").isEqualTo(outputMessage.toString());
    }

    @Test
    void 차_한_대_진행상황_0_printCarsStatus(){
        Car car1 = new Car("car1");
        List<Car> cars = new ArrayList<>();
        cars.add(car1);

        racingGame.setCars(cars);
        racingGame.printCarsStatus();

        assertThat("car1 : \n").isEqualTo(outputMessage.toString());
    }

    @Test
    void 차_한_대_진행상황_0_이상_printCarsStatus(){
        Car car1 = new Car("car1");
        car1.incrementForwardCount();
        List<Car> cars = new ArrayList<>();
        cars.add(car1);

        racingGame.setCars(cars);
        racingGame.printCarsStatus();

        assertThat("car1 : -\n").isEqualTo(outputMessage.toString());
    }

    @Test
    void 차_여러_대_진행상황_모두_0_printCarsStatus(){
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        racingGame.setCars(cars);
        racingGame.printCarsStatus();

        assertThat("car1 : \ncar2 : \ncar3 : \n").isEqualTo(outputMessage.toString());
    }

    @Test
    void 차_여러_대_진행상황_일부_0_printCarsStatus(){
        Car car1 = new Car("car1");
        car1.incrementForwardCount();
        car1.incrementForwardCount();
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        car3.incrementForwardCount();
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        racingGame.setCars(cars);
        racingGame.printCarsStatus();

        assertThat("car1 : --\ncar2 : \ncar3 : -\n").isEqualTo(outputMessage.toString());
    }

    @Test
    void 차_여러_대_진행상황_모두_0_이상_printCarsStatus(){
        Car car1 = new Car("car1");
        car1.incrementForwardCount();
        car1.incrementForwardCount();
        car1.incrementForwardCount();
        Car car2 = new Car("car2");
        car2.incrementForwardCount();
        Car car3 = new Car("car3");
        car3.incrementForwardCount();
        car3.incrementForwardCount();
        car3.incrementForwardCount();
        car3.incrementForwardCount();
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        racingGame.setCars(cars);
        racingGame.printCarsStatus();

        assertThat("car1 : ---\ncar2 : -\ncar3 : ----\n").isEqualTo(outputMessage.toString());
    }

}