package service;

import view.InputView;

public class Round {
    public static Integer setRound() {
        String rounds = InputView.setTryNumber();
        return Integer.parseInt(rounds);
    }
}
