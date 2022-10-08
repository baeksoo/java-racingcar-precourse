package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingRound;
import racingcar.view.RacingView;

public class RacingCarController {
    private final RacingView racingView;

    public RacingCarController(RacingView racingView) {
        this.racingView = racingView;
    }

    public void doRacing() {
        racingView.printInputCarNames();
        List<String> names = getNamesByUserInput();
        RacingCars racingCars = RacingCars.of(names);
        racingView.printInputNumberOfAttempts();
        String round = Console.readLine();
        RacingRound racingRound = RacingRound.of(round);
    }

    private List<String> getNamesByUserInput() {
        String names = Console.readLine();
        return Arrays.asList(names.split(","));
    }
}
