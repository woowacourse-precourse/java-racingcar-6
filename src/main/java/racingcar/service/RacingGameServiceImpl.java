package racingcar.service;

import static racingcar.domain.Constants.MAX_RANDOM_NUMBER;
import static racingcar.domain.Constants.MIN_RANDOM_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.Participations;
import racingcar.domain.RacingGame;
import racingcar.domain.Winners;
import racingcar.repository.RacingGameRepository;
import racingcar.util.ExceptionUtil;
import racingcar.util.StringUtil;
import racingcar.validation.IntegerValidator;

public class RacingGameServiceImpl implements RacingGameService {

    private final RacingGameRepository racingGameRepository;

    public RacingGameServiceImpl(RacingGameRepository racingGameRepository) {
        this.racingGameRepository = racingGameRepository;
    }

    @Override
    public RacingGame generateRacing(String carNames, String strTryCount) {
        Participations participations = Participations.create(carNames);
        int tryCount = processTryCountInput(strTryCount);
        Winners winners = Winners.createEmpty();

        return RacingGame.create(participations, tryCount, winners);
    }

    @Override
    public RacingGame save(RacingGame racingGame) {
        return (RacingGame) racingGameRepository.save(racingGame);
    }

    @Override
    public void decideRandomMoveCondition(RacingGame racingGame) {
        racingGame.getParticipationsList()
                .forEach(car -> pickRandomNumberAndUpdateStatus(car, racingGame.getTryCount()));
    }

    @Override
    public void calculateWinners(RacingGame racingGame) {
        int maxPosition = racingGame.calcParticipationsMaxPosition();
        racingGame.getParticipationsList().stream()
                .filter(car -> car.isPositionSameOrOver(maxPosition))
                .forEach(racingGame::addWinner);
    }

    private void pickRandomNumberAndUpdateStatus(Car car, int numCount) {
        for (int i = 0; i < numCount; i++) {
            int randomNum = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            car.insertPickedNumber(randomNum);
        }
    }

    private int processTryCountInput(String input) {
        input = StringUtil.deleteAllSpaces(input);
        IntegerValidator.validateInteger(input);

        return Integer.parseInt(input);
    }
}
