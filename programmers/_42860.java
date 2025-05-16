class _42860 {
    public int solution(String name) {
        int len = name.length();
        int answer = 0;
        int move = len - 1;

        for (int i = 0; i < len; i++) {
            // ▲▼ 조작 (알파벳 변경)
            char ch = name.charAt(i);
            answer += Math.min(ch - 'A', 'Z' - ch + 1);

            // 좌우 이동 최소값 갱신
            int next = i + 1;
            while (next < len && name.charAt(next) == 'A') {
                next++;
            }

            move = Math.min(move, i + len - next + Math.min(i, len - next));
        }

        answer += move;
        return answer;
    }
}