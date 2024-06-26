# [Bronze V] 개수 세기 - 10807 

[문제 링크](https://www.acmicpc.net/problem/10807) 

### 성능 요약

메모리: 14280 KB, 시간: 132 ms

### 분류

구현 / HashMap

### 제출 일자

2024년 6월 26일 18:19:48

### 문제 설명

<p>총 N개의 정수가 주어졌을 때, 정수 v가 몇 개인지 구하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫째 줄에 정수의 개수 N(1 ≤ N ≤ 100)이 주어진다. 둘째 줄에는 정수가 공백으로 구분되어져있다. 셋째 줄에는 찾으려고 하는 정수 v가 주어진다. 입력으로 주어지는 정수와 v는 -100보다 크거나 같으며, 100보다 작거나 같다.</p>

### 출력 

 <p>첫째 줄에 입력으로 주어진 N개의 정수 중에 v가 몇 개인지 출력한다.</p>

---

## 참고
### StringTokenizer란
- 자바에서 문자열을 특정 구분자(delimiter)를 기준으로 분리할 때 사용하는 클래스
    - 구분자를 기준으로 문자열을 토큰(token)으로 나누는 기능을 제공
- `java.util` 패키지에 포함되어 있음
- `StringTokenizer`는 기본적으로 공백 문자(스페이스, 탭, 줄바꿈 등)를 구분자로 사용하지만, 사용자 정의 구분자를 사용할 수도 있음

### nextToken()란
- `StringTokenizer` 객체에서 다음 토큰을 반환하는 메소드
- 다음 토큰을 반환하며, 토큰이 더 이상 없을 경우 `NoSuchElementException` 예외를 던질 수 있음
```java
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        String inputString = "1 4 1 2 4 2 4 2 3 4 4";
        StringTokenizer tokenizer = new StringTokenizer(inputString);

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            System.out.println(token);
        }
    }
}
```
