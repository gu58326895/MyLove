package net.gxl.Utils;

/**
 * Created by guxiaoli on 30/08/2017.
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.darcytech.model.Student;
import com.darcytech.model.Teacher;

public class MyUtil {

    private MyUtil() {
        throw new AssertionError();
    }

    public static <T> T clone(T obj) throws Exception {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bout);
        oos.writeObject(obj);

        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bin);
        return (T) ois.readObject();

        // 说明：调用ByteArrayInputStream或ByteArrayOutputStream对象的close方法没有任何意义
        // 这两个基于内存的流只要垃圾回收器清理对象就能够释放资源，这一点不同于对外部资源（如文件流）的释放
    }

    public static void main(String[] args) throws Exception {
        Student student = new Student();
        student.setName("gu");
        Teacher teacher = new Teacher();
        teacher.setStudent(student);
        teacher.setName("gu");


        Teacher cloneTeacher = MyUtil.clone(teacher);

        cloneTeacher.getStudent().setName("feng");

        System.out.println(teacher.getStudent().getName());
        System.out.println(cloneTeacher.getStudent().getName());


    }
}