package racingcar.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Participations;
import racingcar.domain.RacingGame;
import racingcar.repository.CarRepository;
import racingcar.repository.RacingGameRepository;
import racingcar.util.ExceptionUtil;
import racingcar.util.StringUtil;
import racingcar.validation.IntegerValidator;

public class RacingGameServiceImpl implements RacingGameService {

    private final String EMPTY_INPUT_MESSAGE = "자동차 이름을 하나 이상 입력하세요.";
    private final CarRepository carRepository;
    private final RacingGameRepository racingGameRepository;

    public RacingGameServiceImpl(CarRepository carRepository, RacingGameRepository racingGameRepository) {
        this.carRepository = carRepository;
        this.racingGameRepository = racingGameRepository;
    }

    @Override
    public RacingGame generateRacing(String carNames, String strTryCount) {
        List<Car> carList = processCarNamesInput(carNames); //TODO: 기능분리 리팩터링하기
        Participations participations = new Participations(carList);
        int tryCount = processTryCountInput(strTryCount);

        return RacingGame.create(participations, tryCount);
    }

    @Override
    public RacingGame save(RacingGame racingGame) {
        //carList.forEach(car -> carRepository.save(car));
        return (RacingGame) racingGameRepository.save(racingGame);
    }

    @Override
    public void racing(RacingGame racingGame) {
        Long id = racingGame.getId();

        /*//tryCount횟수만큼 반복
        for (int i = 0; i < racingGame.getTryCount(); i++) {
            //랜덤 점수 뽑아 넣기 //TODO: 메서드 분리
            Participations participations = racingGame.getParticipations();
            for (Car car : participations.getParticipations()) {
                int randomNum = Randoms.pickNumberInRange(0,9);
                carRepository.addPickedNumbers(id, randomNum);

                if (randomNum >= 4) {
                    carRepository.addPositions(car.getLastPosition()+1);
                }
            }
        }

        //Winner 구해서 담기
        Winners winners = new Winners();
        int maxPosition = participations.maxPosition();
        for (Car car : participations.getParticipations()) {
            if (car.isPositionSameOrOver(maxPosition)) {
                winners.addWinner(car);
            }
        }

        racingGameRepository.updateWinners(id, winners);*/
    }

    private List<Car> processCarNamesInput(String input) {
        input = StringUtil.deleteAllSpaces(input);
        List<Car> carList = seperateByComma(input);
        validateEmptyInput(input, carList);

        return carList;
    }

    private List<Car> seperateByComma(String input) {
        return Arrays.stream(input.split(","))
                .map(carName -> Car.create(carName))
                .collect(Collectors.toList());
    }

    private void validateEmptyInput(String input, List<Car> carList) {
        if (input.isEmpty() || carList.isEmpty()) {
            ExceptionUtil.throwInvalidValueException(EMPTY_INPUT_MESSAGE);
        }
    }

    private int processTryCountInput(String input) {
        input = StringUtil.deleteAllSpaces(input);
        IntegerValidator.validateInteger(input);

        return Integer.parseInt(input);
    }

}
