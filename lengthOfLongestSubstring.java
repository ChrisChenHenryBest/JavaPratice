import java.util.ArrayList;
import java.util.List;
/*
 * 查出任意字符串中不含有重复字符的最长子串的长度
 * 例如：输入“abcabcbb”，输出“abc”，长度为3。
 */
public class lengthOfLongestSubstring {

    public static void main(String[] args) {
        String str = "abcdbcbb";
        // 将字符串转换为字符数组
        List<Character> charList = new ArrayList<>();
        for(char c: str.toCharArray()) {
            charList.add(c);
        }
        System.out.println(charList);
        
        // 创建一个临时的字符列表，用于存储当前的子串
        List<Character> tmpCharList = new ArrayList<>();
        // 创建一个变量，用于存储最长子串的长度
        int maxLength = 0;
        // 遍历字符列表
        for (int i = 0; i < charList.size(); i++) {
            // 如果当前字符已经在临时列表中，说明出现了重复字符
            if (tmpCharList.contains(charList.get(i))) {
                // 找到重复字符的位置
                int index = tmpCharList.indexOf(charList.get(i));
                // 从临时列表中删除重复字符之前的所有字符
                for (int j = 0; j <= index; j++) {
                    tmpCharList.remove(0);
                }
            }
            // 将当前字符添加到临时列表中
            tmpCharList.add(charList.get(i));
            // 更新最长子串的长度
            maxLength = Math.max(maxLength, tmpCharList.size());
            // 打印当前的临时列表和最长子串长度
            System.out.println("Current substring: " + tmpCharList + ", Length: " + maxLength);
            // 如果当前字符是最后一个字符，说明已经遍历完了所有字符
            if (i == charList.size() - 1) {
                // 打印最长子串的长度
                System.out.println("Length of longest substring without repeating characters: " + maxLength);
            }
        }
    }
}