package cn.program2;

import java.io.IOException;
import java.util.*;
import cn.program2.Logfile;

public class ProductHomework  {
	private static Random random = new Random();
	public static int range;
	
	public static String reductionFraction(int a, int b) {// ����Լ�֣����ڼ�����
		int commonFactor = 1; //������
		int smaller=a>b?b:a;
		      for(int i=1; i<=smaller; i++) {
		       if (a%i==0 && b%i==0) {
		        	 commonFactor=i;      
		       }
		    } 
		int numerator = a/commonFactor; //����
		int denominator = b/commonFactor; //��ĸ
		if(numerator==0) { //�������Ϊ0
		     return "0";
		}
		if(denominator==1) { //�����ĸΪ1
		     return numerator+"";
		} else {
		      return expression(numerator, denominator);
		}
	}
	
	public static String expression(int a, int b) {//�ж��Ƿ�Ϊ�ٷ��������ٷ�����Ϊ������
		  if(a>=b) {
		   int roundNumber=a/b;
		   int newNumerator=a%b;//����
		   if(newNumerator==0) {
		     return roundNumber+"";
		   }
		   if(roundNumber==0){
			  return a + "/" + b;
		   }
		   else return roundNumber + "'" + newNumerator + "/" + b;
	 }
	return a + "/" + b;  
	}
	
	//�жϳ���һ���������ɵ���Ŀ�Ƿ��ظ�
	public static boolean CheckRepetition(Set<String> ExercisesContainer,String s){
		if(ExercisesContainer.contains(s)){
			return true;
		}
		return false;
	}

	public static String[] ProductExercise(int maxSize,int num,String TopicfilePath) {
		//������Ŀ�����Ұ���Ŀд����Ŀ¼��Exercises.txt
		Logfile TopicResult = new Logfile(TopicfilePath, "Exercises");
		String[] results=new String[num];
		Set<String> ExercisesContainer = new HashSet<String>();
		for( int i=0;i<num;i++){ 
			    String exc[]=new String[2];//���ԭ���λ�õ��������ĿΪͬһ�������Ŀ
		        int a= (int) (random.nextInt(maxSize));//����
		    	int b= (int) (random.nextInt(maxSize));//��ĸ
		    	int c= (int) (random.nextInt(maxSize));//��һ������
		    	int d= (int) (random.nextInt(maxSize));//��һ����ĸ
		    	int Symbol=(int) (random.nextInt(4)+1);//������������
		    	if(b!=0&&d!=0){//��ĸ����Ϊ0ʱ���ɴ��з����ļ����⣬ͬʱ������
		    		if(Symbol==1){
		    	  		  if(((a*d-b*c>=0)&&b*d>0)||((a*d-b*c<0)&&b*d<0)){
		    	  			  int numerator=a*d+b*c;
		    	  	    	  int denominator=b*d;
		    	  	    	  exc[0]=expression(a,b)+'+'+expression(c,d)+'=';
		    	  	    	  exc[1]=expression(c,d)+'+'+expression(a,b)+'=';
		    	  	    	  if(false==(CheckRepetition(ExercisesContainer,exc[0]))){
		    	  	    		  //������ɵ���Ŀ�������Ĳ���ͬ�����ɣ����������������������µ���Ŀ
		    	  	    		ExercisesContainer.add(exc[0]);
			    	  	    	ExercisesContainer.add(exc[1]);
			    	  	    	Logfile.addToLog("����������Ŀ"+(i+1)+"��"+exc[0]);
			    	  	    	results[i]=reductionFraction(numerator, denominator);
		    	  	    	  }
		    	  	    	  else{
		    	  	    		  i--;
		    	  	    	  }
		    	  	    	  
		    	  		  }
		    	  		  else{ 
		    	  			i--;
		    	  		  }
		    	  	  }
		    	  	  if(Symbol==2) {
		    	  		  if(((a*d-b*c>=0)&&b*d>0)||((a*d-b*c<0)&&b*d<0)){
		    	  			  int numerator=a*d-b*c;
		    	  	    	  int denominator=b*d;
		    	  	    	  exc[0]=expression(a,b)+'-'+expression(c,d)+'=';
		    	  	    	  exc[1]=expression(c,d)+'+'+expression(a,b)+'=';
		    	  	    	  if(false==(CheckRepetition(ExercisesContainer,exc[0]))){
		    	  	    		  //������ɵ���Ŀ�������Ĳ���ͬ�����ɣ����������������������µ���Ŀ
		    	  	    		ExercisesContainer.add(exc[0]);
			    	  	    	ExercisesContainer.add(exc[1]);
			    	  	    	Logfile.addToLog("����������Ŀ"+(i+1)+"��"+exc[0]);
			    	  	    	results[i]=reductionFraction(numerator, denominator);
		    	  	    	  }
		    	  	    	  else{
		    	  	    		  i--;
		    	  	    	  }
		    	  		  }	
		    	  		  else{
		    	  			i--;
		    	  		  }
		    	  	  }
		    	  	  if(Symbol==3) {
		    	  		  if(((a*d-b*c>=0)&&b*d>0)||((a*d-b*c<0)&&b*d<0)){
		    	  			  int numerator=a*c;
		    	  	    	  int denominator=b*d;
		    	  	    	  exc[0]=expression(a,b)+'��'+expression(c,d)+'=';
		    	  	    	  exc[1]=expression(c,d)+'+'+expression(a,b)+'=';
		    	  	    	  if(false==(CheckRepetition(ExercisesContainer,exc[0]))){
		    	  	    		  //������ɵ���Ŀ�������Ĳ���ͬ�����ɣ����������������������µ���Ŀ
		    	  	    		ExercisesContainer.add(exc[0]);
			    	  	    	ExercisesContainer.add(exc[1]);
			    	  	    	Logfile.addToLog("����������Ŀ"+(i+1)+"��"+exc[0]);
			    	  	    	results[i]=reductionFraction(numerator, denominator);
		    	  	    	  }
		    	  	    	  else{
		    	  	    		  i--;
		    	  	    	  }
		    	  		  }
		    	  		  else{ 
		    	  			i--;
		    	  		  }
		    	  	  }
		    	  	  if(Symbol==4) {
		    	  		  if(((a*d>=0&&b*c>0)||(a*d<0&&b*c<0))&&c!=0){
		    	  			  int numerator=a*d;
		    	  			  int denominator=b*c;
		    	  			  exc[0]=expression(a,b)+'��'+expression(c,d)+'=';
		    	  			  exc[1]=expression(c,d)+'+'+expression(a,b)+'=';
		    	  	    	  if(false==(CheckRepetition(ExercisesContainer,exc[0]))){
		    	  	    		  //������ɵ���Ŀ�������Ĳ���ͬ�����ɣ����������������������µ���Ŀ
		    	  	    		ExercisesContainer.add(exc[0]);
			    	  	    	ExercisesContainer.add(exc[1]);
			    	  	    	Logfile.addToLog("����������Ŀ"+(i+1)+"��"+exc[0]);
			    	  	    	results[i]=reductionFraction(numerator, denominator);
		    	  	    	  }
		    	  	    	  else{
		    	  	    		  i--;
		    	  	    	  }
		    	  		  }
		    	  		  else{
		    	  			  i--;
		    	  		  } 
		    	  	  }	
		    	}
		    	else if(b==0&&d!=0){//�����ĸbΪ0�����b��Ϊ1����a/bֱ��Ϊ����a
		    		b=1;
		    		if(Symbol==1){
		    	  		  if(((a*d-b*c>=0)&&b*d>0)||((a*d-b*c<0)&&b*d<0)){
		    	  			  int numerator=a*d+b*c;
		    	  	    	  int denominator=b*d;
		    	  	    	  exc[0]=expression(a,b)+'+'+expression(c,d)+'=';
		    	  	    	  exc[1]=expression(c,d)+'+'+expression(a,b)+'=';
		    	  	    	  if(false==(CheckRepetition(ExercisesContainer,exc[0]))){
		    	  	    		  //������ɵ���Ŀ�������Ĳ���ͬ�����ɣ����������������������µ���Ŀ
		    	  	    		ExercisesContainer.add(exc[0]);
			    	  	    	ExercisesContainer.add(exc[1]);
			    	  	    	Logfile.addToLog("����������Ŀ"+(i+1)+"��"+exc[0]);
			    	  	    	results[i]=reductionFraction(numerator, denominator);
		    	  	    	  }
		    	  	    	  else{
		    	  	    		  i--;
		    	  	    	  }
		    	  		  }
		    	  		  else{ 
		    	  			i--;
		    	  		  }
		    	  	  }
		    	  	  if(Symbol==2) {
		    	  		  if(((a*d-b*c>=0)&&b*d>0)||((a*d-b*c<0)&&b*d<0)){
		    	  			  int numerator=a*d-b*c;
		    	  	    	  int denominator=b*d;
		    	  	    	  exc[0]=expression(a,b)+'-'+expression(c,d)+'=';
		    	  	    	  exc[1]=expression(c,d)+'+'+expression(a,b)+'=';
		    	  	    	  if(false==(CheckRepetition(ExercisesContainer,exc[0]))){
		    	  	    		  //������ɵ���Ŀ�������Ĳ���ͬ�����ɣ����������������������µ���Ŀ
		    	  	    		ExercisesContainer.add(exc[0]);
			    	  	    	ExercisesContainer.add(exc[1]);
			    	  	    	Logfile.addToLog("����������Ŀ"+(i+1)+"��"+exc[0]);
			    	  	    	results[i]=reductionFraction(numerator, denominator);
		    	  	    	  }
		    	  	    	  else{
		    	  	    		  i--;
		    	  	    	  }
		    	  		  }	
		    	  		  else{
		    	  			i--;
		    	  		  }
		    	  	  }
		    	  	  if(Symbol==3) {
		    	  		  if(((a*d-b*c>=0)&&b*d>0)||((a*d-b*c<0)&&b*d<0)){
		    	  			  int numerator=a*c;
		    	  	    	  int denominator=b*d;
		    	  	    	  exc[0]=expression(a,b)+'��'+expression(c,d)+'=';
		    	  	    	  exc[1]=expression(c,d)+'+'+expression(a,b)+'=';
		    	  	    	  if(false==(CheckRepetition(ExercisesContainer,exc[0]))){
		    	  	    		  //������ɵ���Ŀ�������Ĳ���ͬ�����ɣ����������������������µ���Ŀ
		    	  	    		ExercisesContainer.add(exc[0]);
			    	  	    	ExercisesContainer.add(exc[1]);
			    	  	    	Logfile.addToLog("����������Ŀ"+(i+1)+"��"+exc[0]);
			    	  	    	results[i]=reductionFraction(numerator, denominator);
		    	  	    	  }
		    	  	    	  else{
		    	  	    		  i--;
		    	  	    	  }
		    	  		  }
		    	  		  else{ 
		    	  			i--;
		    	  		  }
		    	  	  }
		    	  	  if(Symbol==4) {
		    	  		  if(((a*d>=0&&b*c>0)||(a*d<0&&b*c<0))&&c!=0){
		    	  			  int numerator=a*d;
		    	  			  int denominator=b*c;
		    	  			  exc[0]=expression(a,b)+'��'+expression(c,d)+'=';
		    	  			  exc[1]=expression(c,d)+'+'+expression(a,b)+'=';
		    	  	    	  if(false==(CheckRepetition(ExercisesContainer,exc[0]))){
		    	  	    		  //������ɵ���Ŀ�������Ĳ���ͬ�����ɣ����������������������µ���Ŀ
		    	  	    		ExercisesContainer.add(exc[0]);
			    	  	    	ExercisesContainer.add(exc[1]);
			    	  	    	Logfile.addToLog("����������Ŀ"+(i+1)+"��"+exc[0]);
			    	  	    	results[i]=reductionFraction(numerator, denominator);
		    	  	    	  }
		    	  	    	  else{
		    	  	    		  i--;
		    	  	    	  }
		    	  		  }
		    	  		  else{
		    	  			  i--;
		    	  		  } 
		    	  	  }	
		    	}
		    	else if(b!=0&&d==0){//�����ĸdΪ0�����d��Ϊ1����c/dֱ��Ϊ����c
		    		d=1;
		    		if(Symbol==1){
		    	  		  if(((a*d-b*c>=0)&&b*d>0)||((a*d-b*c<0)&&b*d<0)){
		    	  			  int numerator=a*d+b*c;
		    	  	    	  int denominator=b*d;
		    	  	    	  exc[0]=expression(a,b)+'+'+expression(c,d)+'=';
		    	  	    	  exc[1]=expression(c,d)+'+'+expression(a,b)+'=';
		    	  	    	  if(false==(CheckRepetition(ExercisesContainer,exc[0]))){
		    	  	    		  //������ɵ���Ŀ�������Ĳ���ͬ�����ɣ����������������������µ���Ŀ
		    	  	    		ExercisesContainer.add(exc[0]);
			    	  	    	ExercisesContainer.add(exc[1]);
			    	  	    	Logfile.addToLog("����������Ŀ"+(i+1)+"��"+exc[0]);
			    	  	    	results[i]=reductionFraction(numerator, denominator);
		    	  	    	  }
		    	  	    	  else{
		    	  	    		  i--;
		    	  	    	  }
		    	  		  }
		    	  		  else{ 
		    	  			i--;
		    	  		  }
		    	  	  }
		    	  	  if(Symbol==2) {
		    	  		  if(((a*d-b*c>=0)&&b*d>0)||((a*d-b*c<0)&&b*d<0)){
		    	  			  int numerator=a*d-b*c;
		    	  	    	  int denominator=b*d;
		    	  	    	  exc[0]=expression(a,b)+'-'+expression(c,d)+'=';
		    	  	    	  exc[1]=expression(c,d)+'+'+expression(a,b)+'=';
		    	  	    	  if(false==(CheckRepetition(ExercisesContainer,exc[0]))){
		    	  	    		  //������ɵ���Ŀ�������Ĳ���ͬ�����ɣ����������������������µ���Ŀ
		    	  	    		ExercisesContainer.add(exc[0]);
			    	  	    	ExercisesContainer.add(exc[1]);
			    	  	    	Logfile.addToLog("����������Ŀ"+(i+1)+"��"+exc[0]);
			    	  	    	results[i]=reductionFraction(numerator, denominator);
		    	  	    	  }
		    	  	    	  else{
		    	  	    		  i--;
		    	  	    	  }
		    	  		  }	
		    	  		  else{
		    	  			i--;
		    	  		  }
		    	  	  }
		    	  	  if(Symbol==3) {
		    	  		  if(((a*d-b*c>=0)&&b*d>0)||((a*d-b*c<0)&&b*d<0)){
		    	  			  int numerator=a*c;
		    	  	    	  int denominator=b*d;
		    	  	    	  exc[0]=expression(a,b)+'��'+expression(c,d)+'=';
		    	  	    	  exc[1]=expression(c,d)+'+'+expression(a,b)+'=';
		    	  	    	  if(false==(CheckRepetition(ExercisesContainer,exc[0]))){
		    	  	    		  //������ɵ���Ŀ�������Ĳ���ͬ�����ɣ����������������������µ���Ŀ
		    	  	    		ExercisesContainer.add(exc[0]);
			    	  	    	ExercisesContainer.add(exc[1]);
			    	  	    	Logfile.addToLog("����������Ŀ"+(i+1)+"��"+exc[0]);
			    	  	    	results[i]=reductionFraction(numerator, denominator);
		    	  	    	  }
		    	  	    	  else{
		    	  	    		  i--;
		    	  	    	  }
		    	  		  }
		    	  		  else{ 
		    	  			i--;
		    	  		  }
		    	  	  }
		    	  	  if(Symbol==4) {
		    	  		  if(((a*d>=0&&b*c>0)||(a*d<0&&b*c<0))&&c!=0){
		    	  			  int numerator=a*d;
		    	  			  int denominator=b*c;
		    	  			  exc[0]=expression(a,b)+'��'+expression(c,d)+'=';
		    	  			  exc[1]=expression(c,d)+'+'+expression(a,b)+'=';
		    	  	    	  if(false==(CheckRepetition(ExercisesContainer,exc[0]))){
		    	  	    		  //������ɵ���Ŀ�������Ĳ���ͬ�����ɣ����������������������µ���Ŀ
		    	  	    		ExercisesContainer.add(exc[0]);
			    	  	    	ExercisesContainer.add(exc[1]);
			    	  	    	Logfile.addToLog("����������Ŀ"+(i+1)+"��"+exc[0]);
			    	  	    	results[i]=reductionFraction(numerator, denominator);
		    	  	    	  }
		    	  	    	  else{
		    	  	    		  i--;
		    	  	    	  }
		    	  		  }
		    	  		  else{
		    	  			  i--;
		    	  		  } 
		    	  	  }	
		    	}
		    	else{//�����ĸbΪ0�����b��Ϊ1����a/bֱ��Ϊ����a;�����ĸdΪ0�����d��Ϊ1����c/dֱ��Ϊ����c
		    		b=1;
		    		d=1;
		    		if(Symbol==1){
		    	  		  if(((a*d-b*c>=0)&&b*d>0)||((a*d-b*c<0)&&b*d<0)){
		    	  			  int numerator=a*d+b*c;
		    	  	    	  int denominator=b*d;
		    	  	    	  exc[0]=expression(a,b)+'+'+expression(c,d)+'=';
		    	  	    	  exc[1]=expression(c,d)+'+'+expression(a,b)+'=';
		    	  	    	  if(false==(CheckRepetition(ExercisesContainer,exc[0]))){
		    	  	    		  //������ɵ���Ŀ�������Ĳ���ͬ�����ɣ����������������������µ���Ŀ
		    	  	    		ExercisesContainer.add(exc[0]);
			    	  	    	ExercisesContainer.add(exc[1]);
			    	  	    	Logfile.addToLog("����������Ŀ"+(i+1)+"��"+exc[0]);
			    	  	    	results[i]=reductionFraction(numerator, denominator);
		    	  	    	  }
		    	  	    	  else{
		    	  	    		  i--;
		    	  	    	  }
		    	  		  }
		    	  		  else{ 
		    	  			i--;
		    	  		  }
		    	  	  }
		    	  	  if(Symbol==2) {
		    	  		  if(((a*d-b*c>=0)&&b*d>0)||((a*d-b*c<0)&&b*d<0)){
		    	  			  int numerator=a*d-b*c;
		    	  	    	  int denominator=b*d;
		    	  	    	  exc[0]=expression(a,b)+'-'+expression(c,d)+'=';
		    	  	      	  exc[1]=expression(c,d)+'+'+expression(a,b)+'=';
		    	  	    	  if(false==(CheckRepetition(ExercisesContainer,exc[0]))){
		    	  	    		  //������ɵ���Ŀ�������Ĳ���ͬ�����ɣ����������������������µ���Ŀ
		    	  	    		ExercisesContainer.add(exc[0]);
			    	  	    	ExercisesContainer.add(exc[1]);
			    	  	    	Logfile.addToLog("����������Ŀ"+(i+1)+"��"+exc[0]);
			    	  	    	results[i]=reductionFraction(numerator, denominator);
		    	  	    	  }
		    	  	    	  else{
		    	  	    		  i--;
		    	  	    	  }
		    	  		  }	
		    	  		  else{
		    	  			i--;
		    	  		  }
		    	  	  }
		    	  	  if(Symbol==3) {
		    	  		  if(((a*d-b*c>=0)&&b*d>0)||((a*d-b*c<0)&&b*d<0)){
		    	  			  int numerator=a*c;
		    	  	    	  int denominator=b*d;
		    	  	    	  exc[0]=expression(a,b)+'��'+expression(c,d)+'=';
		    	  	    	  exc[1]=expression(c,d)+'+'+expression(a,b)+'=';
		    	  	    	  if(false==(CheckRepetition(ExercisesContainer,exc[0]))){
		    	  	    		  //������ɵ���Ŀ�������Ĳ���ͬ�����ɣ����������������������µ���Ŀ
		    	  	    		ExercisesContainer.add(exc[0]);
			    	  	    	ExercisesContainer.add(exc[1]);
			    	  	    	Logfile.addToLog("����������Ŀ"+(i+1)+"��"+exc[0]);
			    	  	    	results[i]=reductionFraction(numerator, denominator);
		    	  	    	  }
		    	  	    	  else{
		    	  	    		  i--;
		    	  	    	  }
		    	  		  }
		    	  		  else{ 
		    	  			i--;
		    	  		  }
		    	  	  }
		    	  	  if(Symbol==4) {
		    	  		  if(((a*d>=0&&b*c>0)||(a*d<0&&b*c<0))&&c!=0){
		    	  			  int numerator=a*d;
		    	  			  int denominator=b*c;
		    	  			  exc[0]=expression(a,b)+'��'+expression(c,d)+'=';
		    	  			  exc[1]=expression(c,d)+'+'+expression(a,b)+'=';
		    	  	    	  if(false==(CheckRepetition(ExercisesContainer,exc[0]))){
		    	  	    		  //������ɵ���Ŀ�������Ĳ���ͬ�����ɣ����������������������µ���Ŀ
		    	  	    		ExercisesContainer.add(exc[0]);
			    	  	    	ExercisesContainer.add(exc[1]);
			    	  	    	Logfile.addToLog("����������Ŀ"+(i+1)+"��"+exc[0]);
			    	  	    	results[i]=reductionFraction(numerator, denominator);
		    	  	    	  }
		    	  	    	  else{
		    	  	    		  i--;
		    	  	    	  }
		    	  		  }
		    	  		  else{
		    	  			  i--;
		    	  		  } 
		    	  	  }	
		    	}
		}
		return results;
	}
	
	public static boolean IsInt(String str){//�ж��ַ����ܷ�ת��Ϊint��
		try{
			Integer.valueOf(str);
			return true;
		}catch(Exception e){
			return false;
		}	
		
	}
		
    public static void main(String[] args) throws IOException{
    	String maxSizeString; // ��ֵ��������ֵ�ַ���
		String numString; // ��Ҫ������Ŀ�ĸ����ַ���
		String[] parms; // ���ܲ���

		if (args.length != 0) {
			parms = args;
		} else {
			System.out.println("��������Ŀ����ֵ��������ֵ(��ʽ��-r ��Χ)����������Ҫ������Ŀ�ĸ���(��ʽ��-n ����)(����֮�䶺�Ÿ���)");
			Scanner scanner = new Scanner(System.in);
			parms = scanner.nextLine().split(",");
			if (parms.length < 2) {
				System.out.println("��������ݲ�����Ҫ������������Ŷ(`-w-`)");
				System.exit(0);
			}
			scanner.close();
		}

		maxSizeString = parms[0]; 
		numString=parms[1];
    	
        String str1 = maxSizeString.substring(3);
        String str2 = numString.substring(3);
        int maxSize=0; 
        int num=0;
        if(true==IsInt(str1)){
    	    maxSize=Integer.parseInt(str1);
        }
        else{
    	    System.out.println("С������������Ŀ��Χ�ĸ�ʽ��������������(`-w-`)");
        }
        if(true==IsInt(str2)){
    	    num=Integer.parseInt(str2);
        } 
        else{
    	    System.out.println("С������������Ŀ�����ĸ�ʽ��������������(`-w-`)");
        }

        String ResultfilePath="C://Users//HASEE//workspace//Arithmetic//src//cn//program2";
        String TopicfilePath="C://Users//HASEE//workspace//Arithmetic//src//cn//program2";
        String GradefilePath="C://Users//HASEE//workspace//Arithmetic//src//cn//program2";
	    String[] results=ProductExercise(maxSize,num,TopicfilePath);
	    Logfile logResult = new Logfile(ResultfilePath, "Answers");
	    for(int i=0;i<num;i++){
		    logResult.addToLog("��"+(i+1)+"��"+results[i]);
		    System.out.println("��"+(i+1)+"��"+results[i]);
	    }
      }
   }

