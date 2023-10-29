import Config.AppConfig;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.car.Car;
import racingcar.model.CarRepository;
import racingcar.service.CarSaveService;

public class test {
    CarRepository carRepository;
    @BeforeEach
    public void 저장소저장(){
        carRepository = new CarRepository(new ArrayList<Car>());
        String s = "cara,carb,carc,card,care";
        String[] split = s.split(AppConfig.INPUT_NAME_DELIMITER);
        CarSaveService.saveCars(split,carRepository);
    }

    @Test
    public void 저장소_생성확인(){
        Assertions.assertThat(carRepository.size()).isEqualTo(5);
    }
    @Test
    public void 자동차_생성(){
        Car carA = Car.of(100, "A");
        Assertions.assertThat(carA.getCarName().name()).isEqualTo("A");
        Assertions.assertThat(carA.getCarId().id()).isEqualTo(100);
    }
    @Test
    public void 저장소내부_객체꺼내기() {
        Car car = carRepository.getCar(0);
        Assertions.assertThat(car.getCarId().id()).isEqualTo(0);
        Assertions.assertThat(car.getCarName().name()).isEqualTo("cara");
    }
    @Test
    public void 자동차이름_유효성검사() {

        //이름엔 영문만 가능하다.
        Assertions.assertThatThrownBy(() -> Car.of(1, "jhoN1"))
                .isInstanceOf(IllegalArgumentException.class);

        //이름 각각은 1글자 이상, 5글자 이하여야한다.
        String input = "jhon,jhon,jhonnnnn";
        String[] split = input.split(AppConfig.INPUT_NAME_DELIMITER);
        Assertions.assertThatThrownBy(() -> {
            for (int i = 0; i < split.length; i++) {
                Car.of(i, split[i]);
            }
        }).isInstanceOf(IllegalArgumentException.class);

        //공백은 이름이 될 수 없다.
        String input1 = "a,b,,d";
        String[] split1 = input1.split(AppConfig.INPUT_NAME_DELIMITER);
        Assertions.assertThatThrownBy(() -> {
            for (int i = 0; i < split1.length; i++) {
                Car.of(i, split1[i]);
            }
        }).isInstanceOf(IllegalArgumentException.class);

        //이름엔 공백이 포함될 수 없다.
        String input2 = "a,b ,c";
        String[] split2 = input2.split(AppConfig.INPUT_NAME_DELIMITER);
        Assertions.assertThatThrownBy(() -> {
            for (int i = 0; i < split2.length; i++) {
                Car.of(i, split2[i]);
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
