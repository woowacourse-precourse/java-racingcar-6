package racingcar;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.Collectors;




public class RacingGame extends Game{
    private final List<RacingCar> cars = new ArrayList<>();
    private int tryCount;

    @Override
    public void initGame() {
        String[] carNames = InputHandler.getCarNames();
        for (String name : carNames) {
            cars.add(new RacingCar(name));
        }
        tryCount = InputHandler.getTryCount();
    }

    @Override
    protected void playGame() {
        for (int i = 0; i < tryCount; i++) {
            playRound();
            System.out.println(); // 줄바꿈으로 각 라운드 구분
        }
        String winners = determineWinners();
        OutputHandler.printWinners(winners);
    }

    private void playRound() {
        OutputHandler.printMessage("실행 결과");
        for (RacingCar car : cars) {
            car.move(Randoms.pickNumberInRange(0, 9));
            OutputHandler.printCarStatus(car.getName(), car.getPosition());
        }
    }

    private String determineWinners() {
        int maxPosition = cars.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElse(-1);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(RacingCar::getName)
                .collect(Collectors.joining(", "));
    }


}
