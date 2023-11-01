package racingcar.view;

import java.util.List;
import java.util.Map;

/**
 * 입력 및 출력 작업 모두에 대한 통합 인터페이스를 제공한다.
 * 입력 view {@code InputViewImpl}와 출력 view {@code OutputViewImpl}를 가지고 있다.
 */
public class RaceView {

    /** 입력의 책임을 담당하는 {@link InputView}의 인스턴스이다. */
    private InputView inputView;

    /** 출력의 책임을 담당하는 {@link OutputView}의 인스턴스이다. */
    private OutputView outputView;

    /**
     * 특정한 입력 view와 출력 view를 가진 인스턴스를 생성한다.
     *
     * @param inputView 사용자의 입력의 책임이 있는 view이다.
     * @param outputView 사용자에게 보여주는 출력의 책임이 있는 view이다.
     */
    public RaceView(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    /**
     * 사용자에게 자동차의 이름을 입력하라는 메시지를 출력한다.
     */
    public void displayCarNameInputNotice() {
        outputView.displayCarNameInputNotice();
    }

    /**
     * 사용자에게서 자동차 이름 입력을 받는다.
     * 분리 기준은 {@link racingcar.util.GameConstants#CAR_NAME_DELIMITER}에 정의되어 있다.
     * 양 끝 값의 구분 기호를 남기기 위해 limit으로 -1을 설정한다.
     *
     * @return 자동차 이름의 배열
     */
    public String[] getCarNamesFromUsers() {
        return inputView.getCarNamesFromUsers();
    }

    /**
     * 사용자에게 총 이동 횟수를 입력하라는 메시지를 출력한다.
     */
    public void displayMoveCountInputNotice() {outputView.displayMoveCountInputNotice();}

    /**
     * 사용자로부터 이동 횟수를 입력받는다.
     *
     * @return String인 이동 횟수
     */
    public String getMoveCountFromUsers() {
        return inputView.getMoveCountFromUsers();}

    /**
     * 각각의 자동차의 이름과 토큰을 이용한 위치로 경주 현황을 보여준다.
     *
     * @param result 총 이동 횟수 동안 각각의 횟수에 대한 자동차 경주 결과를 담은 map의 List
     */
    public void displayRaceStatus(List<Map<String, Integer>> result) {
        outputView.displayRaceStatus(result);
    }

    /**
     * 경주의 우승 자동차들의 이름을 출력한다.
     *
     * @param winners 우승 자동차들의 이름을 담은 list
     */
    public void displayWinners(List<String> winners) {
        outputView.displayWinners(winners);}
}
