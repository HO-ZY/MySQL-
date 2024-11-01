public class Test2 {

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        System.out.println(test2.solution(15958)); // 1958
        System.out.println(test2.solution(-5859)); // -589
        System.out.println(test2.solution(5005));  // 505
        
    }

    //関数solutionを記述してください。引数に整数Nが与えられる。
    //整数Nに出現する'5'を一つ削除して得られる、最大数を返してください。
    //Nには最低一つ以上'5'が含まれることが保証されます。
    public int solution(int N) {
        //Nを文字列に変換
        String numberStr = Integer.toString(N);
        int maxNumber = Integer.MIN_VALUE;

        for (int i = 0; i < numberStr.length(); i++) {
            if (numberStr.charAt(i) == '5') {
                String newNumberStr = numberStr.substring(0, i) + numberStr.substring(i + 1);
                int newNumber = Integer.parseInt(newNumberStr);
                maxNumber = Math.max(maxNumber, newNumber);
            }
        }

        return maxNumber;
    }
    
}
