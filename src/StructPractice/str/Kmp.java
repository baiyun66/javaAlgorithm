package structpractice.str;

public class Kmp {
    public static void main(String[] args) {



        String str1 = "mississippi";
        String str2 = "issip";
        KMPTest kmp = new KMPTest();
        int[] nextArray = kmp.next(str2);
        for (int j = 0; j < nextArray.length; j++) {
            System.out.printf("%d ",nextArray[j]);
        }
        int index = kmp.strIndex(str1,str2,nextArray);
        System.out.printf("位置为:%d\n",index);

    }

    static class KMPTest {
        // 部分匹配值
        // 第一步，获取str2的部分匹配值 [0,0,0,0,1,2,0]
        public int[] next(String dist) {
            int[] nextArray = new int[dist.length()];
            if (dist.length() == 1) {
                nextArray[0] = 0;
            }
//            for (int i = 1; i < dist.length(); i++) {
//                String str = dist.substring(0, i + 1);
//                    System.out.printf("原始str: %s \n",str);
//                for (int j = 1; j < i + 1; j++) {
//                        System.out.printf("%s ? %s\n",str.substring(0,j),str.substring(i+1-j,i+1));
//                    if (str.substring(0, j).equals(str.substring(i + 1 - j, i + 1))) {
//                        nextArray[i] = j;
//                    }
//                }
//            }
            for (int i = 1, j = 0; i < dist.length(); i++) {
                System.out.printf("上%d:%c? 下%d:%c\n",i,dist.charAt(i),j,dist.charAt(j));
                while (j > 0 && dist.charAt(i) != dist.charAt(j)) {
                    j =nextArray[j - 1];
                }
                if (dist.charAt(i) == dist.charAt(j)) {
                    j++;
                }
                nextArray[i] = j;
            }

            return nextArray;
        }

        // 根据部分匹配值，开始计算
        // "mississippi";
        //     "issip";
        // 0 0 0 0 1 2 0

        public int strIndex(String str,String dist,int [] nextArray){
            int len = dist.length();
            int i = 0;
            int j =0;
            while (j<len && i<str.length()){
                System.out.printf("匹配到 %d - %d\n",i,j);
                if(j>0 && str.charAt(i)!=dist.charAt(j)){
                    j= nextArray[j-1];
                }else if(str.charAt(i)==dist.charAt(j)){
                    j++;
                    if(j==len){
                       return i-len+1;
                    }
                    i++;
                }else {
                    i++;
                }

            }
            return -1;
        }


    }
}


