import java.util.Arrays;

public class Test4 {
    public static void main(String[] args) {
        Test4 test4 = new Test4();
        System.out.println(test4.solution(new int[] { 4, 6, 2, 2, 6, 6, 1 })); // 4
        
    }

    int solution(int[] A) {
        int N = A.length;
        int result = 0;
        int size = N * 2; // ハッシュマップのサイズを2倍にして衝突を減らす
        int[] keys = new int[size];
        int[] values = new int[size];
        Arrays.fill(keys, Integer.MIN_VALUE); // 空のスロットを示す特別な値

        for (int i = 0; i < N; i++) {
            int key = A[i];
            int hash = key & 0x7fffffff; // 非負のハッシュコードを取得
            int index = hash % size;

            while (keys[index] != Integer.MIN_VALUE && keys[index] != key) {
                index = (index + 1) % size; // 線形探査
            }

            if (keys[index] == Integer.MIN_VALUE) {
                // 新しいキーを挿入
                keys[index] = key;
                values[index] = i;
            } else {
                // 既存のキーの場合、結果を更新
                int firstIndex = values[index];
                result = Math.max(result, i - firstIndex);
            }
        }

        return result;
    }
    
}
