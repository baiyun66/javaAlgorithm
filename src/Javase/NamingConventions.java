package Javase;

/*
一：命名规范
1、项目名全部小写
2、包名全部小写
    在新建一个包项目时可能会涉及到多层设计，每层的包名要遵循包名全部小写的规范

3、类名的命名要遵循首字母大写原则，类的名字必须由大写字母开头而单词中的其他字母均为小写；
如果一个类名称是由多个单词组成，则每个单词的首字母均应为大写例如ModelWhAction；
如果类名称中包含单词缩写，则这个所写词的每个字母均应大写，如：XMLExample,还有一点命名技巧就是由于类是设计用来代表对象的，所以在命名类时应尽量选择名词。　　

4、变量的命名要遵循通俗易懂的原则，比如名字就用 name ，而不是用a、b、c这样的命名。变量命名除了变量名外，实例，包括类、类常量，均采用大小写混合的方式，
第一个单词的首字母小写，其后单词的首字母大写。变量名不应以下划线或美元符号开头，尽管这在语法上是允许的。但是在工作中这样做会降低代码的可阅读性，在工作上这是不规范的。(小驼峰)

5、方法的名字的第一个单词应以小写字母作为开头，后面的单词则用大写字母开头。(小驼峰)
6、需要用到的变量命名和方法命名要遵循首字母小写原则，如果名称是由多个单词组成，每个单词的首字母都要大写（除首个单词）。
   如：public void toString(){}


8、常量命名时需要遵循名称全部大写的原则。（常量：MAX_VALUE）


9、所有命名规则必须遵循以下规则：
    1)、名称只能由字母、数字、下划线、$符号组成

    2)、命名时不能以数字开头

    3)、在命名是绝对不能出现Java关键字。

    4)、绝对不允许在命名时出现中文及拼音命名。

 */

// 类名 大驼峰
public class NamingConventions {

    public static void main(String[] args) {
        // 变量名字小驼峰
        int[] testArray = new int[5];

    }

    // 方法名小驼峰
    public void testFunction(){
        // 常量全部大写
        final int MAX_VALUE = 10;

    }
}
