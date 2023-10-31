package racingcar.controller;

import racingcar.view.Order;

import java.util.List;

public class PrizingWinners {
    private static final int NO_WINNER = 0;
    private static final int ONE_WINNER = 1;
    private Order order = new Order();
    public void select(List<String> winner) {
        switch (winner.size()){
            case NO_WINNER:
                order.noWinner();
                break;
            case ONE_WINNER:
                person(winner);
                break;
            default:
                people(winner);
        }
    }

    private void people(List<String> winners) {
        for(int person = 0; person < winners.size(); person++){
            if(person != winners.size()-1){
                order.printPeoPle(winners, person);
            }
            else if(person == winners.size()-1){
                order.printLast(winners, person);
            }
        }
    }

    private void person(List<String> winner) {
        order.printLast(winner,0);
    }
}
