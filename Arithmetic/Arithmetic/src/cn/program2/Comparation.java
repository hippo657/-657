package cn.program2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import cn.program2.Logfile;

public class Comparation {
	private static void readFile(File StudentAnswers,File Answers,String Gradepath) throws IOException {
//    	����׼����ѧ���𰸶Աȣ�����Grade.txt
	   FileInputStream san = new FileInputStream(StudentAnswers);
	   FileInputStream an = new FileInputStream(Answers);
	   BufferedReader brStudent = new BufferedReader(new InputStreamReader(san));
	   BufferedReader br2 = new BufferedReader(new InputStreamReader(an));
	    
	   Collection<Integer> Correctlist=new ArrayList<>();
       Collection<Integer> Wronglist=new ArrayList<>();
	   String lineStudent = null;
	   String line = null;
	   int CorrectCount=0; 
	   int WrongCount=0;
	   int count=0;
	   while (((lineStudent = brStudent.readLine()) != null)&&((line = br2.readLine()) != null)) {
		    if(lineStudent.equals(line)){
			   CorrectCount++;
			   count++;
			   Correctlist.add(count);
		    }
		    else {
		    	WrongCount++;
			    count++;
			    Wronglist.add(count);
		    }
	   }
	 
	   Logfile logGrade = new Logfile(Gradepath, "Grade");
	   Logfile.addToLog("Correct��"+CorrectCount+" "+Correctlist.toString());
	   Logfile.addToLog("Wrong��"+WrongCount+" "+Wronglist.toString());
	   brStudent.close();
	   san.close();
	   br2.close();
	   an.close();  
   }
	public static void main(String[] args) throws IOException {
		String AnswerPath; // ��׼��·��
		String StudentAnswerPath; // ѧ����·��
		String GradePath; // �÷��ļ�����·��
		String[] parms; // ���ܲ���

		if (args.length != 0) {
			parms = args;
		} else {
			System.out.println("�������׼��·������Ĵ𰸾���·��������÷��ļ��ľ���·��(����֮��ո��������ʽ����E:\\xxx\\xxx.txt)");
			Scanner scanner = new Scanner(System.in);
			parms = scanner.nextLine().split(" ");
			
			if (parms.length < 3) {
				System.out.println("��������ݲ�����Ҫ�����������룡");
				System.exit(0);
			}
			scanner.close();
		}

		AnswerPath = parms[0]; 
		StudentAnswerPath=parms[1];
		GradePath = parms[2];
		
		File file1 = new File(AnswerPath);
		File file2 = new File(StudentAnswerPath);
//		C://Users//HASEE//workspace//Arithmetic//src//cn//program2//Answers.txt
//		C://Users//HASEE//workspace//Arithmetic//src//cn//program2//StudentAnswers.txt
//		C://Users/HASEE//workspace//Arithmetic//src//cn//program2
		
		readFile(file1,file2,parms[2]);
			
	}
}
