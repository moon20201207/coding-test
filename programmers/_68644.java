// 두 개 뽑아서 더하기
import java.util.HashSet;
import java.util.Set;

class _68644 {
    public int[] solution(int[] numbers) {
        int[] answer = {};

        Set<Integer> set = new HashSet<>();
        int len = numbers.length;
        for (int i=0; i<len; i++) {
            for(int j=i+1; j<len; j++) {
                set.add(numbers[i]+numbers[j]);
            }
        }

        answer = set.stream().mapToInt(Integer::intValue).sorted().toArray();

        return answer;
    }
}