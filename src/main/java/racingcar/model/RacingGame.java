package racingcar.model;

import racingcar.domain.Car;
import racingcar.dto.CarDTO;
import racingcar.dto.GameDTO;

public class RacingGame {
    private StringBuilder roundResult = new StringBuilder();
    private final CarManager manager;
    private int CAR_AMOUNT, ROUND_MAX;


    public RacingGame(CarManager manager, int amount, int round) {
        this.manager = manager;
        this.CAR_AMOUNT = amount;
        this.ROUND_MAX = round;
    }

    public GameDTO toDTO() {
        return new GameDTO(CAR_AMOUNT, ROUND_MAX);
    }

    public String getRoundResult() {
        return roundResult.toString();
    }

    public void playRound() {
        roundResult.setLength(0);
        for (int index = 0; index < CAR_AMOUNT; index++) {
            Car car = manager.getCarFromIndex(index);

            car.tryMove();
            updateStatus(car);
        }
    }


    // 자동차의 현재 상황판을 작성하도록 요청한 후 결과에 추가
    private void updateStatus(Car car) {
        String status = getStatus(car);
        roundResult.append(status);
    }

    // car 객체를 받아서 해당 자동차의 상황판 작성
    private String getStatus(Car car) {
        CarDTO carData = car.toDTO();

        String name = carData.getName();
        String position = "-".repeat(carData.getPosition());
        String status = String.format("%s : %s\n", name, position);

        return status;
    }

}
