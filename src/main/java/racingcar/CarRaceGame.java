package racingcar;
import model.Player;

import static camp.nextstep.edu.missionutils.Console.readLine;
public class CarRaceGame {

    public static void run() {
        // Application에다가 넣기(?) - 리펙토링
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String userInputName = readLine();
        String[] userNames = saveName(userInputName); //saveName(); 입력
        Player[] players = makePlayers(userNames, userNames.length); // player 생성
        System.out.println("시도할 횟수는 몇회인가요?");
        int n = Integer.parseInt(readLine());
        getRandomNumber();
        // 입력한 값 숫자가 맞는지 에러처리기능(추후 메서드 화 시켜야함) - docs 변경 리펙토링
        // printResult(int n) - docs 변경 리펙토링
        //printWinner()

    }
    public static String[] saveName(String userInputName) {
        String[] userNames = userInputName.split(",");
        return userNames;
    }

    public static Player[] makePlayers(String[] userNames, int size) {
        Player[] players = new Player[size];
        for(int i = 0; i < size; i++) {
            players[i] = new Player(userNames[i]);
        }
        return players;
    }
    public static void getRandomNumber() {


    }
    public static void printResult() {

    }

    public static void printWinner() {

    }


}
