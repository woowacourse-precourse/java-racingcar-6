package racingcar;

import java.util.List;

public class Game {
    private final static int MOVING_FORWARD = 4;
    public GameInput gameInput = new GameInput();
    public GameOutput gameOutput = new GameOutput();


    public void run() {

        List<String> carNames;
        List<Car> carList;
        List<Car> winnerList;
        int numberOfAttempts;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carNames = gameInput.convertToCarNameList(gameInput.readInput());
        carList = createCarsFromNames(carNames);

        System.out.println("시도할 회수는 몇회인가요?");
        numberOfAttempts = gameInput.convertToMovingNumber(gameInput.readInput());

        System.out.println("실행 결과");
        for (int i = 0; i < numberOfAttempts; i++) {
            roundStart(carList);
            gameOutput.printRoundResult(carList);
        }

        winnerList = getWinners(carList);
        gameOutput.printWinners(winnerList);


    }

    private void roundStart(List<Car> carList) {
        for (Car car : carList) {
            int randomNumber = GameUtils.getRandomNumber();
            if (canMoveForward(randomNumber)) {
                car.increaseMovingCount();
            }
        }
    }

    public int getMaxMovingNumber(List<Car> carList) {
        return carList.stream()
                .mapToInt(Car::getMovingCount)
                .max()
                .orElse(0);
    }

    public boolean canMoveForward(int num) {
        return num >= MOVING_FORWARD;
    }

    public List<Car> createCarsFromNames(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    public List<Car> getWinners(List<Car> carList) {
        int maxMovingNumber = getMaxMovingNumber(carList);

        return carList.stream()
                .filter(car -> car.getMovingCount() == maxMovingNumber)
                .toList();
    }


}
