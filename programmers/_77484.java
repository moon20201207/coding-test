// 로또의 최고 순위와 최저 순위
import java.util.Set;
import java.util.Arrays;
import java.util.stream.Collectors;

class _77484 {
    int[] ranks = {
            6, // 0
            6, // 1
            5, // 2
            4, // 3
            3, // 4
            2, // 5
            1, // 6
    };
    public int getRank(int winCnt) {
        return ranks[winCnt];
    }
    public int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> winList = Arrays.stream(win_nums).boxed().collect(Collectors.toSet());
        int match = 0;
        int zeros = 0;
        for (int lotto : lottos) {
            if (winList.contains(lotto)) {
                match++;
            } else if (lotto == 0){
                zeros++; // 낙서
            }
        }

        int[] answer = {getRank(match+zeros), getRank(match)};
        return answer;
    }
}