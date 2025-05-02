import java.util.Map;
import java.util.HashMap;

// 의상
class _42578 {
    public int solution(String[][] clothes) {
        Map<String, Integer> clothesMap = new HashMap<>();

        for (String[] clothesArr : clothes) {
            String type = clothesArr[1];
            clothesMap.put(type, clothesMap.getOrDefault(type, 0) + 1);
        }

        int answer = 1;
        for (int count : clothesMap.values()) {
            answer*=(count+1); // 의상의 경우의 수 + 해당 의상을 안입을 경우의 수
        }

        answer -= 1; // 아무것도 안입을 경우 제외

        return answer;
    }
}