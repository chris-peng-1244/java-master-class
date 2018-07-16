package com.chrispeng.section15;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ExampleMain {
	public static void main(String[] args) {
		try {
			int result = divide();
			System.out.println(result);
		} catch (ArithmeticException | NoSuchElementException e) {
			System.out.println(e.toString());
			System.out.println("Unable to perform division");
		}
	}

	private static int divide() {
//		try {
			int x = getInt();
			int y = getInt();
			System.out.format("x is %d, y is %d%n", x, y);
			return x / y;
//		} catch (NoSuchElementException e) {
//			throw new NoSuchElementException("No suitable input");
//		} catch (ArithmeticException e) {
//			throw new ArithmeticException("Attempt to divide by zero");
//		}
	}

	private static int getInt() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter an integer");
		while (true) {
			try {
				return scanner.nextInt();
			} catch (InputMismatchException e) {
				// Go round again. Read past the end of line in the input first
				scanner.nextLine();
				System.out.println("Please enter a number using only 0-9");
			}
		}
	}
}
