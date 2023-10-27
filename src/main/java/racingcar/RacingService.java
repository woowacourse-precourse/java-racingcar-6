package racingcar;

import java.util.Arrays;
import java.util.List;

public class RacingService {
    RacingRepository racingRepository = new RacingRepository();

    /**
     * 1-2. 사용자 입력값(자동차 이름) 검증
     *
     * @param names 사용자의 자동차 이름 입력값
     * @return 유효한 자동차 이름 리스트
     * @throws IllegalArgumentException 공백, 길이 5 초과, 중복 이름일 시
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

        if (isInvalidLength || isDuplicate || isInvalidName) {
            throw new IllegalArgumentException("유효하지 않은 이름을 입력했습니다.");
        }
        return Arrays.stream(namesArr).map(String::trim).toList();
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
     * @throws IllegalArgumentException 1 이상의 숫자가 아닐 시
     */
    int testValidCount(String count) throws IllegalArgumentException {
        try {
            int validCount = Integer.parseInt(count.trim());
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
     * 3-2. 차수별 자동차 이동 결과 출력
     */
    String getCarTotalMove() {
        StringBuilder totalMove = new StringBuilder();
        for (Car car : racingRepository.getCarList()) {
            totalMove.append(car.getName() + " : " + "-".repeat(car.getTotalMove()) + "\n");
        }
        return totalMove.toString();
    }

    /**
     * 4-1. 차 누적 거리 비교해 최고 점수를 리턴
     *
     * @return 경주의 최고점수
     */
    int getHighScore() {
        int highScore = racingRepository.getCarList().stream()
                .map(Car::getTotalMove)
                .mapToInt(i -> i)
                .max().orElse(0);
        return highScore;
    }

    /**
     * 4-2. 우승자 리스트를 리턴
     *
     * @param highScore 최고 점수
     * @return 최고 점수의 차(우승자) 리스트
     */
    List<String> getWinner(int highScore) {
        List<String> winnerList = racingRepository.getCarList().stream()
                .filter(car -> car.getTotalMove() == highScore)
                .map(Car::getName)
                .toList();
        return winnerList;
    }
}
