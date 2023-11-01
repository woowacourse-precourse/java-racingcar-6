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

    }

    public String[] enterRecingCarName(){
        return Console.readLine().split(",");
    }
}
