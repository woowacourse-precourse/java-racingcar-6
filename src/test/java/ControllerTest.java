import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Controller.RaceController;
import racingcar.Controller.RaceControllerIntegerVer;
import racingcar.Model.Car.Car;
import racingcar.Model.CarRepository;

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
