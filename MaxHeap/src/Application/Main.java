package Application;

import java.util.Scanner;
import MaxHeap.MaxHeap;

public class Main {
	public static void main(String[] args) {
		System.out.println("Implementing MaxHeap in Java");
		System.out.println("----------------------------");
		
		try {
			System.out.println("Enter the number of elements to be inserted in the MaxHeap");
			Scanner scanner = new Scanner(System.in);
			int maxHeapSize = scanner.nextInt();
			MaxHeap maxHeap = new MaxHeap(15);
			for(int index = 0; index < maxHeapSize; index++) {
				System.out.println("Enter the element "+(index+1));
				maxHeap.InsertInMaxHeap(scanner.nextInt());				
			}
			System.out.println("Extracted Maximum from MaxHeap is "+maxHeap.ExtractMaximum());
			System.out.println("Value after Decrease Key is "+maxHeap.DeleteElementAtIndex(2));
			maxHeap.PrintMaxHeapElements();
		}catch(Exception exception) {
			System.out.println("Application:Main:Thrown exception is "+exception.getLocalizedMessage());
		}
	}
}
