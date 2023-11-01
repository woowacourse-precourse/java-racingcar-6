package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    public static final int MAX_CARNAME_LENGTH = 5;
    public static final int STOP_CAR_NUM = 3;
    private List<Car> carList;
    private int tryCount;
    
    public Racing() {
        carList = new ArrayList<>();
        tryCount = 0;
    }

    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        inputCarName();
        System.out.println("시도할 회수는 몇회인가요?");
        inputTryCount();
        System.out.println("\n실행 결과");
        for(int i = 0; i < tryCount; i++) {
            startMatch();
            showMatchResult();
        }

    }

    public void inputCarName() {
        String carNames = Console.readLine();
        splitCarName(carNames);
    }

    public void inputTryCount() {
        String inputString = Console.readLine();
        validateTryCount(inputString);
        tryCount = Integer.parseInt(inputString);
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

    public void validateTryCount(String inputString) {
        for(char c : inputString.toCharArray()){
            if(!Character.isDigit(c))
                throw new IllegalArgumentException("잘못된 값이 입력되었습니다.");
        }
    }

    public void startMatch() {
        for(Car car : carList) {
            if(moveCar())
                car.move();
        }
    }

    public boolean moveCar() {
        if(Randoms.pickNumberInRange(0,9) > STOP_CAR_NUM)
            return true;
        else
            return false;
    }
    
    public void showMatchResult() {
        StringBuilder sb = new StringBuilder();
        for(Car car : carList) {
            sb.append(car.getCarName());
            sb.append(" : ");
            sb.append("-".repeat(car.getMovement()));
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
