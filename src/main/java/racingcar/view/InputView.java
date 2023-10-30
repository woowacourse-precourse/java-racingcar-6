package racingcar.view;

import java.util.List;

/**
 * 사용자로부터 입력을 받는 인터페이스입니다.
 */
public interface InputView {
    /**
     * 자동차 이름을 입력받습니다.
     *
     * @return 자동차 이름
     */
    List<String> getCarNamesInput();

    /**
     * 시도할 횟수를 입력받습니다.
     *
     * @return 시도할 횟수
     */
    String getRoundInput();
}
