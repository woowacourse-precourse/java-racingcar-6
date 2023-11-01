package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.domain.User;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameService {
    private static final String INIT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String WRONG_CAR_NAME_MESSAGE = "잘못된 자동차 이름을 입력하셨습니다.";
    private static final String TOTAL_GAME_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String WRONG_TOTAL_GAME_COUNT_MESSAGE = "총 시도 횟수는 양수여야 합니다.";
    private static final String VALID_CAR_NAME_REGEX = "^[a-zA-Z0-9가-힣]*$";
    private static final String EXECUTE_RESULT_MESSAGE = "실행 결과";
    private static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";
    public void initGame(User user, RacingGame racingGame){
        System.out.println(INIT_MESSAGE);
        String carNameString = user.inputCarName();
        if(!validateCarName(carNameString)){
            throw new IllegalArgumentException(WRONG_CAR_NAME_MESSAGE);
        }

        String[] carNames = parseCarName(carNameString);
        setCarsInRacingGame(carNames, racingGame);

        System.out.println(TOTAL_GAME_COUNT_MESSAGE);
        int count = Integer.parseInt(user.inputTryCount());
        if(!validateCount(count)){
            throw new IllegalArgumentException(WRONG_TOTAL_GAME_COUNT_MESSAGE);
        }
        user.updateTotalGameCount(count);

        doGame(user.getTotalGameCount(), racingGame);
    }

    private boolean validateCount(int count) {
        return count > 0;
    }

    private boolean validateCarName(String carNameString) {
        String[] carNames = parseCarName(carNameString);
        return Arrays.stream(carNames)
                .allMatch(name -> name.length() <= 5 && !name.isEmpty() && name.matches(VALID_CAR_NAME_REGEX));
    }

    public void doGame(int totalCount, RacingGame racingGame){
        System.out.println(EXECUTE_RESULT_MESSAGE);
        for (int i=0; i<totalCount; i++){
            List<Car> cars = racingGame.getCars();
            moveCars(cars);
            printCurrentResult(cars);
        }

        List<Car> winners = findWinners(racingGame);
        messageWithWinners(winners);
    }

    private void moveCars(List<Car> cars) {
        for (Car car : cars) {
            int num = Randoms.pickNumberInRange(0, 9);
            if(num >= 4){
                car.move();
            }
        }
    }

    private void printCurrentResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            int distance = car.getDistance();
            for(int i=0; i<distance; i++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void messageWithWinners(List<Car> winners) {
        StringBuilder outputMessage = new StringBuilder();
        if (!winners.isEmpty()) {
            Iterator<Car> iterator = winners.iterator();
            printResultMessage(iterator, outputMessage);
        }

        System.out.println(FINAL_WINNER_MESSAGE + outputMessage);
    }

    private void printResultMessage(Iterator<Car> iterator, StringBuilder outputMessage) {
        while (iterator.hasNext()) {
            Car winner = iterator.next();
            outputMessage.append(winner.getName());
            if (iterator.hasNext()) {
                outputMessage.append(", ");
            }
        }
    }

    private List<Car> findWinners(RacingGame racingGame) {
        List<Car> cars = racingGame.getCars();
        int maxDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElseThrow();

        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .toList();
    }

    private String[] parseCarName(String carNameString) {
        return carNameString.split(",");
    }

    private void setCarsInRacingGame(String[] carNames, RacingGame racingGame){
        for (String carName : carNames) {
            Car car = new Car(carName, 0);
            racingGame.addCar(car);
        }
    }
}
