package racingcar.domain;

public class RacingCar {
    private final String name;

    private RacingCar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static RacingCar of(String name) {
        validateLength(name);
        return new RacingCar(name);
    }

    private static void validateLength(String name) {
        if (!(name.length() >= 1 && name.length() <= 5)) {
            throw new IllegalArgumentException("[ERROR] 차량명은 1글자 이상, 5글자 이하가 되어야합니다");
        }
    }
}
