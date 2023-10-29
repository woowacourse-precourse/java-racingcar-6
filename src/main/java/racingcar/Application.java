package racingcar;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import camp.nextstep.edu.missionutils.Randoms;

class raceDecisionMaker {
    boolean raceDecision() {
        int randomNumber = pickNumber();
        return randomNumber >= 4;
    }

    private int pickNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}

// 게임에 필요한 값들을 입력받는 클래스
class gameMaker {
    List <String> carNames;
    int totalRounds;
    List<Car> cars;
    int carCount;
    gameMaker() {
        String carNameInput = setCarNames();
        setTotalRounds();
        splitCarNames(carNameInput);
    }

    // 콤마(,)로 구분된 차량이름을 분리해 이름별 차량 만들어 리스트로 설정
    void splitCarNames(String carNameInput) {
        // 아예 Car들의 리스트를 인자로 받아 초기화하기. 그럼 CarNames없어두됨
        String[] tokens = carNameInput.split(",");
        carNames = Arrays.asList(tokens);
        carCount = this.carNames.size();
        initCar();
    }
    void initCar() {
        cars = new ArrayList<Car>();
        for (int i = 0; i < carCount; ++i) {
            // 입력받은 이름을 기반으로 차례대로 차량 생성
            Car car = new Car(carNames.get(i));
            cars.add(car);
        }
    }
    void setTotalRounds() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("시도할 회수는 몇회인가요?");
        String userInput = scanner.nextLine();
        scanner.close();
        this.totalRounds = Integer.parseInt(userInput);
    }
    String setCarNames() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = scanner.nextLine();
        scanner.close();
        // 유효하지 않은 값 : ,뒤에 아무것도 오지 않는 경우 처리 필요
        return userInput;
    }
}

class Car {
    String name;
    int position;

    Car(String name) {
        this.name = name;
        position = 0;
    }
}

class Game {
    List<Car> cars;
    int totalRounds;

    Game(List<Car> cars, int totalRounds) {
        this.cars = cars;
        this.totalRounds = totalRounds;
    }

    void play() {
        for (int i = 0; i < totalRounds; ++i) {

        }
    }

}

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        gameMaker maker = new gameMaker();
    }
}
