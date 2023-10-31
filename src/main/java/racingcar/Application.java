package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.LinkedHashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Map<String, Integer> racer = new LinkedHashMap<>();


        inputRacerName(racer);
        int raceCount = inputRaceCount();




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
