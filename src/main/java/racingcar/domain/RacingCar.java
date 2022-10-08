package racingcar.domain;

public class RacingCar {
    private final CarName name;

    private RacingCar(CarName name) {
        this.name = name;
    }

    public CarName getName() {
        return name;
    }

    public static RacingCar of(String name) {
        return new RacingCar(CarName.of(name));
    }
}
