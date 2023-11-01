package racingcar.view;

import java.util.List;

public class View {
    private final String INIT_STRING = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String SET_TRYNUMBER_STRING = "시도할 회수는 몇회인가요?";
    private final String RESULT_MENT_STRING = "실행 결과";
    private final String GAMERESULT_STRING = "최종 우승자 : ";

    public View() {
    }

    public void initView() {
        System.out.println(INIT_STRING);
    }

    public void tryNumberView() {
        System.out.println(SET_TRYNUMBER_STRING);
    }

    public void resultView() {
        System.out.println(RESULT_MENT_STRING);
    }

    public void resultViewperIter(String[] carNameList, List<String> resultList) {
        for (int i = 0; i < carNameList.length; i++) {
            System.out.println(carNameList[i] + " : " + resultList.get(i));
        }
        System.out.println();
    }

    public void winnerView(List<String> winners) {
        String winnerString = "";
        winnerString += String.join(", ", winners);
        System.out.println(GAMERESULT_STRING+winnerString);
    }
}
