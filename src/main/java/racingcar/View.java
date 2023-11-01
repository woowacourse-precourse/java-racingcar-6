package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class View {
    String[] getNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String names = camp.nextstep.edu.missionutils.Console.readLine();
        String[] splitNames = names.split(",");
        for (String splitName : splitNames) {
            if (splitName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
        return splitNames;
    }

    int times() {
        System.out.println("시도할 횟수는 몇회인가요?");
        String tempTime = camp.nextstep.edu.missionutils.Console.readLine();
        char[] charArrayTime = tempTime.toCharArray();
        for (char c : charArrayTime) {
            if (c < '0' || c > '9') {
                throw new IllegalArgumentException();
            }
        }
        return Integer.parseInt(tempTime);
    }

    void printResult(Car[] cars, int numOfCars) {
        System.out.println("실행 결과");
        for (int i = 0; i < numOfCars; i++) {
            System.out.print(cars[i].name + " : ");
            for (int j = 0; j < cars[i].count; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }
    //자동차 이름 출력 후, '-'을 '어딘가'에 저장된 횟 수만큼 출력.
    void printFinalResult(Car[] cars, int numOfCars) {
        for(int i = 0; i < numOfCars; i++){
            for(int j = i; j < numOfCars; j++){
                if(cars[i].count < cars[j].count) {
                    Car tempCar = cars[i];
                    cars[i] = cars[j];
                    cars[j] = tempCar;
                }
            }
        }
        System.out.print("최종 우승자 : " + cars[0].name);
        int i = 1;
        while(cars[i].count == cars[0].count){
            System.out.print(", " + cars[i].name);
            ++i;
        }
    }
    //퀵소트(안되면 버블정렬이라도...)이용해서 카운트가 큰 순서대로 자동차 정렬. 먼저 입력된 이름이 앞에 있도록 클 때에만 순서 변경.
    //정렬 후, 가장 큰 카운트의 자동차 이름만 출력.
}
