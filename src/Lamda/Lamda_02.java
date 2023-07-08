package Lamda;

import java.util.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Lamda_02 {

    /**
     * 함수형 인터페이스 사용
     *   함수 디스크립터 -함수형 인터페이스의 추상 메서드 시그니처
     *                -자바 API는 Predicate, Consumer, Function 등 다양한 함수형 인터페이스를 포함한다.
     *       Predicate: test라는 추상메서드를 정의하여 test에서는 제너릭 형식 T의 객체를 인수로 받아 불리언을 반환한다.(T형식의 객체를 사용하는 불리언 표현식이 필요한 상황에서 사용)
     *       Consumer : accept라는  추상메서드를 정의하여 제너릭 형식 T 객체를 받아서 void를 반환한다.
     *       Function : apply라는 제너릭 형식 T를 인수로 받아 제너릭 R 객체를 반환한다.
     *
     *        대상형식 - 람다 표현식의 기대형식
     *
     *        형식추론 - 자바 컴파일러는 대상형식을 이용해서 함수 디스크립터를 알 수 있어, 람다의 시그니처도 추론할수 있다.
     *
     * 지역변수에서 사용 - 외부에 final 형식으로 선언된 변수에 람다표현식으로 값을 담는 '람다캡처링'을 할 수 있다.
     *
     *      메서드 참조 -기존의 정적 메서드 정의를 재활용해서 람다처럼 전달 할 수 있다.
     *                 명시적으로 메서드명을 참조함으로써 가독성을 높일 수 있다.
     *                 (Apple a)-> a.getWeight()  == Apple::getWeight
     *
     *      생성자 참조 - ClassName::new 처럼 클래스명과 new 키워드를 이용해서 기존 생성자의 참조를 만들 수 있다.
     *
     */
    public static void main(String[] args) {
        /**
         *  sample 1. 익명클래스와 람다표현식의 사용
         */

        Predicate predicate;
        Consumer consumer;
        Function function;

        Comparator<Apple> c =
                (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()); // 형식을 추론하지 않음

        Comparator<Apple> c2 =
                (a1, a2) -> a1.getWeight().compareTo(a2.getWeight());             // 형식을 추론함

        final int portNum = 1337;
        Runnable r = ()-> System.out.println(portNum);                            // 람다 캡처링

        List<String> str = Arrays.asList("a","b","A","B");
        str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));

        List<String> str2 = Arrays.asList("a","b","A","B");
        str2.sort(String::compareToIgnoreCase);



    }

    public class Apple {
        String weight;
        String color;

        public String  getWeight() {
            return weight;
        }

        public String getColor() {
            return color;
        }


    }
}
