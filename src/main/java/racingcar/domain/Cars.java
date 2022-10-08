package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<String> names) {
        validateCarsCount(names);
        validateCarDuplication(names);
        List<Car> cars = new ArrayList<>();
        for (String name: names) {
            cars.add(Car.of(name));
        }
        return new Cars(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    private static void validateCarDuplication(List<String> names) {
        Set<String> nameSet = new HashSet<>(names);
        if (names.size() != nameSet.size()) {
            throw new IllegalArgumentException("[ERROR] 동일한 이름의 차량을 등록할 수 없습니다");
        }
    }

    private static void validateCarsCount(List<String> names) {
        if (names.size() <= 1) {
            throw new IllegalArgumentException("[ERROR] 차량을 1대이하로 등록할 수 없습니다");
        }
    }
}
