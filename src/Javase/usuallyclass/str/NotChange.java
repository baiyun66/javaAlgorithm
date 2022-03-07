package Javase.usuallyclass.str;

public class NotChange {
    public static void main(String[] args) {
        NotChange notChange = new NotChange();
        notChange.change(notChange.str,notChange.chs);
        System.out.printf("%s\n", notChange.str);
        System.out.printf("%s",new String(notChange.chs));


    }

    String str = new String("good");
    char [] chs = {'g','o','o','d'};

    public void change(String str, char[] chs){
        str = "bad";
        chs[0] = 'h';
    }
}
