package racingcar.service;

import static java.util.Objects.isNull;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.util.Message;

public class ValidationService {

    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 5;
    public List<String> checkCarNames(String carNames) {
        // 1. null 체크
        checkNull(carNames);

        // 2. 공백 제거
        carNames = carNames.replaceAll(" ", "");

        // 3. 글자가 5자를 초과함에도 콤마(,)가 없는 경우 예외 발생
        if (carNames.length() > MAX_NUM && !carNames.contains(",")) {
            throw new IllegalArgumentException(Message.EXCPTION_INVALIDATE_WORDS_COUNT);
        }

        // 4. 콤마(,)를 기준으로 차량 리스트업
        List<String> carList = seperatedCarName(carNames);

        // 5. 차량 이름 목록의 유효성 검사
        for (String carName : carList) {
            if (carName.length() > MAX_NUM || carName.length() < MIN_NUM) {
                throw new IllegalArgumentException(Message.EXCPTION_INVALIDATE_WORDS_COUNT);
            }
        }

        // 6. 차량명 중복 여부 확인
        if (carList.stream().distinct().count() != carList.size()) {
            throw new IllegalArgumentException(Message.EXCPTION_CAR_NAME_DUPLICATED);
        }

        return carList;
    }

    private List<String> seperatedCarName(String carNames) {
        return Stream.of(carNames.split(",")).collect(Collectors.toList());
    }

    public int checkTrialCount(String inputTrialCount) {
        // 1. null 체크
        checkNull(inputTrialCount);

        // 2. 입력 형식이 숫자인지 확인
        try {
            Integer.parseInt(inputTrialCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.EXCPTION_NUM_ONLY);
        }
        return Integer.parseInt(inputTrialCount);
    }

    public void checkNull (String inputText) {
        if (isNull(inputText) || inputText.isEmpty() || inputText.isBlank()) {
            throw new IllegalArgumentException(Message.EXCEPTION_DO_NOT_ENTER_CAR_NAME);
        }
    }
}
