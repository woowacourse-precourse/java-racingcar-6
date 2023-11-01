package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameMaker {
    List<String> carNames;
    public int totalRounds;
    public List<Car> cars;
    int carCount;
    public GameMaker() {
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
        this.cars = new ArrayList<Car>();
        for (int i = 0; i < carCount; ++i) {
            // 입력받은 이름을 기반으로 차례대로 차량 생성
            Car car = new Car(carNames.get(i));
            this.cars.add(car);
        }
        if (!InputValidator.isValidateCars(this.cars)) {
            throw new IllegalArgumentException("차량 이름 오류 발생");
        }
    }
    void setTotalRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
        String userInput = Console.readLine();
        if (!InputValidator.isPositiveNumber(userInput)) {
            throw new IllegalArgumentException("시도 회수 오류 발생");
        }
        this.totalRounds = Integer.parseInt(userInput);
    }
    String setCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = Console.readLine();
        return userInput;
    }
}
