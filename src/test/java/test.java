import Config.AppConfig;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.Model.Car.Car;
import racingcar.Model.Car.CarId;
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
        for (int i = 1; i <= 5; i++) {
            Car newCar = Car.of(i, "car" + i);
            carRepository.save(newCar);
        }

        List list = carRepository.getCarRepository();
        Assertions.assertThat(list).size().isEqualTo(5);
    }

    @Test
    public void 저장소내부_객체꺼내기() {
        CarRepository carRepository = new CarRepository(new ArrayList<>());
        for (int i = 1; i <= 5; i++) {
            Car newCar = Car.of(i, "car" + i);
            carRepository.save(newCar);
        }
        Car car = carRepository.getCar(0);
        Assertions.assertThat(car.getCarId().getId()).isEqualTo(1);
        Assertions.assertThat(car.getCarName().getName()).isEqualTo("car1");
    }

    @Test
    public void 자동차개수_유효성검사() {
        Integer a = Integer.MAX_VALUE;
        Assertions.assertThatThrownBy(() -> CarId.validateRange(a + 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 자동차이름_유효성검사() {
        Integer a = 0;
        Car car0 = Car.of(a + 1, "jhon");
        Assertions.assertThatThrownBy(() -> Car.of(a + 1, "jhon1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 자동차이름_유효성검사2() {
        String input = "jhon,jhonn,jhonnnnn";
        String[] split = input.split(AppConfig.INPUT_DELIMITER);
        Assertions.assertThatThrownBy(() -> {
            for (int i = 0; i < split.length; i++) {
                Car.of(i, split[i]);
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 예외테스트(){
        String s = "33333333333";
        Assertions.assertThatThrownBy(() -> Integer.parseInt(s))
                .isInstanceOf(NumberFormatException.class);
    }
}
