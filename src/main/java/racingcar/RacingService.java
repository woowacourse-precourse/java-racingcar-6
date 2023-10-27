package racingcar;

import java.util.Arrays;
import java.util.List;

public class RacingService {
    RacingRepository racingRepository = new RacingRepository();

    /**
     * 1-2. 사용자 입력값(자동차 이름) 검증
     *
     * @param names 사용자의 자동차 이름들 입력값
     * @return 유효한 자동차 이름 리스트
     * @throws IllegalArgumentException
     */
    List<String> testValidNames(String names) throws IllegalArgumentException {
        String[] namesArr = names.split(",");

        boolean isInvalidName = Arrays.stream(namesArr)
                .map(String::trim).anyMatch(String::isEmpty)
                || names.endsWith(",");
        boolean isInvalidLength = Arrays.stream(namesArr)
                .anyMatch(name -> name.length() > 5);
        boolean isDuplicate = Arrays.stream(namesArr)
                .distinct().count() != namesArr.length;

        if (isInvalidLength || isDuplicate  || isInvalidName) {
            throw new IllegalArgumentException("유효하지 않은 이름을 입력했습니다.");
        }
        return Arrays.stream(namesArr).toList();
    }

    /**
     * 1-3. 자동차 객체 생성, 저장
     *
     * @param validNameList 자동차 이름 리스트
     */
    void generateCar(List<String> validNameList) {
        validNameList.forEach(name -> racingRepository.addCar(new Car(name)));
    }

    /**
     * 2-2. 사용자 입력값(이동 회수) 검증
     *
     * @param count 이동 회수
     * @return 이동 회수 유효성 true / false
     * @throws IllegalArgumentException
     */
    int testValidCount(String count) throws IllegalArgumentException {
        try {
            int validCount = Integer.parseInt(count);
            if (validCount <= 0) {
                throw new IllegalArgumentException("시도할 회수는 1 이상이어야 합니다.");
            }
            return validCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정확한 숫자로 입력해주세요.");
        }
    }

    /**
     * 3-1. 자동차 단위 난수 생성, 이동 / 정지 판별 후 이동
     */
    void generateMove() {
        int[] moveArray = racingRepository.generateRandom();
        racingRepository.moveCar(moveArray);
    }

    /**
     * 3-2. 차수별 자동차 이동결과 출력
     */
    void printTotalMove() {
        List<Car> carList = racingRepository.getCarList();
        for (Car car : carList) {
            System.out.printf("%s : %s \n", car.getName(), "-".repeat(car.getTotalMove()));
        }
        System.out.println();
    }
}
