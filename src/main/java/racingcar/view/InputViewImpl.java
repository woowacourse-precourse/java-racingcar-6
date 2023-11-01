package racingcar.view;

import static racingcar.util.GameConstants.CAR_NAME_DELIMITER;

import camp.nextstep.edu.missionutils.Console;

/**
 * {@code InputView}의 구현부이다.
 * missionutils 라이브러리의 Console 유틸리티를 사용하여 사용자의 입력을 받는다.
 */
public class InputViewImpl implements InputView{

    /**
     * 사용자에게서 자동차 이름 입력을 받는다.
     * 분리 기준은 {@link racingcar.util.GameConstants#CAR_NAME_DELIMITER}에 정의되어 있다.
     * 양 끝 값의 구분 기호를 남기기 위해 limit으로 -1을 설정한다.
     *
     * @return 자동차 이름의 배열
     */
    @Override
    public String[] getCarNamesFromUsers() {
        return Console.readLine().split(CAR_NAME_DELIMITER, -1);
    }

    /**
     * 사용자로부터 이동 횟수를 입력받는다.
     *
     * @return String인 이동 횟수
     */
    @Override
    public String getMoveCountFromUsers() {
        return Console.readLine();
    }
}
