import Config.AppConfig;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.car.Car;
import racingcar.model.CarRepository;
import racingcar.service.CarSaveService;
import racingcar.service.RaceService;

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
    public void 자동차_생성(){
        Car carA = Car.of(100, "A");
        Assertions.assertThat(carA.getCarName().getName()).isEqualTo("A");
        Assertions.assertThat(carA.getCarId().getId()).isEqualTo(100);
    }

    @Test
    public void 저장소_생성확인(){
        List<Car> list = carRepository.getCarRepository();
        Assertions.assertThat(list).size().isEqualTo(5);
    }
    @Test
    public void 저장소내부_객체꺼내기() {
        Car car = carRepository.getCar(0);
        Assertions.assertThat(car.getCarId().getId()).isEqualTo(0);
        Assertions.assertThat(car.getCarName().getName()).isEqualTo("cara");
    }
    @Test
    public void 자동차이름_유효성검사() {
        Assertions.assertThatThrownBy(() -> Car.of(1, "jhon1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    public void 자동차이름_유효성검사2() {
        String input = "jhon,jhonn,jhonnnnn";
        String[] split = input.split(AppConfig.INPUT_NAME_DELIMITER);
        Assertions.assertThatThrownBy(() -> {
            for (int i = 0; i < split.length; i++) {
                Car.of(i, split[i]);
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 차이동_테스트1() {
        RaceService.raceRepeatByInput(1,carRepository);
        SoftAssertions.assertSoftly(softAssertions -> {
            for (int i=0; i < carRepository.size(); i++){
                Car car = carRepository.getCar(i);
                int position = car.getPosition();
                softAssertions.assertThat(position).isIn(0,4,5,6,7,8,9);
            }
        });
    }

    @Test
    public void 차이동_테스트2() {
        RaceService.raceRepeatByInput(1,carRepository);
        SoftAssertions.assertSoftly(softAssertions -> {
            for(int i=0; i< carRepository.size(); i++) {
                Car car = carRepository.getCar(i);
                softAssertions.assertThat(car.getPosition()).isNotIn(1,2,3);
            }
        });
    }
    @Test
    public void 차이동중_오버플로_발생시_예외던지기(){
        Car car = Car.of(0, "A");
        car.move(Integer.MAX_VALUE,true);
        Assertions.assertThatThrownBy(() -> car.move(3,true));
    }
}
