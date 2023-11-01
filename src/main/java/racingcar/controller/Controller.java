package racingcar.controller;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

import racingcar.domain.Car;
import racingcar.domain.Racing;
import racingcar.repository.CarRepository;
import racingcar.service.RacingService;
import racingcar.util.Utils;
import racingcar.view.Output_View;
import racingcar.view.Input_View;

public class Controller {
    private final Utils utils = new Utils();
    private final RacingService racingService = new RacingService();
    private final CarRepository carRepository = new CarRepository();

    public void run() {
        Car_Saves(utils.parse_CAR_NAMES(USER_INPUT_CAR_NAMES()));
        race(start_race());
    }

    private Racing start_race() {
        Racing racing = new Racing(get_CAR_LIST(), get_Trial_Numbers());
        racingService.save(racing);
        return racing;
    }

    private List<Car> get_CAR_LIST() {
        return carRepository.find_ALL();
    }

    private int get_Trial_Numbers() {
        return utils.parse_Trials_Numbers(USER_INPUT_TRIAL_NUMBERS());
    }

    private String USER_INPUT_TRIAL_NUMBERS() {
        Input_View.Trial_Numbers_Input_Message();
        return Check_USER_INPUT_TRIAL_NUMBERS(Console.readLine());
    }

    private String Check_USER_INPUT_TRIAL_NUMBERS(String input) {
        try {
            utils.Check_Trial_Numbers(input);
            return input;
        } catch (IllegalArgumentException e) {
            Output_View.print_Exception(e.getMessage());
            return USER_INPUT_TRIAL_NUMBERS();
        }
    }

    private String USER_INPUT_CAR_NAMES() {
        Input_View.Car_Names_Input_Message();
        String input = Console.readLine();
        return Check_USER_INPUT_CAR_NAMES(input);
    }

    private String Check_USER_INPUT_CAR_NAMES(String input) {
        try {
            utils.Check_CAR_NAMES_input(input);
            return input;
        } catch (IllegalArgumentException e) {
            Output_View.print_Exception(e.getMessage());
            return USER_INPUT_CAR_NAMES();
        }
    }

    private void race(Racing racing) {
        Output_View.print_Head();
        while (!racingService.is_END(racing)) {
            racingService.play(racing);
            Output_View.print_Score(racing.getCars());
        }
        Output_View.print_Winners(racingService.Winners(racing));
    }

    private void Car_Saves(List<String> carNames) {
        for (String carName : carNames) {
            carRepository.save(new Car(carName));
        }
    }
}
