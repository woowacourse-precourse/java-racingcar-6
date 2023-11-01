package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.entity.Recingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class RecingcarGameController {
    private static final String INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String PLAY_GAME_COUNT = "시도할 회수는 몇회인가요?";
    private static final String ANNOUNCEMENT_OF_WINNER = "최종 우승자 : ";
    private static int gameplayNum;
    private static String[] palyCarName;
    private static ArrayList<Recingcar> recingcars = new ArrayList<>();

    //게임 시작, 자동차 이름 & 게임 진행 횟수 입력받기
    public void gameStart(){
        System.out.println(INPUT_MESSAGE);
        palyCarName = enterRecingCarName();

        // todo 2. 입력 받은 자동차의 유효성 검사하기
        recingcars = changeEnterRecingCarNameType(palyCarName);
        if(!changeEnterRecingCarNameCheck(recingcars)){
            throw new IllegalArgumentException();
        }

        System.out.println(PLAY_GAME_COUNT);
        gameplayNum = enterPlayGameCount();
        gamePlay();
        printWinner();
    }

    public void printWinner(){
        System.out.print(ANNOUNCEMENT_OF_WINNER);

        PriorityQueue<Recingcar> finalWinerQueue = new PriorityQueue<>((o1, o2) -> o2.getMoveCnt() - o1.getMoveCnt());
        for (Recingcar nowRecingcar : recingcars) {
            finalWinerQueue.add(nowRecingcar);
        }
        int size = finalWinerQueue.size();
        int max = finalWinerQueue.peek().getMoveCnt();

        for (int i = 0; i < size; i++) {
            Recingcar nowRecingcar = finalWinerQueue.poll();
            System.out.print(nowRecingcar.getName());
            if(i + 1 < size){
                if(finalWinerQueue.peek().getMoveCnt() < max) break;
                System.out.print(", ");
            }

        }

    }

    public void gamePlay(){

        for (int i = 0; i < gameplayNum; i++) {
            for (Recingcar nowRecingcar : recingcars) {
                nowRecingcar.setRandomNum();
                if(4 <= nowRecingcar.getRandomNum()){
                    moveForward(nowRecingcar);
                }
            }
            printGameResult(recingcars);
        }
    }

    public void moveForward(Recingcar nowRecingcar){
        nowRecingcar.setMoveString("-");
        nowRecingcar.setMoveCnt(nowRecingcar.getMoveCnt() + 1);
    }

    public void printGameResult(ArrayList<Recingcar> printRecingcars){
        for (Recingcar nowRecingcar : printRecingcars) {
            System.out.println(nowRecingcar.getName() + " : " + nowRecingcar.getMoveString());
        }
        System.out.println();
    }

    public int enterPlayGameCount(){
        return Integer.parseInt(Console.readLine());
    }

    public String[] enterRecingCarName(){
        return Console.readLine().split(",");
    }

    public ArrayList<Recingcar> changeEnterRecingCarNameType(String[] inputName){
        ArrayList<Recingcar> inputEnterRecingCarName = Arrays.stream(palyCarName)
                .map(name -> new Recingcar(name))
                .collect(Collectors.toCollection(ArrayList::new));
        return inputEnterRecingCarName;
    }

    public boolean changeEnterRecingCarNameCheck( ArrayList<Recingcar> inputName){
        for (Recingcar nowRecingcar:inputName) {
            if(5 < nowRecingcar.getName().length()) return false;
        }
        return true;
    }
}
