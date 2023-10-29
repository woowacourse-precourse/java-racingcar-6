import java.util.ArrayList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.controller.RaceController;
import racingcar.controller.RaceControllerIntegerRanged;
import racingcar.model.car.Car;
import racingcar.model.CarRepository;
import racingcar.service.RaceService;

public class ControllerTest {
    CarRepository carRepository;
    RaceController raceControllerIntegerVer = new RaceControllerIntegerRanged();
    @BeforeEach
    public void 저장소저장(){
        carRepository = new CarRepository(new ArrayList<Car>());
        for(int i=0; i<5; i++){
            String name = "car"+ (char)(i+'a');
            Car car = Car.of(i, name);
            carRepository.save(car);
        }
    }

    @Test
    public void 라운드수입력(){
        raceControllerIntegerVer.isValidInput(""+Integer.MAX_VALUE);

        Assertions.assertThatThrownBy(()->
                raceControllerIntegerVer.isValidInput("a123"))
                .isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(()->
                        raceControllerIntegerVer.isValidInput("" + Integer.MAX_VALUE + 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 자동차이동(){
        RaceService.raceRepeatByInput(0,carRepository);
    }
    @Test
    public void RaceController_테스트(){
        raceControllerIntegerVer.processRace("5",carRepository);
    }
}
