package output;

import java.util.List;

public interface OutputInterface {
    void printInputMsg();
    void printTryNumMsg();
    void printResultMsg();
    void printCarName(String carName);
    void printRunMsg(int count);
    void printWinnerMsg(List<String> winner);

}
