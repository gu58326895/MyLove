package mytest.lang3.test;



/**
 * Created by darcy on 2016/3/9.
 */
public class Main {

    public static void main(String[] args) {

        Video video = new Video ();


        long time  =video.getVideoTime("D:\\code\\webPlayer\\target\\webPlayer\\attached\\media\\20160309134808_926.mp4");

        System.out.println(time);
    }
}
