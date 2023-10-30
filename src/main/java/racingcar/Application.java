package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

        public static void main(String[] args) {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                String participantInputName = Console.readLine();
                participantsInput(participantInputName);        // 이름 저장
        }

        public static void participantsInput(String participantInputName) {      //명단 메소드
                List<Car> participants = new ArrayList<>();
                String[] names = participantInputName.split(",");
                for (int i=0;i<names.length;i++){
                        String name = names[i];
                        if (!participants.contains(name)) {
                                participants.add(new Car(name, 0));
                        } else {
                                System.out.println("중복된 이름이 있습니다.");
                                throw new IllegalArgumentException();
                        }
                        validateName(name);
                }
                String participant = String.join(",",names);
                        System.out.print(participant);
        }
        public static Boolean validateName(String name){
                        if (name.length() > 5 || name.length() == 0) {
                                System.out.println("5글자이상의 이름이 있습니다.");
                                System.out.println(name.length());
                                throw new IllegalArgumentException();
                        }       //                                유효성 검사
                return true;
        }
//        public static void attemptInput(String inputMoves) {
//                int move = Integer.parseInt(inputMoves);
//                System.out.println(move + "회차");
//                System.out.println("시도할 회수는 몇회인가요?");
//                String inputMoves = Console.readLine();
//                int intMove = Integer.parseInt(inputMoves);
//                // 사람 수만큼 돌게 해야함
//
//                for (int i = 0; i < intMove; i++) {
//                        System.out.println(i+1 + "회차");
//                        for (Car car : participants) {
//                                car.move();
//                                System.out.println(car.getName() + " : " + car.getMoveStatus());
//                        }
//                        System.out.println();
//                }
//                int maxMove = 0;
//                List<String> winner = new ArrayList<>();
//                for (Car car : participants) {
//                        int carMove = car.getMove();
//                        if (carMove > maxMove) {
//                                maxMove = carMove;
//                                winner.clear();
//                                winner.add(car.getName());
//                        } else if (carMove == maxMove) {
//                                winner.add(car.getName());
//                        }
//                }
//                System.out.print("최종 우승자 : " + String.join(", ",winner));          // 최종우승자 출력
//        }
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
                int random = Randoms.pickNumberInRange(0, 9);
                if (random >= 4) {
                        move += 1;
                }
        }
}