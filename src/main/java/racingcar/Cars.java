package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public void set(String input){
        List<String> carNameList = parsingCarNames(input);
        storeCars(carNameList);
    }

    public List<String> parsingCarNames(String carNames){
        List<String> carNameList = splitAndConvertToList(carNames, ",");

        return carNameList;
    }

    public void storeCars(List<String> carList){
        for(String carName : carList){
            cars.add(new Car(carName, 0));
        }
    }

    public List<Car> getCars(){
        return this.cars;
    }

    public List<String> splitAndConvertToList(String input, String delimiter) {
        return Arrays.asList(input.split(delimiter));
    }

    public void moveAll(){
        for(Car car : cars){
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.move(randomNumber);
        }
    }

    public void printCarPositions(){
        for(Car car : cars){
            car.printStatus();
        }
        System.out.println();
    }

    public List<Car> getWinners() {
        List<Car> winnerList = new ArrayList<>();
        int maxPosition = -1; // 초기 최대 position 값을 가장 작은 값으로 설정

        for (Car car : cars) {
            int currentPosition = car.getPosition();
            if (currentPosition > maxPosition) {
                winnerList.clear(); // 현재 최대 position 값을 가진 Car들을 지우고
                winnerList.add(car); // 현재 Car를 추가
                maxPosition = currentPosition; // 현재 position 값을 최대로 업데이트
            } else if (currentPosition == maxPosition) {
                winnerList.add(car); // 현재 Car를 추가 (동일한 최대 position)
            }
        }
        return winnerList;
    }
}
