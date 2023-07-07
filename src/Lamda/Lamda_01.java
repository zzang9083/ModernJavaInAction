package Lamda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Lamda_01 {


    /**
     *
     * 람다 표현식 - (메소드로 전달할 수 있는 익명 함수를 단순화한 것)
     *           - 이름은 없지만 파라미터 리스트, 바디, 반환 형식, 발생할 수 있는 예외 리스트를 가질 수 있다.
     *           - 람다 표현식은 파라미터, 화살표, 바디로 이뤄진다.
     *             (ex) (Apple a1, Apple a2) ->     a.getWeight().compareTo(a2.getWeight());
     *                        람다 파라미터    화살표   바디
     *                  (parmeters) -> expression    : 표현식 스타일
     *                  (parmeters) -> { statments } :  블록 스타일
     *
     * 함수형 인터페이스 - ("오직 하나의 추상 메서드를 지정"하는 "인터페이스"이다.)
     *                - '람다 표현식'으로 함수형 인터페이스의 추상 메서드 구현을 직접 전달(구현)할 수 있으므로 전체 표현식을
     *                  함수형 인터페이스의 인스턴스(함수형 인터페이스를 구현한 클래스의 인스턴스)로 취급 할 수 있다.
     */
    public static void main(String[] args) throws IOException {

        /**
         *  sample 1. 익명클래스와 람다표현식의 사용
         */
        Runnable r1 = new Runnable() { // 익명클래스 사용
            @Override
            public void run() {
                System.out.println("hello world1");
            }
        };

        Runnable r2 = () -> System.out.println("hello world 2"); // 람다 표현식

        process(r1); // hello world1 ->익명클래스로 process로 들어가는 파라미터를 표현
        process(r2); // hello world2 ->람다표현식을 process로 들어가는 파라미터로 넘김
        process(() -> System.out.println("hello world 3")); // hello world3 -> 람다표현식를 파라미터로 직접 사용


        /**
         *  sample 2. 람다 활용 : 실행 어라운드 패턴 - 실제 자원을 처리하는 코드를 '설정'과 '정리' 두 과정으로  둘러싼 형태의 패턴
         */

        //sample 2-2
        String oneLine = processFile((BufferedReader br) -> br.readLine()); // process를 br.readLine()로 람다표현식
        String twoLine = processFile((BufferedReader br) -> br.readLine()+br.readLine()); // process를 br.readLine()로 정의



    }

    public static void process(Runnable r) {
        r.run();
    }


    //sample 2-1. 일반적인 함수로 표현
    public static String processFile()  throws IOException {
        try(BufferedReader br
                    = new BufferedReader(new FileReader("data.txt"))) {
            return br.readLine(); // 실제 필요한 작업을 하는 행이다.
        }
    }

    // sample 2-2. 함수형 인터페이스를 이용하여 동작전달
    @FunctionalInterface
    public interface BufferReaderProcessor {
        String process(BufferedReader b) throws IOException;
    }

    //sample 2-2. 함수형 인터페이스를 인자로 이용하여 동작 전달
    public static String processFile(BufferReaderProcessor p)  throws IOException {
        try(BufferedReader br
                    = new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br); // BufferedReader 객체 처리
        }
    }


}
