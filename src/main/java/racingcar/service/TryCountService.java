package racingcar.service;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class TryCountService {
    public void printGuide_InputTryCount(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public int convert_StringToPositiveInt(String string_try_count){
        if(string_try_count.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다. 자연수를 입력해주세요.");
        }

        int int_try_count;
        try {
            int_try_count = Integer.parseInt(string_try_count);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("소수 또는 문자는 입력할 수 없습니다. 자연수를 입력해주세요.");
        }

        if(int_try_count <= 0) {
            throw new IllegalArgumentException("0 또는 음수는 입력할 수 없습니다. 자연수를 입력해주세요.");
        }
        return int_try_count;
    }

    public int inputTryCount(){
        String input_try_count = readLine();
        return convert_StringToPositiveInt(input_try_count);
    }
}
