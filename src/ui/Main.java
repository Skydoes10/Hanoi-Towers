package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	public static int m;
	public static int n;
	public static int tower1;
	public static int tower2;
	public static int tower3;

	public static int[] cases;
	public static int[] index = new int[3];
	public static String out = "";
	

	public static void main(String[] args) {
		try {
			inputData("input.txt");
			hanoiTowers();
			outputData("output.txt");
		} catch (IOException e) {
			System.err.println("File not found");
			e.printStackTrace();
		}
	}
	
	public static void hanoiTowers() {
		for(int i = 0; i < cases.length; i++) {
			tower1 = 0;
			tower2 = 1;
			tower3 = 2;
			index[0] = cases[i];
			index[1] = 0;
			index[2] = 0;
			
			out += show() + "\n";
			hanoi(cases[i], tower1, tower2, tower3);
			out += show() + "\n\n";
		}
	}
	
	public static void hanoi(int n, int start, int end, int aux) {
		if(n > 0) {
			index[start]--;
			index[aux]++;
		}else {
			hanoi(n-1, start, aux, end);
			show();
			index[start]--;
			index[end]++;
			show();
			hanoi(n-1, aux, end, start);
			show();
		}
	}
	
	public static String show() {
		return index[0]+" "+index[1]+" "+index[2];
	}
	
	public static void inputData(String address) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(address));
		m = Integer.parseInt(br.readLine());
		cases = new int[m];
		for(int i = 0; i < m; i++) {
			n = Integer.parseInt(br.readLine());
			cases[i]= n;
		}
		br.close();
	}
	
	public static void outputData(String address) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(address));
		bw.write(out);
		bw.close();
	}
}
