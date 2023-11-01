package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import racingcar.constant.InputDelimiter;
import racingcar.util.InputUtil;
import racingcar.util.message.RacingMessage;
import racingcar.util.message.SystemMessage;

public class Participants {

    private List<Car> cars;
    private final InputUtil inputUtil = new InputUtil();

    public void registerParticipant() {
        SystemMessage.INPUT_CAR_NAME_MESSAGE.printMessage();
        this.cars = setParticipant();
    }

    private List<Car> setParticipant() {
        String participantInput = inputUtil.inputCarName();
        if (participantInput.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return convertStringToList(participantInput);
    }

    private List<Car> convertStringToList(String participantInput) {
        List<String> rawParticipantInput = Arrays.stream(
                participantInput.split(InputDelimiter.PARTICIPANT_INPUT_DELIMITER.getValue())).toList();
        return rawParticipantInput.stream().map(carName -> new Car(carName, 0)).toList();
    }

    public void race() {
        cars.forEach(Car::race);
        printRaceInfo();

    }

    public void printRaceInfo() {
        cars.forEach(car -> System.out.println(generateRaceInfoMessage(car)));
        System.out.println();
    }

    private String generateRaceInfoMessage(Car car) {
        return String.format(RacingMessage.TRIAL_INFO_MESSAGE.getRacingTrialMessage(), car.getName(),
                car.getMovedDistanceDisplay());
    }

    public List<Car> getCars() {
        return cars;
    }
}
