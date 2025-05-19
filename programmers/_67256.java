// 키패드 누르기
class _67256 {
    int[][] numpad = {
            {3,1}, //0
            {0,0}, //1
            {0,1}, //2
            {0,2}, //3
            {1,0}, //4
            {1,1}, //5
            {1,2}, //6
            {2,0}, //7
            {2,1}, //8
            {2,2}  //9
    };
    public int[] getPosition(int num) {
        return numpad[num];
    }
    public int getDistance(int[] from, int[] to) {
        return Math.abs(from[0] - to[0]) + Math.abs(from[1] - to[1]);
    }
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int[] left = {3,0};
        int[] right = {3,2};
        boolean isLeftHanded = hand.equals("left");

        for(int num: numbers) {
            if (num==1 || num==4 || num==7) {
                left = getPosition(num);
                sb.append("L");
            } else if (num==3 || num==6 || num==9) {
                right = getPosition(num);
                sb.append("R");
            } else {
                int[] position = getPosition(num);
                int leftDist = getDistance(left, position);
                int rightDist = getDistance(right, position);
                if (leftDist < rightDist || (leftDist == rightDist && isLeftHanded)) {
                    left = position;
                    sb.append("L");
                } else {
                    right = position;
                    sb.append("R");
                }
            }
        }

        String answer = sb.toString();
        return answer;
    }
}