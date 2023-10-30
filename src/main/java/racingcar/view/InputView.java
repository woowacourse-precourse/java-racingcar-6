package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.StringTokenizer;

public class InputView {
    public static String inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        validInputCarName(input);
        return input;
    }
    public static String inputGameRound(){
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        validInputGameRound(input);
        return input;
    }

    public static void validInputCarName(String input){
        if(input.isBlank()) throw new IllegalArgumentException("입력 문자열이 비어 있습니다.");
        StringTokenizer st = new StringTokenizer(input, ",");
        while(st.hasMoreTokens()){
            if(st.nextToken().length() > 5) throw new IllegalArgumentException("자동차 이름을 5자 이하로 입력해주세요.");
        }
    }

    public static void validInputGameRound(String input) {
        if(input.isBlank()) throw new IllegalArgumentException("입력 문자열이 비어 있습니다.");

        for(int i=0; i<input.length(); i++) {
            if(!Character.isDigit(input.charAt(i))) throw new IllegalArgumentException("정수 값을 입력해주세요.");
        }

        int num = Integer.parseInt(input);
        if(num<=0) throw new IllegalArgumentException("1회 이상 게임이 진행 되어야 합니다.");
    }
}
