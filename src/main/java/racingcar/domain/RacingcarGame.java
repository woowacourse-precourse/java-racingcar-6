package racingcar.domain;

import java.util.List;
import racingcar.domain.dto.CarDTO;
import racingcar.domain.dto.InitDTO;

public class RacingcarGame {
    private final Cars racingCars;
    private final Round round;

    public RacingcarGame(InitDTO initDTO){
        this.racingCars = registerCars(initDTO.getCarNames());
        this.round = new Round(initDTO.getRounds());
    }
    private Cars registerCars(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();
        return new Cars(cars);
    }

    public List<CarDTO> play(){
        this.round.next();
        return racingCars.playRound();
    }

    public List<CarDTO> end(){
        List<CarDTO> winners = racingCars.getWinners();
        return null;
    }

    public boolean isEnd() {
        return round.isEnd();
    }
}
