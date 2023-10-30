package racingcar.IO;

import camp.nextstep.edu.missionutils.Console;

public class IOService {
    public final static String START = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public final static String COUNT = "시도할 회수는 몇회인가요?";

    public final static String RESULT = "실행 결과";
    public final static String END = "최종 우승자";

    public void printNoticeln(String ment) {
        System.out.println(ment);
    }

    public void printNotice(String subject, String value) {
        System.out.println(subject+" : "+value);
    }

    public void inputCreatre() {
        String inputString=Console.readLine();
    }

    public void inputCount() {
        String inputString=Console.readLine();
    }
}
