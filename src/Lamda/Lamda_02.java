package Lamda;

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
     */
    public static void main(String[] args) {
        /**
         *  sample 1. 익명클래스와 람다표현식의 사용
         */

        Predicate predicate;
        Consumer consumer;
        Function function;

    }
}
