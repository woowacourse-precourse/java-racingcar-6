package racingcar.service;

import racingcar.dto.CarsDto;
import racingcar.util.RandomMove;
import racingcar.view.OutputView;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CarGameService {
    private RandomMove randomMove;
    private CarsDto carsDto;
    private OutputView outputView;

    public CarGameService() {
        this.randomMove = new RandomMove();
        this.carsDto = new CarsDto();
        this.outputView = new OutputView();
    }

    public List<String> playGame(List<String> participants, int times) {
        enrollCar(participants);
        while(times > 0) {
            round(participants);
            times--;
            outputView.carsStatus(carsDto.findAll());
        }
        return getWinningCar(carsDto.findAll());
    }

    private void round(List<String> participants) {
        participants.stream()
                .forEach(this::MoveCar);
    }

    private void enrollCar(List<String> participants) {
        participants.forEach(carsDto::enrollCar);
    }

    private void MoveCar(String carName) {
        if(randomMove.isMove()) {
            carsDto.increaseCarPosition(carName);
        }
    }

    private List<String> getWinningCar(Map<String, Integer> participants) {
        return participants.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == getMaxPosition(participants))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private static int getMaxPosition(Map<String, Integer> map) {
        return map.values().stream().max(Integer::compareTo).orElse(0);
    }
}
