package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RacingCarsTest {

    @ParameterizedTest
    @MethodSource("getDuplicateNames")
    @DisplayName("차량의 이름들중 중복이 있을 경우 에러가 발생된다")
    void 차량의_이름들중_중복이_있을_경우_에러가_발생된다(List<String> carNames) {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> RacingCars.of(carNames))
                .withMessage("[ERROR] 동일한 이름의 차량을 등록할 수 없습니다");
    }

    @ParameterizedTest
    @MethodSource("getOnlyOneName")
    @DisplayName("차량의 이름이 1개 이하일 경우 에러가 발생된다")
    void 차량의_이름이_1개_이하일_경우_에러가_발생된다(List<String> carNames) {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> RacingCars.of(carNames))
                .withMessage("[ERROR] 차량을 1대이하로 등록할 수 없습니다");
    }

    private static List<Arguments> getDuplicateNames() {
        List<Arguments> arguments = new ArrayList<>();
        arguments.add(arguments(Arrays.asList("aa", "aa")));
        arguments.add(arguments(Arrays.asList("aa", "bb", "aa")));
        arguments.add(arguments(Arrays.asList("cc", "ca", "ab", "aa", "cc")));
        return arguments;
    }

    private static List<Arguments> getOnlyOneName() {
        List<Arguments> arguments = new ArrayList<>();
        arguments.add(arguments(Collections.singletonList("aa")));
        arguments.add(arguments(Collections.singletonList("bb")));
        arguments.add(arguments(Collections.singletonList("cc")));
        return arguments;
    }
}