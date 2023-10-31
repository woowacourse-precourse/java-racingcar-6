package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.RacingGame;
import racingcar.domain.RandomNumberGenerator;
import racingcar.repository.CarRepository;
import racingcar.repository.RacingGameRepository;

public class RacingGameServiceImpl implements RacingGameService {
    private static final int MOVE_FORWARD_CONDITION = 4;
    private static final int START_NUMBER_RANGE = 0;
    private static final int END_NUMBER_RANGE = 9;
    private static final int MIN_POSITION_VALUE = -1;
    private final CarRepository carRepository;
    private final RacingGameRepository racingGameRepository;

    public RacingGameServiceImpl(CarRepository carRepository, RacingGameRepository racingGameRepository) {
        this.carRepository = carRepository;
        this.racingGameRepository = racingGameRepository;
    }

    @Override
    public RacingGame createNewGame(List<Long> carsIdList, int maxGameCount, Long id) {
        return new RacingGame(carsIdList, maxGameCount, id);
    }

    @Override
    public void join(RacingGame racingGame) {
        racingGameRepository.save(racingGame);
    }

    @Override
    public boolean isMoveableForwardByRandomNumber() {
        int randomNumber = RandomNumberGenerator.getRandomNumber(START_NUMBER_RANGE, END_NUMBER_RANGE);
        return isMoveable(randomNumber);
    }

    @Override
    public RacingGame findGameById(Long id) {
        return racingGameRepository.findById(id);
    }

    @Override
    public boolean isGameFinish(Long id) {
        return racingGameRepository.findById(id).isGameFinish();
    }


    public List<Long> getWinningCarsId(Long id) {
        List<Long> carsIdList = racingGameRepository.findById(id).getCarsIdList();
        int maxPosition = getMaxPosition(carsIdList);
        return getMaxPositionCarsId(carsIdList, maxPosition);
    }

    private List<Long> getMaxPositionCarsId(List<Long> carsIdList, int maxPosition) {
        List<Long> maxPositionCarsIdList = new ArrayList<>();
        for (Long id : carsIdList) {
            if (carRepository.findById(id).getPosition() == maxPosition) {
                maxPositionCarsIdList.add(id);
            }
        }
        return maxPositionCarsIdList;
    }

    private int getMaxPosition(List<Long> carsIdList) {
        int maxPosition = MIN_POSITION_VALUE;
        for (Long id : carsIdList) {
            maxPosition = Math.max(maxPosition, carRepository.findById(id).getPosition());
        }
        return maxPosition;
    }

    private boolean isMoveable(int randomNumber) {
        return randomNumber >= MOVE_FORWARD_CONDITION;
    }

    @Override
    public void addGameCount(Long id) {
        racingGameRepository.findById(id).increaseGameCount();
    }

}
