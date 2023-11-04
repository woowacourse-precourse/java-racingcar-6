package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    // 유저의 입력을 받는 클래스

    // 질문을 하고 그 질문에 대한 답을 받아오는 메서드 만들어야 함
    public static String readInput(String question){
        System.out.println(question);
        return readLine();
    }
}
