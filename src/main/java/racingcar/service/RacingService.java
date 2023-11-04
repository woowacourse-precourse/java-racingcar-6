package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingService {
    // Service
    // 비즈니스 규칙, 데이터 처리, 외부 시스템과의 상호작용 등을 처리하는 데 주로 사용
    // 도메인 객체를 사용하여 비즈니스 로직을 구현
    // 필요에 따라 데이터 베이스 또는 외부 서비스와 상호 작용

    public List<String> playRound(List<Car> carList) {
        List<String> result = new ArrayList<>();

        for (Car car : carList) {
            int randomNumber = Randoms.pickNumberInRange(0, 10);
            car.move(randomNumber);
            result.add(car.getStatus());
        }

        return result;
    }
}
