package leetcode.codeLisit200.binary;

public class MaxProduct {
    public int maxProduct(String[] words) {
        int wordsLen = words.length;
        int[] masks = new int[wordsLen];

        for (int i = 0; i < wordsLen; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                masks[i] |= 1<<(words[i].charAt(j)-'a');
            }
        }
        int res = 0;
        for (int i = 0; i < wordsLen; i++) {
            for (int j = i; j < wordsLen; j++) {
                res = (masks[i]&masks[j])==0 ? Math.max(res,words[i].length()*words[j].length()):res;
            }
        }

        return res;

    }

    public static void main(String[] args) {
       String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
       MaxProduct maxProduct = new MaxProduct();

        System.out.println(maxProduct.maxProduct(words));
    }
}
