package racingcar.controller;

import java.util.List;
import java.util.Map;
import racingcar.model.converter.inputConverter.InputConverter;
import racingcar.model.data.Cars;
import racingcar.model.data.Race;
import racingcar.model.generator.MovementGenerator;
import racingcar.model.record.MoveCount;
import racingcar.model.validator.carName.CarNameValidator;
import racingcar.model.validator.moveCount.MoveCountValidator;
import racingcar.view.RaceView;

/**
 * 자동차 경주 게임의 메인 컨트롤러
 */
public class RaceController {
    private Race race;
    private RaceView raceView;


    /**
     * RaceView를 제공받는 새로운 RaceController를 생성
     *
     * @param raceView 유저와 상호작용할 입/출력 view
     */
    public RaceController(RaceView raceView) {
        this.raceView = raceView;
    }

    /**
     * validator와 converter를 제공받아 Race를 초기화
     *
     * @param carNameValidator 자동차 이름 입력에 대한 유효성 검증
     * @param inputConverter String 입력에 대해 제너릭 형식으로 변환
     * @param moveCountValidator 총 경주 횟수 입력에 대한 유효성 검증
     */
    public void initRace(CarNameValidator carNameValidator, InputConverter<Long> inputConverter, MoveCountValidator moveCountValidator) {
        String[] carNamesFromUsers = getCars(carNameValidator);
        int moveCountFromUsers = getMoveCount(inputConverter, moveCountValidator);
        race = new Race(new Cars(Cars.FromNames(carNamesFromUsers)), new MoveCount(moveCountFromUsers));
    }

    private String[] getCars(CarNameValidator carNameValidator) {
        raceView.displayCarNameInputNotice();
        String[] carNamesFromUsers = raceView.getCarNamesFromUsers();
        carNameValidator.validateAll(carNamesFromUsers);

        return carNamesFromUsers;
    }

    private int getMoveCount(InputConverter<Long> inputConverter, MoveCountValidator moveCountValidator) {
        raceView.displayMoveCountInputNotice();
        String input = raceView.getMoveCountFromUsers();
        Long moveCountFromUsers = inputConverter.convertToType(input);
        moveCountValidator.validateAll(moveCountFromUsers);

        return moveCountFromUsers.intValue();
    }

    /**
     * 이동 방식 생성기를 이용하여 경주 시작
     *
     * @param movementGenerator 자동차의 전진 여부를 결정하는 이동 방식 생성기
     */
    public void startRace(MovementGenerator movementGenerator) {
        List<Map<String, Integer>> result = race.startMove(movementGenerator);
        raceView.displayRaceStatus(result);
    }

    /**
     * 자동차 경주를 종료하고 우승자 출력
     */
    public void endRace() {
        List<String> winners = race.determineWinners();
        raceView.displayWinners(winners);
    }
}