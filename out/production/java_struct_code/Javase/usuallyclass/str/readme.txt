1.不可变性
    不同的初始化String str =
        new String(str)  是在对象的堆空间开辟新的字符数组
        = "str"  指向的是常量池的一个地址，该常量不能变化，只能产生新的常量，赋值给str
2.常用的方法

3.转换
    String -->  int/float/double/bool
        Integer.parseInt(str)
    other --> String
        String.valueOf()

    charArray --> String
        new String()
    String --> charArray
        toCharArray


    string --> bytes
        str.getBytes("utf-8")  //gbk  utf8中文3字节  gbk英文2字节

    bytes --> String
        new String()    // 注意编码格式

4.
    String 不可变的字符序列
    StringBuffer 可变 线程安全,实现了线程的同步，效率低
    StringBuilder 可变 效率高

    后两个使用同一个父类 实现可变的是存储的charArray数组可变,*2+2

    基本方法：增加append,删除：delete，改变replace,substring,查找chartAt,setCharAt

