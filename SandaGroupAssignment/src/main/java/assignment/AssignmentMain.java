package assignment;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

public class AssignmentMain {
	
	static void substraction2DArray(int a[][], int b[][]) {
	
		int row = a.length, col = a[0].length;

		int[][] temp = new int[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {

				temp[i][j] = a[i][j] - b[i][j];
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {

				System.out.print(" " + temp[i][j]);
			}
			System.out.println();
		}
		System.out.println("********************************************");
	}

	static void hardwareInformation() {

		SystemInfo systemInfo = new SystemInfo();

		HardwareAbstractionLayer hal = systemInfo.getHardware();
		OperatingSystem os = systemInfo.getOperatingSystem();
		System.out.println(hal.getComputerSystem() + " " + os);
		System.out.println("********************************************");

	}

	public static void main(String[] args) {

		BasicConfigurator.configure();

		int[][] a = { { 4, 5, 6 }, { 3, 4, 1 }, { 1, 2, 3 } };
		int[][] b = { { 2, 0, 3 }, { 2, 3, 1 }, { 1, 1, 1 } };
		substraction2DArray(a, b);
		hardwareInformation();
		WriteEncryptedTextToFile.writeEncyptedTextFile();
		WriteEncryptedTextToFile.readEncryptedTextFromFile();

	}
}
