package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class IO {
    private static CheckForm checkForm;

    public IO(CheckForm checkForm) {
        this.checkForm = checkForm;
    }

    public String start(){
        String runner;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        runner =  Console.readLine();
        checkForm.InputForm(runner);
        return runner;
    }

    public String count(){
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }

    public void printNull(){ //클래스에서 관리해줄 내용은 아니지만, 중복되어 사용되기에 함수처리 했습니다.
        System.out.println("");
    }

}
