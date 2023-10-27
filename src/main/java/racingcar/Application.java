package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    /*
     참가자 목록: participants
    참가자 이름: name
    이동할 횟수: moves
    이동할 거리: movementDistance
    이동한 거리: distanceMoved
    우승자: winner
    이름을 입력 -> 횟수 입력 -> 출력
    이름 배열의 인덱스와 거리배열의 인덱스를 같게 하고 이름, 거리를 횟수만큼 반복후 출력
    */
    // TODO: 프로그램 구현
    // TODO: 들여쓰기 3이하
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

//                startGame();                  //TODO: 가시성을 위해 추후에 시작점이 될 함수

        List<String> participants = new ArrayList<>();  //TODO: (임시)입력된 이름이 저장
        participantsInput(participants);
    }

    public static void participantsInput(List<String> partInput) {      //명단 메소드
        List<String> participants = new ArrayList<>();
        String participantName = Console.readLine();
//                try {
        for (String name : participantName.split(",")) {
            if (!participants.contains(name)) {      //TODO: 글자수5이하 조건
                participants.add(name);
            }
            else {
                System.out.println("중복된 이름이 있습니다. 입력입니다.");
                throw new IllegalArgumentException();
            }
            if (name.length() > 5 || name.length() == 0) {
                System.out.println("5글자이상의 이름이 있습니다.");
                System.out.println(name.length());
                throw new IllegalArgumentException();
            }
//                                if (isValidString(name)) {
//                                        throw new IllegalArgumentException();
//                                }
            System.out.println(name);
        }
        System.out.println("participants" + participants);       //이름목록의 배열 제출x
        System.out.println(participantName);            // 이름을,로 구분 제출x

//                } catch (IllegalArgumentException e) {
//                        return;
//                }
    }

    public static void inputMoves(List<String> Participants) {       //이동할 거리 메소드
        System.out.println("시도할 회수는 몇회인가요?");
        String moves = Console.readLine();
        // 사람 수만큼 돌게 해야함
//                int movesToInt = moves


//                for (int i=0;i<moves;)

    }

    public static boolean isValidString(String value) {
        for (char c : value.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }
}