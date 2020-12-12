package works;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Sixteenth {
	public static void main(String args[]) {
		File fRead = new File("score.txt");
		File fWrite = new File("socreAnalysis.txt");
		try {
			Writer out = new FileWriter(fWrite, true);
			// 以尾加方式创建指向文件fWrite的out流
			BufferedWriter bufferWrite = new BufferedWriter(out);
			// 创建指向out的bufferWrite流

			Reader in = new FileReader(fRead);// 创建指向文件fRead的in流
			BufferedReader bufferRead = new BufferedReader(in);// 创建指向in的bufferRead流

			String str = null;
			while ((str = bufferRead.readLine()) != null) {
				double totalScore = Fenxi.getTotalScore(str);
				str = str + " 总分:" + totalScore;
				System.out.println(str);
				bufferWrite.write(str);
				bufferWrite.newLine();
			}
			bufferRead.close();
			bufferWrite.close();
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}
}

class Fenxi {
public static double getTotalScore(String s) {
	Scanner scanner = new Scanner(s);
	scanner.useDelimiter("[^0123456789.]+");
	double totalScore=0;
	while(scanner.hasNext()){ 
    try{
    	  double score = scanner.nextDouble();
    	  totalScore = totalScore+score;
    	  }        
    catch(InputMismatchException exp){
    	  String t = scanner.next();
    	  }
      } 
	return totalScore;
	} 
}

