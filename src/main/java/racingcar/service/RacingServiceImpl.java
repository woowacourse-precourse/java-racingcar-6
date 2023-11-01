package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.dto.InitDto;
import racingcar.repository.Repository;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static racingcar.constant.NumberConstant.*;

public class RacingServiceImpl implements RacingService {
    private final Repository repository;
    private final NumberGenerateService numberGenerateService;
    private final List<Car> cars;
    private final int times;

    public RacingServiceImpl(InitDto initDto, Repository repository, NumberGenerateService numberGenerateService) {
        this.cars = initDto.getCars();
        this.times = initDto.getTimes();
        this.repository = repository;
        this.numberGenerateService = numberGenerateService;
    }

    @Override
    public void gameProgress() {
        OutputView.gameStart();
        for (int i = 0; i < times; i++) {
            progressOnceTime();
        }
    }

    private void progressOnceTime() {
        for (Car car : cars) {
            repository.moveForward(car, numberGenerateService.randomNumber());
            OutputView.gameProgress(car);
        }
        OutputView.skipLine();
    }

    @Override
    public void gameResult() {
        int max = 0;
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getCount() > max) {
                max = car.getCount();
                winners.clear();
            }
            if (max == car.getCount())
                winners.add(car.getName());
        }
        OutputView.gameResult(winners);
        Console.close();
    }
}
