package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Car {

    private static Car car;
    public List<String> movedCount;
    public List<String> names;  // Car는 Application에서만 단 한번만 생성 되기 때문에, 다른 곳에서 호출될 수 없음


    private Car(List<String> names) {
        this.names = names;
    }


    // Car를 한 곳에서 한 번만 사용 가능 하도록 구현
    public static Car getInstance(List<String> names) {
        if (car == null) {
            car = new Car(names);
            validateCarNames(car.names);
            trimCarNames(car.names);
            return car;
        }
        throw new RuntimeException("Car는 한 곳에서 한 번만 사용가능합니다.");
    }

    public void initializeMovedCount() {
        movedCount = new ArrayList<>(Collections.nCopies(car.names.size(), ""));
    }

    private static void validateCarNames(List<String> carNames) {
        Validator.checkCarCount(carNames);
        Validator.checkBlankAndLength(carNames);
        Validator.checkDuplication(carNames);
    }

    private static void trimCarNames(List<String> carNames) {
        for (int i = 0; i < carNames.size(); i++) {
            carNames.set(i, carNames.get(i).trim());  // 수정 필요
        }
    }

    public void move(int roundCount) {
        System.out.println("실행 결과");

        for (int i = 0; i < roundCount; i++) {

            for (int j = 0; j < movedCount.size(); j++) {

                if (Randoms.pickNumberInRange(0, 9) >= 4) {
                    movedCount.set(j, movedCount.get(j) + "-");
                }
            }

            for (int k = 0; k < car.names.size(); k++) {
                System.out.println(car.names.get(k) + " : " + movedCount.get(k));
            }

            System.out.println();
        }
    }

}
