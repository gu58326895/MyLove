package mytest.lang3.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;



public class Video {

	/**
	 * 创建视频缩略图 截取上传视频的某个图片作为视频的缩略图
	 * 
	 * @param fileRealPath
	 *            视频路径
	 * @param imgRealPath
	 *            缩略图路径
	 * @return true 缩略图截取成功 false 缩略图截取失败
	 * @throws InterruptedException
	 */
	public boolean creatImg(String newVideoName, String fileRealPath,
			String imgRealPath) throws InterruptedException {
		try {
			// 调用批处理文件(视频类型转换以及视频缩略图截取)
			Runtime.getRuntime().exec(
					"cmd /c ffmpeg.bat " + fileRealPath + " " + newVideoName
							+ " " + newVideoName + " " + imgRealPath);
			// Runtime.getRuntime().exec("cmd /c ffmpeg.bat "+fileRealPath+
			// " "+imgRealPath);
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * 获取视频总时长
	 * 
	 * @param videoAddress
	 *            要计算总时长的视频地址
	 * @return 视频总时长
	 */
	public long getVideoTime(String videoAddress) {
		String result = processwebM(videoAddress);
		return 123;
	}
	/**
	 * 分析视频，得到包含时长的基础数据 ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
	 * 
	 * @param inputPath
	 *            视频路径
	 * @return
	 */
	private static String processwebM(String inputPath) {
		List<String> commend = new ArrayList<String>();
		commend.add("ffmpeg");
		commend.add("-i");
		commend.add(inputPath);

		try {
			ProcessBuilder builder = new ProcessBuilder();
			builder.command(commend);
			builder.redirectErrorStream(true);
			Process p = builder.start();
			// 保存ffmpeg的输出结果流
			BufferedReader buf = null;
			String line = null;

			buf = new BufferedReader(new InputStreamReader(p.getInputStream()));

			StringBuffer sb = new StringBuffer();
			while ((line = buf.readLine()) != null) {
				System.out.println(line);
				sb.append(line);
				continue;
			}
			int ret = p.waitFor();// 这里线程阻塞，将等待外部转换进程运行成功运行结束后，才往下执行
			return sb.toString();
		} catch (Exception e) {
			// System.out.println(e);
			System.out.println("看看转换有没有问题");
			e.printStackTrace();
			System.out.println(inputPath);
			System.out.println("转换问题检测完毕");
			return null;
		}

	}








}
