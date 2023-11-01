package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.entity.Recingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class RecingcarGameController {
    private static int gameplayNum;
    private static String[] palyCarName;
    private static ArrayList<Recingcar> recingcars = new ArrayList<>();

    //게임 시작, 자동차 이름 & 게임 진행 횟수 입력받기
    public void gameStart(){
        palyCarName = enterRecingCarName();

        // todo 2. 입력 받은 자동차의 유효성 검사하기
        recingcars = changeEnterRecingCarNameType(palyCarName);
        if(changeEnterRecingCarNameCheck(recingcars)){
            throw new IllegalArgumentException();
        }
    }

    //이름 입력 함수
    public String[] enterRecingCarName(){
        return Console.readLine().split(",");
    }

    //입력되는 자동차 이름 배열의 타입 변경(String[] -> ArrayList<Recingcar>)
    public ArrayList<Recingcar> changeEnterRecingCarNameType(String[] inputName){
        ArrayList<Recingcar> inputEnterRecingCarName = Arrays.stream(palyCarName)
                .map(name -> new Recingcar(name))
                .collect(Collectors.toCollection(ArrayList::new));
        return inputEnterRecingCarName;
    }

    // 입력되는 자동차 이름 유효성 검사 함수 
    public boolean changeEnterRecingCarNameCheck( ArrayList<Recingcar> inputName){
        for (Recingcar nowRecingcar:inputName) {
            if(5 < nowRecingcar.getName().length()) return false;
        }
        return true;
    }
}
