package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Map<String, Integer> racer = new LinkedHashMap<>();


        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        inputRacerName(racer);

        System.out.println("시도할 회수는 몇회인가요?");
        int raceCount = inputRaceCount();

        for(int i = 0; i < raceCount; i++){
            race(racer);
        }


    }

    private static void race(Map<String, Integer> racer) {

        boolean runFlag;

        for (String runner : racer.keySet()) {

            runFlag = runCheck();

            if(runFlag){
                racer.put(runner, racer.get(runner) + 1);
            }
        }
    }

    private static boolean runCheck() {

        int diceCount = Randoms.pickNumberInRange(0, 9);
        return diceCount >= 4;
    }

    private static int inputRaceCount() {

        String input;
        input = Console.readLine();

        int count;

        try{
            count = Integer.parseInt(input);
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자가 아닌 문자가 섞여있습니다.");
        }

        return count;
    }


    private static void inputRacerName(Map<String, Integer> racer) {

        String input;
        input = Console.readLine();

        for (String name : input.split(",")) {
            // 이름의 앞 뒤에 들어오는 공백은 지운다. -> 쉼표 이후 공백일 가능성이 존재하기 때문
            nameValidetor(name.trim(), racer);
            racer.put(name.trim(), 0);
        }
    }


    /**
     * 이름이 양식에 맞게 들어왔는지, 중복된 이름이 들어왔는지 검사
     */
    private static void nameValidetor(String name, Map<String, Integer> racer) {

        if(name.length() >= 5 || name.length() == 0){
            throw new IllegalArgumentException("이름은 5자 이하만 가능, 0자는 불가");
        }

        if(racer.get(name) != null){
            throw new IllegalArgumentException("중복된 이름이 들어옴");
        }
    }
}
