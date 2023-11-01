package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        int numberOfCars = 3;

        String[] carNames = new String[numberOfCars];


            System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n ");
            String getcarNames = Console.readLine();
            carNames = getcarNames.split("\\s*,\\s*");
        
            for (String name : carNames) {
                System.out.println(name);
            }
            for (int i=0; i<carNames.length; i++) {
                try {
                    Validate.validateInput(carNames[i]);
                } catch (IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                    break;
                }
            }

        System.out.print("시도할 회수는 몇회인가요?\n ");
        int numberOfMoves = Integer.parseInt(Console.readLine());
        
        int[] carPositions = new int[numberOfCars];
        
        for (int move = 0; move < numberOfMoves; move++) {
            for (int car = 0; car < numberOfCars; car++) {
                int randomValue = GenerateRandomeNumber.generateNumber();
                if (randomValue >= 4) {
                    carPositions[car]++;
                    
                }
            }
        }

        System.out.println("실행 결과\n");

        for (int move = 0; move < numberOfMoves; move++) {
            for (int car = 0; car < numberOfCars; car++) {
                int randomValue = GenerateRandomeNumber.generateNumber();
                if (randomValue >= 4) {
                    carPositions[car]++;
                }
            }

            for (int car = 0; car < numberOfCars; car++) {
                String positionIndicator = new String(new char[carPositions[car]]).replace('\0', '-');
                System.out.println(carNames[car] + " : " + positionIndicator);
            }
            System.out.println(" ");
        }

        int maxPosition = -1;
        for (int car = 0; car < numberOfCars; car++) {
            if (carPositions[car] > maxPosition) {
                maxPosition = carPositions[car];
            }
        }

        StringBuilder winners = new StringBuilder();
        for (int car = 0; car < numberOfCars; car++) {
            if (carPositions[car] == maxPosition) {
                if (winners.length() > 0) {
                    winners.append(", ");
                }
                winners.append(carNames[car]);
            }
        }
        
        System.out.println("최종 우승자 : " + winners);
    }
}
