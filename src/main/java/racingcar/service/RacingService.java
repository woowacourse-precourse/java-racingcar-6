package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Racer;
import racingcar.repository.MemoryRacerRepository;
import racingcar.repository.RacerRepository;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingService {
    private final RacerRepository racerRepository = new MemoryRacerRepository();

    public void join(String name){
        Racer racer = new Racer();
        racer.setRacerName(name);
        racerRepository.findByName(racer.getRacerName())
                .ifPresent(m -> {
                    throw  new IllegalStateException("이미 존재하는 회원");
                });
        racerRepository.save(racer);
    }
    public void roundMove(String name){
        Racer currRacer = racerRepository.findByName(name).get();
        int moving = Randoms.pickNumberInRange(0,9);
        if(moving >= 4){
            racerRepository.setMoveByName(currRacer.getRacerName());
        }
    }

    public int roundResult(String name){
        return racerRepository.getMoveByName(name);
    }

    public List<Integer> getFinalDistances(List<String> racerNames){
        List<Integer> racerDistances = racerNames.stream()
                .map(name -> racerRepository.getMoveByName(name)) // processName은 이름을 정수로 변환하는 메소드
                .collect(Collectors.toCollection(ArrayList::new));

        return racerDistances;
    }

    public List<String> selectWinner(List<String> racerNames){
        List<Integer> racerDistances = getFinalDistances(racerNames);

        int max = IntStream.range(0, racerDistances.size())
                .reduce((i, j) -> racerDistances.get(i) >= racerDistances.get(j) ? i : j)
                .orElse(-1);

        List<Integer> maxIndexes = IntStream.range(0, racerDistances.size())
                .filter(i -> racerDistances.get(i) == racerDistances.get(max))
                .boxed()
                .toList();

        List<String> winnerRacers = IntStream.range(0, maxIndexes.size())
                .filter(i -> maxIndexes.get(i) >= 0 && maxIndexes.get(i) < racerNames.size())
                .mapToObj(i -> racerNames.get(maxIndexes.get(i)))
                .collect(Collectors.toList());

        return winnerRacers;
    }
}
