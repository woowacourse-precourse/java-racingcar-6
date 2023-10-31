package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }


    /** 입력과 관련된 메서드 입니다.
     * 
     * @return inputlist 는 사용자에게 입력 받은 유저 리스트를 return합니다.
     */
    public static ArrayList<String> isNamesInput() {
        
        String input = Console.readLine().trim();
    
        if (input.equals("") || input == null || input.isEmpty()) 
            throw new IllegalArgumentException("입력이 되지 않았습니다.");
        
        StringTokenizer st = new StringTokenizer(input, ",");
        ArrayList<String> inputlist = new ArrayList<>();

        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (token.length() <= 0 || token.length() > 4) {
                throw new IllegalArgumentException("올바른 이름을 입력하세요.");
            }
            inputlist.add(token);
        }

        return inputlist;
    }

        /** 입력과 관련된 메서드 입니다.
     * 
     * @return input은 사용자가 입력한 숫자 입니다.
     */
    public static int isNumberInput() {
        int input = Integer.parseInt(Console.readLine());
        if (input < 0) 
            throw new IllegalArgumentException("음수가 입력되었습니다.");
        
        return input;
    }
}
