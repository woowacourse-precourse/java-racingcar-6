package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class TryCount {
    private static void printGuide_InputTryCount(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    private static Integer convert_StringToPositiveInteger(String string_try_count){
        try {
            Integer int_try_count = Integer.valueOf(string_try_count);
            if(int_try_count <= 0) {
                throw new IllegalArgumentException("0 또는 음수는 입력할 수 없습니다. 자연수를 입력해주세요.");
            }
            return int_try_count;
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("소수 또는 문자는 입력할 수 없습니다. 자연수를 입력해주세요.");
        }
    }

    private static Integer inputTryCount(){
        String input_try_count = readLine();
        return convert_StringToPositiveInteger(input_try_count);
    }
}
