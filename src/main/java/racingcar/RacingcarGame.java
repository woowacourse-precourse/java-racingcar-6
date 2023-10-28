package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingcarGame {

    private List<String> userCarName;
    //private List<String> user

    //public RacingcarGame(List<String> carName) {
    //    this.userCarName = carName;
    //}

    public void gameStart() {
        System.out.println("경주 할 자동차 이름을 입력하세요");
        String userInputName = Console.readLine();
        this.userCarName = createList(userInputName);
        checkUName();
        //checkURaceNum();
        //System.out.println(resultMessage);

    }

    public void checkUName() {
        //if (userCarName.size() < 1) {
            // 여기 코드 수정 필요함.
            //throw new IllegalArgumentException("2대 이상 입력하세요.");
        //}
        if (userCarName.contains(",")) {
            throw new IllegalArgumentException("영어로 입력하세요.");
        }
        if (userCarName == null) {
            throw new IllegalArgumentException("경주 할 자동차 이름을 입력하세요.");
        }
    }

    public List<String> createList(String userInputName) {
        String[] arrayInput = userInputName.split(",");
        List<String> carNameTest = new ArrayList<>();
        return carNameTest;
    }

    public boolean gameOver() {
        //위에 입력 조건 확인하려고 대충 써놓긴 했지만 조건 안틀리면 무한 반복임 지금
        if (userCarName != null) {
            System.out.println("일단 테스트");
        }
        return true;
    }

}
