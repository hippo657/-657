package checking_MoJR;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PaperRechecking {
    public static void main(String[] args) throws IOException {
	    PaperRechecking paper=new PaperRechecking();	
	    String filename="D:\\软件工程个人项目\\test\\orig.txt";
	    Set<String> textwords=paper.split(filename);
	    List<String> copywords=new ArrayList<String>();
	    @SuppressWarnings("resource")
	    Scanner scanner=new Scanner(System.in);
	    System.out.println("请输入抄袭版论文的路径:");
	    String copypath=scanner.nextLine();
	    
	    Set<String> set=paper.split(copypath); //分词
	    Iterator<String> iterator = set.iterator();  
	    while (iterator.hasNext()) { 
	    	String str = iterator.next();  
	    	copywords.add(str);
	    }
	    PaperRechecking.rechecking(textwords, copywords, copypath);
    }
   
    
    public List<String> extract(String line) {
	    List<String> result=new ArrayList<String>();
	    Pattern pattern=Pattern.compile("([\u4e00-\u9fa5]+)"); //判断字符串中是否包含中文
	    Matcher matcher=pattern.matcher(line);
	    while(matcher.find()) {
		    result.add(matcher.group());
	    }
	    return result;
    }
   
    
	public List<String> read(String filename) {
		List<String> list = new ArrayList<String>();
		BufferedReader buff = null;
		try {
			buff = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
			String line = null;
			Set<String> set = new HashSet<String>();
			while (null != (line = buff.readLine())) {
				List<String> pointList = extract(line);
				set.addAll(pointList);
			}
			list.addAll(set);
			Collections.sort(list);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != buff) {
				try {
					buff.close();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					buff = null;
				}
			}
		}
		return list;
	}
	
   
	public Set<String> split(String filename) {
		PaperRechecking paperRechecking = new PaperRechecking();
		List<String> result = paperRechecking.read(filename);
		Set<String> include_set = new HashSet<String>();
		String words = "";
		for (String s : result) {
			for (int i=0; i<s.length(); i++) {
				words = String.valueOf(s.charAt(i));
				if (include_set.contains(words) == false) {
					include_set.add(words);
				}
			}
		}
		return include_set;
	}
   
   
	public static void rechecking(Set<String> textwords, List<String> copywords, String copypath) throws IOException {
		int copynum = copywords.size(); //抄袭版论文的分词数
		int num = 0; //两篇文章分词相似数
		for (int i=0; i<copynum-1; i++) {
			if (textwords.contains(copywords.get(i)) == true) {
				num++;
			}
		}
		float rate = (float) num / (float) copynum; 
		System.out.println("orig.txt与" + copypath + "的查重率为：" + rate);
	}
}
