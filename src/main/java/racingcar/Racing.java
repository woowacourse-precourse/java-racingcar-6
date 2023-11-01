package racingcar;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    public static final int MAX_CARNAME_LENGTH = 5;
    private List<Car> carList;
    
    public Racing() {
        carList = new ArrayList<>();
    }

    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        inputCarName();

    }

    public void inputCarName() {
        String carNames = Console.readLine();
        splitCarName(carNames);
    }

    public void splitCarName(String carNames) {
        String[] cars = carNames.split(",");
        for(String carName : cars) {
            validateCarName(carName);
            carList.add(new Car(carName));
        }
    }

    public void validateCarName(String carName) {
        if(carName.length() > MAX_CARNAME_LENGTH)
            throw new IllegalArgumentException("잘못된 값이 입력되었습니다.");
    }
}
