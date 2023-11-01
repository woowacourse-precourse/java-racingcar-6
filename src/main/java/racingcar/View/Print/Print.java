package racingcar.View.Print;

import java.util.List;
import racingcar.PlayGame.FindWinner;
import racingcar.player.User;
import racingcar.player.UserList;

public class Print {
    public void Result(List<User> user) {

        for (int i = 0; i < user.size(); i++) {
            String dashes = changeFrowardCharacter(user.get(i));
            System.out.print(user.get(i).getUserName() + " " + ":" + " ");
            System.out.println(dashes);
        }


    }

    private static String changeFrowardCharacter(User user) {
        String dashes = "";
        for (int j = 0; j <= user.getForwardDistance(); j++) {
            dashes += "-";
        }
        return dashes;
    }

    public void FinalWinner(List<User> user) {
        FindWinner findWinner = new FindWinner();

        List<String> maxScoreUserNames = findWinner.findWinner(user);

        String result = "";

        if (maxScoreUserNames.size() == 1) {
            result = "최종 우승자 : " + maxScoreUserNames.get(0);
        }

        if (maxScoreUserNames.size() != 1) {
            result = "최종 우승자 : " + String.join(", ", maxScoreUserNames);
        }

        System.out.println(result);

    }

}
