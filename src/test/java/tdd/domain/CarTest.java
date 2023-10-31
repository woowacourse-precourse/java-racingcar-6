package tdd.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.Test;
import tdd.observer.Observer;

public class CarTest implements Observer {
    @Override
    public void display(Car car) {
        String movedLength = "-";
        System.out.println(car.getName() + " : " + movedLength.repeat(car.getMoved()));
    }

    @Test
    void 랜덤_숫자가_4_이상이면_자동차_전진해서_통과() {
        Car car = new Car("Car1");
        int carMoved = 1;

        car.moveCar(7);
        assertThat(car.getMoved()).isEqualTo(carMoved);
    }

    @Test
    void 랜덤_숫자가_4_이상이_아니면_자동차_정지해서_통과() {
        Car car = new Car("Car1");
        int carMoved = 0;

        car.moveCar(3);
        assertThat(car.getMoved()).isEqualTo(carMoved);
    }

    @Test
    void 옵저버_등록_성공_및_해제시_통과() {
        Car car = new Car("Car1");
        car.addObserver(this);
        List<Observer> subscribers = car.getSubscribers();

        assertThat(subscribers.get(0)).isEqualTo(this);

        car.removeObserver(this);
        assertThat(subscribers.isEmpty()).isTrue();
    }

    @Test
    void 옵저버에게_변경_통지_성공시_통과() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        Car car = new Car("Car1");
        String message = "Car1 : -\n";

        System.setOut(new PrintStream(output));
        car.addObserver(this);
        car.moveCar(4);

        assertThat(output.toString()).isEqualTo(message);

        System.setOut(System.out);
        output.reset();
    }
}
