package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.repository.CarInfo;
import racingcar.repository.RacingGameRepository;
import racingcar.service.utils.InputValidatorUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class InputService {
    private RacingGameRepository racingGameRepository;
    private InputValidatorUtils inputValidatorUtils;

    public InputService() {
        this.racingGameRepository = new RacingGameRepository();
        this.inputValidatorUtils = new InputValidatorUtils();
    }

    public void readCarInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> carNames = List.of(input.split(","));
        List<Integer> carDistances = Collections.nCopies(carNames.size(), 0);
        if (InputValidatorUtils.isValidateCarInput(carNames)) {
            racingGameRepository.saveCar(getCarInfos(carNames, carDistances));
        } else {
            throw new IllegalArgumentException();
        }
    }

    public List<CarInfo> getCarInfos(List<String> carNames, List<Integer> carDistances) {
        return IntStream.range(0, carNames.size())
                .mapToObj(i -> new CarInfo(carNames.get(i), carDistances.get(i)))
                .toList();
    }

    public void readMoveCountFromUser() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        if (InputValidatorUtils.isNum(input)) {
            int moveCount = Integer.parseInt(input);
            System.out.println(moveCount);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
