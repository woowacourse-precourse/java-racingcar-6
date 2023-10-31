package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;

public class UserInput {

    public static List<String> getCarNames() {
        //여기서 글자를 띄워주면 글자가 여러 번 나오니까, main()에서 띄워주자
        String carNamesInput = Console.readLine();
        //Array보다는  Collections 사용! - 1주차 피드백
        List<String> carNamesInputList = Arrays.asList(carNamesInput.split(","));
        // 유저가 자동차 한 개만 입력했든, 여러개를 입력했든, 어차피 split이 되면서(1개의 경우는 안되면서) carNamesInputArray로 들어감

        // 5자 이상 이름은 솎아내기
        checkNameLengthException(carNamesInputList);
//        for (String carName : carNamesInputList) {
//            if (carName.length() > 5) {
//                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다");
//            }
//        }


//      System.out.println(carNamesInputList.toString());
        return carNamesInputList;

    }

    public static int getTrialNumber() {
        int trialNumber = Integer.parseInt(Console.readLine());


        return trialNumber;
    }

    public static void checkNameLengthException(List<String> carNamesInputList){
        for (String carName : carNamesInputList) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다");
            }
        }
    }

}
