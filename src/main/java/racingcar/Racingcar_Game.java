package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Racingcar_Game {
    public static List<String> userInput(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input=readLine();
        String[] name=input.split(",");

        checkNameLength(name);

        return new ArrayList<>(Arrays.asList(name));
    }

    public static void checkNameLength(String[] name){
        for (String s : name) {
            if (s.length() > 5)
                throw new IllegalArgumentException("Name is too long");
        }

    }

    public static boolean checkPush(){
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }

    public static void addPush(List<String> carName,List<String> gameList){
        for (int i = 0; i < carName.size(); i++) {
            if (checkPush()) {
                String car = gameList.get(i);
                car += ('-');
                gameList.set(i, car);
            }
        }
    }
    public static void playGame(List<String> carName) {
        System.out.println("시도할 회수는 몇회인가요?");
        int gameCnt = Integer.parseInt(readLine());

        List<String> gameList = new ArrayList<>();
        for (int i = 0; i < carName.size(); i++) {
            gameList.add("");
        }

        for (int i = 0; i < gameCnt; i++) {
            addPush(carName,gameList);
            printProgress(carName,gameList);
        }
        checkWinner(carName,gameList);
    }

    public static void printProgress(List<String> carName,List<String> gameList){
        for(int i=0;i<carName.size();i++){
            System.out.println(carName.get(i)+" : "+gameList.get(i));
        }
        System.out.println();
    }

    public static void checkWinner(List<String> carName,List<String> gameList){
        List<String> winnerList = new ArrayList<>();
        int maxNum=findMaxPush(gameList);

        for(int i=0;i<carName.size();i++){
            int progressLength =gameList.get(i).length();
            if(maxNum==progressLength){
                winnerList.add(carName.get(i));
            }
        }
        System.out.print("최종 우승자 : ");

        if(winnerList.size()>1){
            printWinners(winnerList);
            return;
        }
        //우승자가 한명일 경우
        System.out.print(winnerList.get(0));


    }
    public static int findMaxPush(List<String> gameList){
        int maxNum=0;
        for (String s : gameList) {
            int progressLength = s.length();
            if (maxNum < progressLength) {
                maxNum = progressLength;
            }
        }
        return maxNum;
    }

    public static void printWinners(List<String> winnerList){
        int listCnt=winnerList.size();
        for(int i=0;i<listCnt;i++){
            System.out.print(winnerList.get(i));
            if(i!=(listCnt-1)){
                System.out.print(", ");
            }
        }
    }
}
