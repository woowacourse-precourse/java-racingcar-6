package racingcar.service;

import racingcar.domain.Car;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import camp.nextstep.edu.missionutils.Randoms;

public class GameService {
    private List<Car> cars = new ArrayList<>();
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MIN_RANDOM_NUMBER = 0;

    public void initGame(Set<String> carNames) {
        for(String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void playGame() {
        for(Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            car.move(randomNumber);
        }
    }

    public Set<String> convertInputCarNamesToSet(String rawInputString) {
        Set<String> carNameSet = new HashSet<>();
        String[] splitedInputString = rawInputString.split(",");

        // 올바른 입력인지 검증
        for(String carName : splitedInputString) {
            if(carName.length() > MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }

            if(carNameSet.contains(carName)) {
                throw new IllegalArgumentException("중복된 자동차 이름이 존재합니다.");
            }

            carNameSet.add(carName);
        }

        return carNameSet;
    }

    public int convertInputTryCountToInt(String inputTryCount){
        int tryCount;

        try{
            tryCount = Integer.parseInt(inputTryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력 가능합니다.");
        }

        if(tryCount < 1){
            throw new IllegalArgumentException("시도 횟수는 1 이상만 가능합니다.");
        }

        return tryCount;
    }

    public List<Car> getWinners(){
        List<Car> winners = new ArrayList<>();
        int maxPosition = 0;

        for(Car car : cars){
            if(car.getPosition() > maxPosition){
                maxPosition = car.getPosition();
                winners.clear();
            }

            if(car.getPosition() == maxPosition){
                winners.add(car);
            }
        }

        return winners;
    }

    public List<Car> getCars() {
        return cars;
    }
}
