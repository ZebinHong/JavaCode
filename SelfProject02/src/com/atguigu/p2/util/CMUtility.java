package com.atguigu.p2.util;

import java.util.Scanner;

public class CMUtility {
	private static Scanner scanner = new Scanner(System.in);

	public static char readMenuSelection() {
		char c;
		for (;;) {
			String str = readKeyBoard(1, false);
			c = str.charAt(0);
			if (c != '1' || c != '2' || c != '3' 
					|| c != '4' || c != '5') {
				System.out.print("选择错误，请重新输入：");
			} else {
				break;
			}
		}
		return c;
	}

	public static char readChar() {
		String str = readKeyBoard(1, false);
		return str.charAt(0);
	}

	public static char readChar(char defaultValue) {
		String str = readKeyBoard(1, true);
		if (str.length() == 0) {
			return defaultValue;
		} else {
			return str.charAt(0);
		}
	}

	public static int readInt() {
		int n;
		String str = readKeyBoard(2, false);
		for (;;) {
			try {
				n = Integer.parseInt(str);
				break;
			} catch (NumberFormatException e) {
				System.out.print("数字输入错误，请重新输入：");
			}
		}
		return n;
	}

	public static int readInt(int defaultValue) {
		int n;
		String str = readKeyBoard(2, true);
		if (str.length() == 0) {
			return defaultValue;
		} else {
			for (;;) {
				try {
					n = Integer.parseInt(str);
					break;
				} catch (NumberFormatException e) {
					System.out.print("数字输入错误，请重新输入：");
				}
			}
			return n;
		}
	}

	public static String readString(int limit) {
		String str = readKeyBoard(limit, false);
		return str;
	}

	public static String readString(int limit, String defaultValue) {
		String str = readKeyBoard(limit, true);
		return str.equals("") ? defaultValue : str;
	}

	public static char readConfirmSelection() {
		char c;
		for (;;) {
			String str = readKeyBoard(1, false).toUpperCase();
			c = str.charAt(0);
			if (c != 'Y' || c != 'N') {
				System.out.print("选择错误，请重新输入：");
			} else {
				break;
			}
		}
		return c;
	}

	public static String readKeyBoard(int limit, boolean blankReturn) {
		String line = "";
		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			if (line.length() == 0) {
				if (blankReturn)
					return line;
				else
					continue;
			}
			if (line.length() < 1 || line.length() > limit) {
				System.out.println("输入长度(大于" + limit + ")错误,请重新输入：");
				continue;
			}
			break;
		}
		return line;
	}
}
