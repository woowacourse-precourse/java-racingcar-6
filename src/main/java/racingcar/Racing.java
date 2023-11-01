package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Racing {
    private List<Car> cars = new ArrayList<>();
    private int numberOfRacing;
    private final int MOVE_THRESHOLD = 4;
    public void gameStart() {
        init();
        for (int i = 0; i < this.numberOfRacing; i++) {
            race();
        }
        String result = getWinner();
        System.out.println(result);
    }

    private void init() {
        inputCarNames();
        inputNumberOfRacing();
    }

    private void inputCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String inputcars = Console.readLine(); //자동차 이름 input
        List<String> carnames = Arrays.asList(inputcars.split(",")); //Array로 변환
        ValidateInput.validateCarNames(carnames); // 유효성 검사
        for (String name: carnames) {
            this.cars.add(new Car(name)); // 객체 생성
        }
    }

    private void inputNumberOfRacing() {
        System.out.println("시도할 횟수는 몇회인가요?");
        String inputNum = Console.readLine(); //횟수 input
        numberOfRacing = Integer.parseInt(inputNum); //int로 변환
        ValidateInput.validateNumberOfRaces(numberOfRacing); //유효성 검사
    }

    private void race() {
        for (Car car : cars) {
            int dice = Randoms.pickNumberInRange(0,9);
            if(dice >= MOVE_THRESHOLD) {
                car.moveForward(); //4 이상 나오면 move
            }
            int stepLength = car.movementHistory().length();
            System.out.println(car.name() + " : " 
            + car.movementHistory().substring(1,stepLength - 1)); //지금까지의 step 출력
        }
    }
    private String getWinner() {
        int maxLength = 0;
        List<Car> winners = new ArrayList<>();
        // 제일 긴 step 찾기
        for (Car car : cars) {
            if (car.movementHistory().length() >= maxLength){
                maxLength = car.movementHistory().length();
            }
        }
        // 제일 긴 step과 자동차의 step이 같다면, winner List에 add
        for (Car car : cars) {
            if(car.movementHistory().length() == maxLength){
                winners.add(car);
            }
        }

        StringBuilder result = new StringBuilder("최종 우승자 : ");

        for (int i = 0; i < winners.size(); i++) {
            result.append(winners.get(i).name());
            if(i != winners.size() - 1) {
                result.append(", ");
            } 
        }
        return result.toString();
    }
}
