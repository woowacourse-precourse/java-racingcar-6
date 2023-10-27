package racingcar;

import java.util.Arrays;
import java.util.List;

public class RacingService {
    RacingRepository racingRepository = new RacingRepository();

    /**
     * 1-2. 자동차 이름 검증
     * @param names 사용자의 자동차 이름들 입력값
     * @return 정제된 각 자동차의 이름 리스트
     * @throws IllegalArgumentException
     */
    List<String> namesTest(String names) throws IllegalArgumentException {
        String[] namesArr = names.split(",");

        boolean isInvalidLength = Arrays.stream(namesArr)
                .anyMatch(name -> name.length() > 5);
        boolean hasDuplicates = Arrays.stream(namesArr)
                .distinct().count() != namesArr.length;

        if (isInvalidLength || hasDuplicates) {
            throw new IllegalArgumentException();
        }
        return Arrays.stream(namesArr).toList();
    }

    /**
     * 1-3. 자동차 객체 생성, 저장
     * @param validNameList 자동차 이름 리스트
     */
    void generateCar(List<String> validNameList) {
        validNameList.forEach(name -> racingRepository.addCar(new Car(name)));
    }
}
