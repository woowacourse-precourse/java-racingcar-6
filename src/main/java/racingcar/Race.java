package racingcar;

import camp.nextstep.edu.missionutils.Console;

final class Race {
    public String[] carArray;
    public int tryNumber;
    public int[] raceAccumulations;

    public Race(String[] carArray, int tryNumber, int[] raceAccumulations) {
        this.carArray = carArray;
        this.tryNumber = tryNumber;
        this.raceAccumulations = raceAccumulations;

    }

    public static Race initializeRaceInformation() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carInput = Console.readLine();
        String[] carArray = carInput.split(",");
        checkNameError(carArray);
        System.out.println("시도할 회수는 몇회인가요?");
        int tryNumber = Integer.parseInt(Console.readLine());
        int[] raceAccumulations = new int[carArray.length];
        return new Race(carArray, tryNumber, raceAccumulations);
    }

    private static void checkNameError(String[] carArray) {
        for (String carName : carArray) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("5자를 넘는 이름을 입력하셨습니다. 오류 발생");
            }
            if (carName.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름으로 공백 값을 입력하셨습니다. 오류 발생");
            }
        }
    }
}
