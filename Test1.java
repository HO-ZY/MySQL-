import java.util.HashMap;
import java.util.Map;

public class Test1 {

    public static void main(String[] args) {
            
            //solutionをテストする。
            Test1 test1 = new Test1();
            System.out.println(test1.solution("acbcbba"));
            //0
            System.out.println(test1.solution("axxaxa"));
            //1
            System.out.println(test1.solution("aaaa"));
            
        
    }

    //各文字が偶数個含まれる単語を「偶単語」と呼ぶことにする。
    //N文字で構成される文字列Sが与えられ、Sから文字数削除することにより「偶単語」を作成しようとして時、
    //最小で何文字削除すれば「偶単語」が作れるか出力する関数solutionを作成してください。
    //S="acbcbba"の場合、"abccba"を作成することで「偶単語」を作成できるため、1を返す。
    //S="axxaxa"の場合、"xx"を削除することで「偶単語」を作成できるため、2を返す。
    //S="aaaa"の場合、"aa"を削除することで「偶単語」を作成できるため、0を返す。
    public int solution(String S) {
        // 各文字の出現回数を記録する
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : S.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        int oddCount = 0;
        // 奇数回出現する文字の数を数える
        for (int count : charCount.values()) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }

        // 偶単語を作るためには、奇数回出現する文字をすべて偶数にする必要がある
        // 奇数回出現する文字の数そのものが削除対象の文字数に対応する
        return oddCount;
    }
    
}
