package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    //자동차 이름 입력
    public static String[] carName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input[] = Console.readLine().split(",");
        while(!isValidInput(input)){
            throw new IllegalArgumentException("5글자 이하의 이름으로 입력해주세요.");
        }
        return input;
    }

    //자동차 경주 시도 회수 입력
    public static Integer moveNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    //자동차 전진여부
    public static Integer moveCar() {
        int randomNumber = Randoms.pickNumberInRange(0,9);
        if (randomNumber >= 4) {
            return 1; // 전진
        } else {
            return 0; // 멈춤
        }
    }

    //에러처리
    public static boolean isValidInput(String[] input) {
        for(String i : input){
            if(i.length()>5||i.isEmpty()){
                return false;
            }
        }
        return true;
    }
    //플레이어의 경주 실행결과 출력
    public static void printResults(String[] players, int[] playerDistance) {
        System.out.println();
        System.out.println("실행 결과");
        int raceCount = moveNumber();
        for(int i = 0; i< raceCount; i++){
            for(int j = 0; j < players.length; j++) {
                playerDistance[j] += moveCar();
                System.out.println(players[j] + " : " + "-".repeat(playerDistance[j]));
            }
            System.out.println();
        }
    }
    //최종우승자의 거리구하기
    public static Integer maxDistance(int [] playerDistance) {
        int maxDistance = 0;
        for(int distance : playerDistance){
            if(distance > maxDistance){
                maxDistance = distance;
            }
        }
        return maxDistance;
    }
    //우승자 결정
    public static List<String> determineWinners(String[] players, int[] playerDistance) {
        int maxDistance = maxDistance(playerDistance);
        List<String> winnerList = new ArrayList<>();
        for(int i = 0; i < playerDistance.length; i++) {
            if(playerDistance[i] == maxDistance) {
                winnerList.add(players[i]);
            }
        }
        return winnerList;
    }
    //최종 우승자 출력
    public static void printWinners(List<String> winners) {
        String winnersString = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnersString);
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String[] players = carName();
        int[] playerDistance = new int[players.length];
        printResults(players, playerDistance);
        List<String> winners = determineWinners(players, playerDistance);
        printWinners(winners);
    }
}
