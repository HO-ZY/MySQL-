public class Test3 {
    public static void main(String[] args) {

        //solutionをテストする。
        Test3 test1 = new Test3();
        System.out.println(test1.solution("39878"));//expected 898
        System.out.println(test1.solution("00900"));//expected 9
        System.out.println(test1.solution("0000"));//expected 0
        System.out.println(test1.solution("54321"));//expected 5

    }

    // N桁の文字列Sが与えられたとき、もっとも大きな値を持つ回文数を表す文字列を返す関数を作成してください。
    // 文字列Sは10進数表記で、Nは[1..100,000]の範囲の整数です。
    public String solution(String S) {
        int[] counts = new int[10];
        for (char c : S.toCharArray()) {
            counts[c - '0']++;
        }

        StringBuilder leftHalf = new StringBuilder();

        // Build the left half without leading zeros
        for (int d = 9; d >= 1; d--) {
            int pairs = counts[d] / 2;
            for (int i = 0; i < pairs; i++) {
                leftHalf.append((char) (d + '0'));
            }
        }

        // If leftHalf is not empty, we can add zeros
        if (leftHalf.length() > 0) {
            int zeroPairs = counts[0] / 2;
            for (int i = 0; i < zeroPairs; i++) {
                leftHalf.append('0');
            }
        }

        // Find the central digit
        String centralDigit = "";
        for (int d = 9; d >= 0; d--) {
            if (counts[d] % 2 == 1) {
                centralDigit = String.valueOf(d);
                break;
            }
        }

        // Build the palindrome
        StringBuilder palindrome = new StringBuilder();
        palindrome.append(leftHalf);

        if (!centralDigit.isEmpty()) {
            palindrome.append(centralDigit);
        }

        palindrome.append(leftHalf.reverse());

        // Remove leading zeros if the palindrome is not "0"
        String result = palindrome.toString();
        result = result.replaceFirst("^0+(?!$)", "");

        if (result.isEmpty()) {
            return "0";
        }

        return result;
    }
    
}
