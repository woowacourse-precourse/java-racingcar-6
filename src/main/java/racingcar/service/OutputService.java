package racingcar.service;

import racingcar.repository.CarInfo;
import racingcar.repository.RacingGameRepository;

import java.util.List;

public class OutputService {
    private RacingGameRepository racingGameRepository;

    public OutputService(RacingGameRepository racingGameRepository) {
        this.racingGameRepository = racingGameRepository;
    }

    public void printSingleResult() {
        List<CarInfo> cars = racingGameRepository.getCar();
        for (CarInfo car : cars) {
            System.out.printf(car.getName() + " : ");
            System.out.println(repeatChar('-', car.getDistance()));
        }
        System.out.println();
    }

    public String repeatChar(char ch, int count) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
