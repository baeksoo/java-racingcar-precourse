package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Cars;
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
        Cars cars = Cars.of(names);
        racingView.printInputNumberOfAttempts();
        String round = Console.readLine();
        RacingRound racingRound = RacingRound.of(round);
    }

    private List<String> getNamesByUserInput() {
        String names = Console.readLine();
        return Arrays.asList(names.split(","));
    }
}
