package org.cursocoritel.Buffer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Logger;

public class Buffer <T> {
	private Queue<T> bufferList ;
	private int capacity ;
	int numberOfPutOperations = 0 ;
	int numberOfGetOperations = 0 ;

	/**
	 * Constructor
	 * @param bufferSize
	 */
	public Buffer(int bufferSize) {
		capacity = bufferSize ;
		bufferList = new LinkedList() ;
	}

	/**
	 * Gets the number of elements
	 * @param element
	 * @throws BufferException
	 */
	public void put(T element)throws BufferException {
		if (bufferList.size() == capacity){
			throw new BufferException();
		}

		Logger logger = null;
		logger.log(null, "Element inserted");
		//System.out.println("Element inserted");

		bufferList.add(element) ;
		numberOfPutOperations++ ;
	}
	
	/**
	 * Gets the oldest value of the queue
	 * @return
	 * @throws BufferException
	 */
	public T get() throws BufferException {
		if (bufferList.isEmpty()) 
			throw new BufferException() ;

		T value = bufferList.remove() ;
		System.out.println("Element extracted");

		numberOfGetOperations++ ;
		return value ;
	}

	public int getNumberOfElements() {
		return bufferList.size() ;
	}

	public int getNumberOfHoles() {
		return capacity - bufferList.size() ;
	}

	public int getCapacity() {
		return capacity ;
	}

	public double getNumberOfOperations() {
		return (double)numberOfPutOperations + numberOfGetOperations ;
	}
}