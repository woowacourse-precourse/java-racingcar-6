package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    public void printRunResult(LinkedHashMap<String, String> GameInfoMap) {
        for (Map.Entry<String, String> entry : GameInfoMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " : " + value);
        }
    }

    public void printWinners(List<String> RunnerMap) {
        if (RunnerMap.size() > 1) {
            System.out.println("최종 우승자 : " + String.join(", ", RunnerMap));
        }
        if (RunnerMap.size() == 1) {
            System.out.println("최종 우승자 : " + RunnerMap.get(0));
        }
    }

}
