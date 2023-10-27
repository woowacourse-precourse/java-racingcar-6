package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Message {

    public String inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }
    public String inputGameRound(){
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }

    public void validInputCarName(String input){
        if(input.isBlank()) throw new IllegalArgumentException("입력 문자열이 비어 있습니다.");

        ArrayList<String> cars = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(input, ",");
        while(st.hasMoreTokens()){
            if(st.nextToken().length() > 5) throw new IllegalArgumentException("자동차 이름을 5자 이하로 입력해주세요.");
        }
    }

    public void validInputGameRound(String input) {
        if(input.isBlank()) throw new IllegalArgumentException("입력 문자열이 비어 있습니다.");

        for(int i=0; i<input.length(); i++) {
            if(!Character.isDigit(input.charAt(i))) throw new IllegalArgumentException("정수 값을 입력해주세요.");
        }

        int num = Integer.parseInt(input);
        if(num<=0) throw new IllegalArgumentException("1회 이상 게임이 진행 되어야 합니다.");
    }

    public void printResult() {
        System.out.println("실행 결과");
    }

    public void printWinners() {
        System.out.println("최종 우승자");
    }
}
