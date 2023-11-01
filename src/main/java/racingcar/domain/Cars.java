package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Car들을 담는 일급 컬렉션
 */
public class Cars {
    private List<Car> cars = new ArrayList<>();

    public void add(String name) {
        cars.add(new Car(name));
    }

    public void racing() {
        for (Car car : cars) {
            car.race(Randoms.pickNumberInRange(0, 9));
        }
    }

    /**
     * 경주 결과들을 반환하기 위해 복사본 생성
     * <p>
     * 반환 리스트에 수정 권한 x, 요소 출력 이외 접근 제한
     *
     * @return Unchangeable로 복사한 Car객체들의 unmodifiableList
     */
    public List<Unchangeable> copyResult() {
        List<Unchangeable> copiedResult = new ArrayList<>();
        for (Car car : cars) {
            Unchangeable copied = new Car(car.getName(), car.getMovement());
            copiedResult.add(copied);
        }
        List<Unchangeable> neverChange = Collections.unmodifiableList(copiedResult);
        return neverChange;
    }

    public List<Unchangeable> giveCopiedResult() {
        return copyResult();
    }

    public int maxMovement() {
        int maxValue = 0;
        for (Car car : cars) {
            maxValue = Math.max(maxValue, car.getMovement());
        }
        return maxValue;
    }

    public String findWinner() {
        List<String> winnerList = new ArrayList<>();
        for (Car car : cars) {
            if (car.getMovement() == maxMovement()) {
                winnerList.add(car.getName());
            }
        }
        String winner = String.join(",", winnerList);
        return winner;
    }

    public List<Car> getCars() {//테스트 코드용
        return cars;
    }
}
