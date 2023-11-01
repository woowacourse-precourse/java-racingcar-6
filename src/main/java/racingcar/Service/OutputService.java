package racingcar.Service;

import camp.nextstep.edu.missionutils.Console;

public class OutputService {

    public String printCarnameQuestion() {
        String question = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
        System.out.println(question);
        return question;
    }

    public String printTryNumQuestion() {
        String question = "시도할 회수는 몇회인가요?";
        System.out.println(question);
        return question;
    }
}
