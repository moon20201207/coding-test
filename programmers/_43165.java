// 타겟 넘버
class _43165 {
    public int dfs(int[] nums, int index, int state, int target) {
        // 종료 조건: 배열의 끝에 도달했을 때
        if (index == nums.length) {
            if (state == target) return 1; // 타겟 넘버가 됐을 때
            else return 0;
        }

        // 분기: 다음 숫자를 더하거나 빼기
        int add = dfs(nums, index + 1, state + nums[index], target);
        int sub = dfs(nums, index + 1, state - nums[index], target);

        // 결과 누적
        return add + sub;
    }

    public int solution(int[] numbers, int target) {
        int answer = dfs(numbers, 0, 0, target);

        return answer;
    }
}