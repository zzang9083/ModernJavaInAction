package Stream;

import java.util.*;
import java.util.stream.Collectors;

import static Stream.Dish.menu;
import static java.util.stream.Collectors.toList;


public class Stream_02 {
    /**
     * 스트림 활용 : 스트림 인터페이스의 다양한 메서드들을 알아본다.
     * =====================================================================================================================================
     * =====================================================================================================================================
     * filter -
     *        프리데케이트로 필터링 : filter 메서드는 프레디케이트(불리언 반환 함수)를 인수로 받아서 프레디케이트와 일치하는 모든 요소를 포함하는 스트림을 반환한다.
     *        고유 요소 필터링 : distinct 메서드로 고유요소리 이루어진 스트림 반환
     *
     * 스트림슬라이싱 -
     *        스트림의 요소를 선택하거나 스킵하는 다양한 방법을 설명한다.
     *        takeWhile : 람다 표현식 조건까지 반복
     *        dropWhile : 람다 표현식의 나머지 요소들을 추출
     *
     * 스트림 축소 -
     *        스트림은 주어진 값 이하의 크기를 갖는 새로운 스트림은 반환한다.(정렬을 전제로 최대 n개 반환을 목적)
     *
     * 스트림 요소 건너뛰기 -
     *        처음 n개의 요소를 제외한 스트림을 반환
     *
     * =====================================================================================================================================
     * =====================================================================================================================================
     * 매핑 - 특정 객체에서 특정 데이터를 선택하는 작업 수행
     *
     * map 메서드 -
     *        함수에 적용한 결과가 새로운 요소로 매핑된다.
     *
     * flatMap 메서드 -
     *        생성되는 스트림을 하나의 스트림으로 평면화
     *
     * =====================================================================================================================================
     * =====================================================================================================================================
     * 검색과 매칭 - 특정 속성이 데이터 집합에 있는지 여부를 검색하는 데이터 처리(boolean return)
     *         allMatch : 모든 요소가 일치하는가
     *         anyMatch : 적어도 한 요소와 일치하는가
     *         noneMatch: 일치하는 요소가 없는지 확인
     *         findAny  : 임의의 요소를 반환(return Optional)
     *         findFirst: 첫번째 요소 반환
     * =====================================================================================================================================
     * =====================================================================================================================================
     * 리듀싱 - 모든 스트림 요소를 처리해서 값으로 도출한다.
     * */
    public static void main(String[] args) {

        //채식요리 필터링
        List<Dish> vegetarianMenu = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(toList());

        //고유 요소 필터링
        List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);

        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 12, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("beep", true, 400, Dish.Type.OTHER));

        //리미트
        List<Dish> dishes = specialMenu.stream()
                                        .filter(dish -> dish.getCalories() > 300)
                                        .limit(3)
                                        .collect(toList());

        //스트림 요소 건너뛰기
        List<Dish> dishes2 = menu.stream()
                                .filter(d->d.getCalories() > 300)
                                .skip(2)
                                .collect(toList());


        //각 요소에 함수 적용하기
        List<String> dishNames = menu.stream()
                                        .map(Dish::getName) // to Stream<String>
                                        .collect(toList());

        //flatMap
        List<String> words = new ArrayList<>();
        words.add("hello");
        words.add("world");

        words.stream()
                .map(word-> word.split(""))
                .map(Arrays::stream) //  "hello"/"world" 문자열배열에 대한 스트림 생성
                .distinct()
                .collect(toList());


        List<String>  uniqueCharacters =
                words.stream()
                        .map(word -> word.split(""))
                        .flatMap(Arrays::stream) // 생선된 스트림을 하나의 스트림으로 평면화
                        .distinct()
                        .collect(toList());


        List<Integer> numbers2 = new ArrayList<Integer>(Arrays.asList(1,2,3,4));

        //전체합
        int sum = numbers2.stream().reduce(0,(a, b) -> a+b); // 초기값 0에 numbers에 있는 값들을 더한다.

        //전체곱
        int product = numbers2.stream().reduce(1,(a, b) -> a*b); // 초기값 1에 numers에 있는 값들을 곱한다.

        //최대값
        Optional<Integer> max = numbers2.stream().reduce(Integer::max); // 최대값 추출

        //최소값
        Optional<Integer> min = numbers2.stream().reduce(Integer::min); // 최대값 추출

    }




}
