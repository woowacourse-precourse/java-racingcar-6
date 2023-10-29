import Config.AppConfig;
import java.util.ArrayList;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.CarRepository;
import racingcar.model.car.Car;
import racingcar.service.CarSaveService;
import racingcar.service.RaceService;

public class RaceTest {
    CarRepository carRepository;

    @BeforeEach
    public void 저장소저장() {
        carRepository = new CarRepository(new ArrayList<Car>());
        String s = "cara,carb,carc,card,care";
        String[] split = s.split(AppConfig.INPUT_NAME_DELIMITER);
        CarSaveService.saveCars(split, carRepository);
    }

    @Test
    public void 차이동_테스트() {
        RaceService.raceRepeatByInput(1,carRepository);
        SoftAssertions.assertSoftly(softAssertions -> {
            for (int i=0; i < carRepository.size(); i++){
                Car car = carRepository.getCar(i);
                int position = car.getPosition();

                softAssertions.assertThat(position).isIn(0,4,5,6,7,8,9);

                softAssertions.assertThat(car.getPosition()).isNotIn(1,2,3);
            }
        });
    }

    @Test
    public void 차이동중_오버플로_발생시_예외던지기(){
        Car car = Car.of(0, "A");
        car.move(Integer.MAX_VALUE,true);
        Assertions.assertThatThrownBy(() -> car.move(4,true))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
