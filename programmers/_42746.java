import java.util.*;

class _42746 {
    public String solution(int[] numbers) {
        // int[] -> String[]
        String[] stringNumbers = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        // 내림차순 정렬
        Arrays.sort(stringNumbers, (a, b) -> (b + a).compareTo(a + b));

        // 문자열 이어붙이기
        String answer = String.join("", stringNumbers);

        // 0일 경우
        if (answer.startsWith("0"))
            answer = "0";

        return answer;
    }
}