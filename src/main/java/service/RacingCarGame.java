package service;

import controller.Controller;

import java.util.Arrays;

import static repository.RandomNumber.pickRandomNumber;

public class RacingCarGame {
    public void start() {
        Controller controller = new Controller();
        String[] carNameList = controller.getCarNameList();
        final int ROUND = controller.getRound();

        printResult(carNameList, ROUND);
    }

    private boolean canCarMoveForward(int number) {
        final int MIN_FORWARD_COUNT = 4;

        return number >= MIN_FORWARD_COUNT;
    }

    private void printResult(String[] carNameList, int round) {
        System.out.println("실행 결과");

        final int CAR_NAME_LENGTH = carNameList.length;

        int[] forwardCounts = new int[CAR_NAME_LENGTH];
        StringBuilder sb = new StringBuilder();

        for (int i = round; i > 0; i--) {
            getResult(carNameList, CAR_NAME_LENGTH, forwardCounts, sb, i);
        }

        System.out.print(sb);
        printWinner(carNameList, forwardCounts, CAR_NAME_LENGTH);
    }

    private void printWinner(String[] carNameList, int[] forwardCounts, int carNameLength) {
        StringBuilder sb = new StringBuilder();
        final int MAX = Arrays.stream(forwardCounts).max().getAsInt();

        for (int i = 0; i < carNameLength; i++) {
            if (forwardCounts[i] == MAX) sb.append(carNameList[i] + ", ");
        }

        System.out.print("최종 우승자 : " + sb.substring(0, sb.length() - 2));
    }

    private void getResult(String[] carNameList, int carNameLength, int[] forwardCounts, StringBuilder sb, int i) {
        for (int j = 0; j < carNameLength; j++) {
            if (canCarMoveForward(pickRandomNumber())) {
                forwardCounts[j]++;
            }
        }

        for (int k = 0; k < carNameLength; k++) {
            sb.append(carNameList[k])
                    .append(" : ")
                    .append("-".repeat(forwardCounts[k]))
                    .append("\n");
        }

        if (i > 1) sb.append("\n");
    }
}

