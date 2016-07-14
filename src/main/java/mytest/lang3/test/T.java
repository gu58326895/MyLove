package mytest.lang3.test;
public class T  implements Cloneable{
    public static int k = 0;
    public static T t1 = new T("t1");
    public static T t2 = new T("t2");
    public static int i = print("i");
    public static int n = 99;

    public int j = print("j");
    {print("构造快");}

    static {print("静态块");}

    public T(String str) {
        System.out.println((++k) + ":" + str + "    i=" + i + "  n=" + n);
        ++n; ++ i;
    }

    public static int print(String str){
        System.out.println(   (++k) +  ":" + str + "   i=" + i + "   n=" + n    );
        ++n;
        return ++ i;
    }

    public static void main(String[] args){
        T t = new T("init");
    }
}
