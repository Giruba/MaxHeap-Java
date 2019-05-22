package MaxHeap;

public class MaxHeap {
	private int[] maxHeapArray;
	private int maxHeapSize;
	private int maxHeapCapacity;
	
	public MaxHeap(int capacity) {
		this.maxHeapArray = new int[capacity];
		this.maxHeapCapacity = capacity;
		this.maxHeapSize = 0;
	}
	
	public void SetMaxHeapCapacity(int value) {
		this.maxHeapArray = new int[value];
		this.maxHeapCapacity = this.maxHeapArray.length;
		this.maxHeapSize = 0;
	}
	
	public void SetMaxHeapArray(int[] array) {
		this.maxHeapArray = array;
	}
	
	public void SetMaxHeapSize(int size) {
		this.maxHeapSize = size;
	}
	
	public int[] GetMaxHeapArray() {
		return this.maxHeapArray;
	}
	
	public int GetMaxHeapSize() {
		return this.maxHeapSize;
	}
	
	public int GetMaxHeapCapacity() {
		return this.maxHeapCapacity;
	}
	
	
	public void InsertInMaxHeap(int data) {
		//Check first whether we can insert at all!
		if(this.maxHeapSize == this.maxHeapCapacity) {
			System.out.println("MaxHeap is full! Cannot insert!!!");
			return;
		}
		
		this.maxHeapSize++;
		int indexOfInsertion = this.maxHeapSize-1;
		this.maxHeapArray[indexOfInsertion] = data;
		
		while(indexOfInsertion != 0 && this.maxHeapArray[(indexOfInsertion-1)/2] < this.maxHeapArray[indexOfInsertion]) {
			int valueToBeSwapped = this.maxHeapArray[(indexOfInsertion-1)/2];
			this.maxHeapArray[(indexOfInsertion-1)/2] = this.maxHeapArray[indexOfInsertion];
			this.maxHeapArray[indexOfInsertion] = valueToBeSwapped;
			
			//Percolate up to see if we are violating the maxHeap property
			indexOfInsertion = (indexOfInsertion-1)/2;
		}
	}
	
	public int ExtractMaximum() {
		if(this.maxHeapSize <=0) {
			System.out.println("MaxHeap is empty! Can't extract anything at all!");
			return -1;
		}
		
		if(this.maxHeapSize == 1) {
			this.maxHeapSize--;
			return this.maxHeapArray[0];
		}
		
		int valueToBeReturned = this.maxHeapArray[0];
		this.maxHeapArray[0] = this.maxHeapArray[this.maxHeapSize-1];
		this.maxHeapSize--;
		MaxHeapify(0);
		
		return valueToBeReturned;
	}
	
	public void MaxHeapify(int index) {
		
		int leftIndex = 2*index+1;
		int rightIndex = 2*index+2;
		int largestValueIndex = index;
		
		if(leftIndex < this.maxHeapSize && this.maxHeapArray[leftIndex] > this.maxHeapArray[index]) {
			largestValueIndex = this.maxHeapArray[leftIndex];
		}
		
		if(rightIndex < this.maxHeapSize && this.maxHeapArray[rightIndex] > this.maxHeapArray[largestValueIndex]) {
			largestValueIndex = this.maxHeapArray[rightIndex];
		}
		
		if(largestValueIndex != index) {
			int valueToBeReplaced = this.maxHeapArray[index];
			this.maxHeapArray[index] = this.maxHeapArray[largestValueIndex];
			this.maxHeapArray[largestValueIndex] = valueToBeReplaced;
			
			//Percolate down to place the maximum at its place
			MaxHeapify(largestValueIndex);
		}		
	}
	
	public int DeleteElementAtIndex(int index) {
		
		//DecreaseValue at index to int.Max and then extractMin to remove the value
		DecreaseValueAtIndex(index, Integer.MAX_VALUE);
		return ExtractMaximum();
	}
	
	public void DecreaseValueAtIndex(int index, int value) {
		this.maxHeapArray[index] = value;
		
		while(index != 0 && this.maxHeapArray[(index-1)/2] < this.maxHeapArray[index]) {
			int valueToSwap = this.maxHeapArray[index];
			this.maxHeapArray[index] = this.maxHeapArray[(index-1)/2];
			this.maxHeapArray[(index-1)/2] = valueToSwap;
			
			index = (index-1)/2;			
		}
	}
	
	public void PrintMaxHeapElements() {
		System.out.println("-----Printing the contents of the MaxHeap-----");
		System.out.println("----------------------------------------------");
		
		for(int index = 0; index < this.maxHeapSize; index++) {
			System.out.print(this.maxHeapArray[index]+ " ");
		}
		
	}
}
