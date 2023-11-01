package racingcar.view;

/**
 * 사용자의 입력 규칙을 나타내는 interface이다.
 */
public interface InputView {

    /**
     * 사용자에게서 자동차들의 이름의 입력을 받는다.
     *
     * @return 사용자에게서 입력 받은 자동차들의 이름
     */
    String[] getCarNamesFromUsers();

    /**
     * 사용자에게서 이동 횟수의 입력을 받는다.
     *
     * @return 사용자에게서 입력 받은 이동 횟수
     */
    String getMoveCountFromUsers();
}
