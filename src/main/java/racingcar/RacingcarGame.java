package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 자동차경주 게임
 */
public class RacingcarGame {
    UserInputCheck userInputCheck = new UserInputCheck(); // 사용자 입력 유효성 확인 및 Exception 처리
    List<Racingcar> racingcars = new ArrayList<>(); // 게임에 참여하는 자동차
    private int tryCount; // 시도 횟수

    /**
     * 자동차경주 게임 진행
     */
    public void playGame() {
        // 사용자 입력
        getCarName();
        getTryCount();
    }

    /**
     * 사용자 자동차 이름 입력 및 유효성 확인
     */
    public void getCarName(){
        System.out.println(Constant.INPUT_NAME_MESSAGE);
        String input = Console.readLine();

        // 유효성 확인 및 Exception 처리
        userInputCheck.checkNameLength(input);

        // 자동차 정보 저장
        String [] names = input.split(",");
        for (String name : names){
            Racingcar newCar = new Racingcar(name);
            racingcars.add(newCar);
        }
    }

    /**
     * 사용자 시도 횟수 입력 및 유효성 확인
     */
    public void getTryCount(){
        System.out.println(Constant.INPUT_COUNT_MESSAGE);
        String input = Console.readLine();

        // 유효성 확인 및 Exception 처리
        userInputCheck.checkNumber(input);

        // 시도 횟수 저장
        tryCount = Integer.parseInt(input);
    }
}
