import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.controller.RaceController;
import racingcar.controller.RaceControllerIntegerVer;
import racingcar.model.Car.Car;
import racingcar.model.CarRepository;

public class ControllerTest {

    CarRepository carRepository;

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
    public void RaceController_테스트(){
        RaceController raceControllerIntegerVer = new RaceControllerIntegerVer();
        raceControllerIntegerVer.processRace("5",carRepository);
    }
}
