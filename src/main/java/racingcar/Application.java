package racingcar;

import camp.nextstep.edu.missionutils.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String command = Console.readLine();
        String[] cars = command.split(",");
        int[] result = new int[cars.length];
        int size = cars.length;
        int max = 0;

        for (String car: cars) {
            if(car.length() > 5){
                System.out.println("ERROR");
            }
        }

        System.out.println("시도할 회수는 몇회인가요?");
        command = Console.readLine().trim();
        int number = 0;

        try {
            number = Integer.parseInt(command);
            System.out.println("입력한 숫자는 " + number + "입니다.");
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다. 정수를 입력해주세요.");
        }

        for(int k = 0; k < number; k++){
            for(int i = 0; i < size; i++){
                int rndNum = Randoms.pickNumberInRange(0,9);
                if(rndNum > 4) {
                   result[i] += 1;
                   if(result[i] > max){
                       max = result[i];
                   }
                }
            }
            for (int j = 0; j < size; j++) {
                System.out.println(cars[j] + " : " + "-".repeat(result[j]));
            }
            System.out.println();
        }

        System.out.print("최종 우승자 : ");
        boolean multiple = false;
        for(int l = 0; l < size; l++){
            if(result[l] == max && !multiple){
                System.out.print(cars[l]);
                multiple = true;
            }
            else if(result[l] == max && multiple){
                System.out.println(", " + cars[l]);
            }

        }


    }
}
