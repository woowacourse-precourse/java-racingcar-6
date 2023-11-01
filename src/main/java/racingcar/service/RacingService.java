package racingcar.service;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Racing;
import racingcar.repository.RacingRepository;
public class RacingService {
    private static final int START = 0;
    private static final int END = 9;
    private static final int FORWARD_criterion = 0;
    private static final int MIN = -1;
    private final RacingRepository racingRepository = new RacingRepository();

    public void play(Racing racing) {
        moveForward_check_numbers(racing);
        racing.increase_trialNumbers();
    }

    public List<String> Winners(Racing racing) {
        List<Car> cars = racing.getCars();
        int max_Position = get_Max_Position(cars);
        return get_Max_Position_Cars(cars,max_Position);
    }

    public Boolean is_END(Racing racing) {

        return racingRepository.is_END(racing);
    }

    public Long save(Racing racing) {
        return racingRepository.save(racing);
    }

    public int get_Random_Number() {
        return Randoms.pickNumberInRange(START,END);
    }

    public int get_Max_Position(List<Car> cars) {
        int max = MIN;
        for (Car car : cars) {
            if (max < car.getPosition()){
                max = car.getPosition();
            }
        }
        return max;
    }

    private List<String> get_Max_Position_Cars(List<Car> cars, int max_Position) {
        List<String> car_Names = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == max_Position) {
                car_Names.add(car.getName());
            }
        }
        return car_Names;
    }

    private int moveForward_check_numbers(Racing racing){
        for (Car car : racing.getCars()) {
            if (FORWARD_criterion <= get_Random_Number()){
                car.moveForward(1);
            }
        }
    }
}
