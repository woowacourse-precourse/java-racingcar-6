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
    public void initGame(User user, RacingGame racingGame){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameString = user.inputCarName();
        if(!validateCarName(carNameString)){
            throw new IllegalArgumentException("잘못된 자동차 이름을 입력하셨습니다.");
        }

        String[] carNames = parseCarName(carNameString);
        setCarsInRacingGame(carNames, racingGame);

        System.out.println("시도할 회수는 몇회인가요?");
        int count = Integer.parseInt(user.inputTryCount());
        if(!validateCount(count)){
            throw new IllegalArgumentException("총 시도 횟수는 양수여야 합니다.");
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
                .allMatch(name -> name.length() <= 5 && !name.isEmpty() && name.matches("^[a-zA-Z0-9가-힣]*$"));
    }

    public void doGame(int totalCount, RacingGame racingGame){
        System.out.println("실행 결과");
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

        System.out.println("최종 우승자 : " + outputMessage);
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
