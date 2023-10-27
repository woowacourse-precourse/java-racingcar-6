import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Model.Car.Car;
import racingcar.Model.CarRepository;

public class test {

    @Test
    public void 자동차_생성(){
        Car carA = Car.of(100, "A");
        Assertions.assertThat(carA.getCarName().getName()).isEqualTo("A");
        Assertions.assertThat(carA.getCarId().getId()).isEqualTo(100);
    }

    @Test
    public void 저장소_생성확인(){
        CarRepository carRepository = new CarRepository(new ArrayList<>());
        for(int i=1; i<=5; i++){
            Car newCar = Car.of(i, "car" + i);
            carRepository.save(newCar);
        }

        List list = carRepository.getCarRepository();
        Assertions.assertThat(list).size().isEqualTo(5);
    }

    @Test
    public void 저장소내부_객체꺼내기(){
        CarRepository carRepository = new CarRepository(new ArrayList<>());
        for(int i=1; i<=5; i++){
            Car newCar = Car.of(i, "car" + i);
            carRepository.save(newCar);
        }
        Car car = carRepository.getCar(0);
        Assertions.assertThat(car.getCarId().getId()).isEqualTo(1);
        Assertions.assertThat(car.getCarName().getName()).isEqualTo("car1");
    }
}
