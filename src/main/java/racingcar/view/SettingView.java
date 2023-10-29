package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
public class SettingView {

    private static final String GET_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분";
    private static final String GET_TRIALS = "시도할 회수는 몇회인가요?";

   public static void getCarNames() {
       System.out.println(GET_NAME);
   }
   public static void getTrialNums() {
       System.out.println(GET_TRIALS);
   }
}
