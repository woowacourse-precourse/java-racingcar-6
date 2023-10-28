package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import net.bytebuddy.implementation.bytecode.ShiftRight;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.getName;

public class Application {

        // TODO: 프로그램 구현
        // TODO: 들여쓰기 3이하
        public static void main(String[] args) {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

//                startGame();                  //TODO: 가시성을 위해 추후에 시작점이 될 함수

                List<String> participants = new ArrayList<>();  //TODO: (임시)입력된 이름이 저장
                participantsInput(participants);
        }

        public static void participantsInput(List<String> partInput) {      //명단 메소드
                List<Car> participants = new ArrayList<>();
                String participantInputName = Console.readLine();
//                try {     //todo: try catch문 삭제
                for (String name : participantInputName.split(",")) {
                        if (!participants.contains(name)) {
                                participants.add(new Car(name, 0));
                        } else {
                                System.out.println("중복된 이름이 있습니다. 입력입니다.");
                                throw new IllegalArgumentException();
                        }
                        if (name.length() > 5 || name.length() == 0) {
                                System.out.println("5글자이상의 이름이 있습니다.");
                                System.out.println(name.length());
                                throw new IllegalArgumentException();
                        }       //                                유효성 검사
                        System.out.println(name);
                }

//                } catch (IllegalArgumentException e) {
//                        return;
//                }
                System.out.println("시도할 회수는 몇회인가요?");
                String inputMoves = Console.readLine();
                int intMove = Integer.parseInt(inputMoves);
                // 사람 수만큼 돌게 해야함

                for (int i = 0; i < intMove; i++) {
                        System.out.println(i+1 + "회차");
                        for (Car car : participants) {
                                car.move();
                                System.out.println(car.getName() + " : " + car.getMoveStatus());
                        }
                        System.out.println();
                }
                int maxMove = 0;
                List<String> winner = new ArrayList<>();
                for (Car car : participants) {
//                        maxMove = Math.max(maxMove, car.getMove());   //TODO 질문 왜 이건 안되고
                        int carMove = car.getMove();
                        if (carMove > maxMove) {
                                maxMove = carMove;                      //TODO 얘를 추가하는게 무슨 상관?
                                winner.clear();
                                winner.add(car.getName());
                        } else if (carMove == maxMove) {
                                winner.add(car.getName());
                        }
                }
                System.out.print("최종 우승자 : " + String.join(",",winner));          // 최종우승자 출력


        }
}

// Ming,Seo,Park,Bin,Seong
class Car {
        private String name;
        private int move;

        public Car(String name, int i) {
                this.name = name;
                this.move = 0;
        }

        public String getName() {
                return name;
        }

        public int getMove() {
                return move;
        }

        public String getMoveStatus (){
                return "-".repeat(move);
        }

        public void move() {
                int random = Randoms.pickNumberInRange(1, 9);
                if (random >= 4) {
                        move += 1;
                }
        }
}