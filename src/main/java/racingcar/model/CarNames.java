package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class CarNames {

    private static final String DELIMITER = ",";

    List<String> carNames = new ArrayList<>();
    public CarNames(String input) {
        // 입력받은 문자열 검증 후에 알맞은 입력이라면 컬렉션에 담기
        // 이름은 쉼표로 구분되어 있고 5자이하만 가능
        StringTokenizer stringTokenizer = new StringTokenizer(input, DELIMITER);
        // 처음이나 마지막에 쉼표 입력있을 시에는 알아서 에러처리??

        verifyCarName(stringTokenizer);
    }

    private void verifyCarName(StringTokenizer stringTokenizer) {
        while(stringTokenizer.hasMoreTokens()) {
            String carName = stringTokenizer.nextToken();

            if(carName.length() > 5) {
                throw new IllegalArgumentException();
            }

            carNames.add(carName);
        }
    }

    public List<String> getCarNames() {
        return Collections.unmodifiableList(carNames);
    }


}
