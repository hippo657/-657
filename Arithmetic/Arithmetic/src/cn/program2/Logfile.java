package cn.program2;

import java.io.BufferedWriter;  
import java.io.File;  
import java.io.FileWriter;  
import java.io.IOException;  
  
public class Logfile {  
    //��־����·��  
    private String filePath = null;  
    //��־����  
    private String fileName = null;  
      
    private static BufferedWriter bw;  
      
    private File logFile;  
       
    //��־�����Ƿ���  
    public static boolean state = false;  
      
    public Logfile(String filePath,String fileName){  
        this.filePath = filePath;  
        this.fileName = fileName;  
        logFile = new File(filePath,fileName+".txt");  
        start();  
        this.state = true;  
    }  
      
    private void start(){  
        try {  
            bw = new BufferedWriter(new FileWriter(logFile));  
            //System.out.println("��־�����ɹ�");  
        } catch (IOException e) {  
            System.out.println("��־����ʧ�ܣ�����ָ��Ŀ¼���ļ����Ƿ���ȷ");  
        }  
    }  
    /**
     * д����־��Ϣ��Ϊ�˱�֤�ļ���Ϣ��ȷ����Ҫͬ�� 
     * ������־�����������д����Ϣ 
     */  
    public static synchronized void addToLog(String info){  
        if(state)  
        {  
            try {  
                bw.write(info);  
                bw.newLine();  
                bw.flush();  
            } catch (IOException e) {  
                System.out.println("��Ϣ¼��ʧ��");  
            }  
        }  
    }  
}  