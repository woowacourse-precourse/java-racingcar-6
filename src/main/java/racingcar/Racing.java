package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Racing {
    final String USER_INPUT_SENTENCE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    final String TRY_NUM_SENTENCE = "시도할 회수는 몇회인가요?";
    final String RESULT_SENTENCE = "\n실행 결과";

    RandomNumberGenerator r = new RandomNumberGenerator();
    RacingDefine d = new RacingDefine();
    List<String> userNameList = new ArrayList<>();
    List<Integer> randNumList = new ArrayList<>();
    List<String> racingResult = new ArrayList<>();
    int input_num = 0;

    public Racing() {
    }

    public void startRacing() {
        userNameList = UserInput();

        System.out.println(RESULT_SENTENCE);
        RacingProcess(userNameList, racingResult, randNumList);
        WinnerDefine.DefineWinner(userNameList, racingResult);
    }

    public static boolean isInteger(String strValue) {
        try {
            Integer.parseInt(strValue);
            return true;
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }
    }

    public List<String> UserInput() {
        System.out.println(USER_INPUT_SENTENCE);
        List<String> userName = new ArrayList<>();
        String input = Console.readLine();

        String[] nameList = input.split(",");

        if(nameList.length < 2) {
            throw new IllegalArgumentException();
        }
        // 이름 저장
        for(int i = 0; i < nameList.length; i++) {
            if(nameList[i].length() > 5) {
                throw new IllegalArgumentException();
            }
            else {
                userName.add(nameList[i]);
                racingResult.add("");
            }
        }

        System.out.println(TRY_NUM_SENTENCE);
        String try_num = Console.readLine();

        if(isInteger(try_num)) {
            input_num = Integer.parseInt(try_num);
        }

        if(input_num < 1) {
            throw new IllegalArgumentException();
        }

        return userName;
    }

    // 한 회차 진행
    public void RacingProcess(List<String> nameList, List<String> distance, List<Integer> rnum) {
        for(int i = 0; i < input_num; i++) {
            rnum = RandomNumberGenerator.setRandomNum(nameList.size());
            distance = RacingDefine.DefineDistance(rnum, distance);
            printProcess(nameList, distance);
        }
    }

    public void printProcess(List<String> nameList, List<String> distance) {
        for(int i = 0; i < nameList.size(); i++){
            System.out.println(nameList.get(i) + " : " + distance.get(i));
        };
        System.out.println();
    }
}
