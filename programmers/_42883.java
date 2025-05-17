import java.util.Stack;

class _42883 {
    public String solution(String number, int k) {
        char[] result = new char[number.length() - k];

        Stack<Character> stack = new Stack<>();
        for (char digit : number.toCharArray()) {
            // 스택의 마지막 숫자보다 현재 숫자가 크고, k가 남아있다면 제거
            while (!stack.isEmpty() && stack.peek() < digit && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(digit); // 현재 숫자를 스택에 추가
        }

        // 문자열로 변환
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }

        String answer = new String(result);
        return answer;
    }
}