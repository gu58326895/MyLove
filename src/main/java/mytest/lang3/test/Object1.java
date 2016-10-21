package mytest.lang3.test;

/**
 * Created by GXL on 2016/9/29.
 */
public class Object1 {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Object1)obj).name == this.name;
    }
}
