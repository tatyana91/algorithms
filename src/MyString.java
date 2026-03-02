public class MyString {
    //O(N) | O(1)
    boolean isUnique(String str) {
        if (str.length() > 95) return false;
        boolean[] chars = new boolean[95];
        for (int i = 0; i < str.length(); i++) {
            int code = str.charAt(i) - 32;
            if (chars[code]) return false;
            chars[code] = true;
        }
        return true;
    }

    //O(N) | O(1)
    int countLatinWords(String str) {
        int count = 0;
        boolean latin = true;
        for (int i = 0; i < str.length(); i++) {
            int code = str.charAt(i);

            if (code == ' ') {
                if (latin) count++;
                latin = true;
            }
            else if ((code < 'A' || code > 'Z') && (code < 'a' || code > 'z')){
                latin = false;
            }
        }

        if (latin) count++;
        return count;
    }

    //O(N) | O(N)
    String raplaceSpaces(String str) {
        int countSpaces = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == ' ') countSpaces++;
        }
        char[] resArr = new char[str.length() + countSpaces * 2];
        int freeIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                resArr[freeIndex] = '%';
                resArr[freeIndex+1] = '2';
                resArr[freeIndex+2] = '0';
                freeIndex += 3;
            }
            else {
                resArr[freeIndex] = str.charAt(i);
                freeIndex += 1;
            }
        }
        return new String(resArr);
    }

    //O(N) | O(1)
    boolean isPermutation(String s1, String s2){
        if (s1.length() != s2.length()) return false;
        int uniqueLettersCount = 26;
        int[] countLetters = new int[uniqueLettersCount];
        for (int i = 0; i < s1.length(); i++) {
            countLetters[s1.charAt(i) - 'a']++;
            countLetters[s2.charAt(i - 'a')]--;
        }
        for(int i = 0; i < s1.length(); i++){
            if (countLetters[i] != 0) return false;
        }
        return true;
    }

    //O(N) | O(1)
    boolean isIsomorphic(String s1, String s2){
        int[] numS1 = new int[95];
        int[] numS2 = new int[95];

        for (int i = 0; i < s1.length(); i++){
            int letterS1 = s1.charAt(i) - 32;
            int letterS2 = s2.charAt(i) - 32;

            if (numS1[letterS1] != numS2[letterS2])  return false;

            numS1[letterS1] = i + 1;
            numS2[letterS2] = i + 1;
        }

        return true;
    }

    //O(A*B) | O(1)
    int getIndexSubStr(String s1, String s2) {
        if (s1.length() > s2.length()) return -1;
        
        for (int L = 0; L <= s1.length() - s2.length(); L++){
            int S = 0;
            while(S < s2.length()) {
                if (s2.charAt(S) != s1.charAt(L+S)) break;
                S++;
            }
            if (S == s2.length()) return L;
        }
        return -1;
    }
}
