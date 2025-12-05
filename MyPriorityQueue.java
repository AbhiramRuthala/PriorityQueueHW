package pq;

// Name: Abhiram Ruthala
// Computing ID: kas4kj@virginia.edu
// Homework Name: HW-12 Priority Queue
// Resources used: Claude Sonnet 4.5 for debugging

import java.awt.*;
import java.util.spi.AbstractResourceBundleProvider;

@SuppressWarnings("unchecked")
public class MyPriorityQueue<T extends Comparable<T>> implements SimplePQ<T> {

    //private Object[] sense;
    private T[] heap;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public MyPriorityQueue() {
        //sense = new Object[capacity];
        heap = (T[]) new Comparable[DEFAULT_CAPACITY];
        this.size = 0;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }


    private void swap(int x, int y){
        T sense = heap[x];
        heap[x] = heap[y];
        heap[y] = sense;
    }

    private void bubbleUp(int index){
        while(index > 0) {
            int parentIndex = parent(index);

            if(heap[index].compareTo(heap[parentIndex]) < 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }

    }

    private void bubbleDown(int index){
        //think through this.
        while(leftChild(index) < size) {
            int leftChildValue = leftChild(index);
            int smallestValue = leftChildValue;
            int rightChildValue = rightChild(index);

            if(rightChildValue < size && heap[rightChildValue].compareTo(heap[leftChildValue]) < 0) {
                smallestValue = rightChildValue;
            }

            if(heap[index].compareTo(heap[smallestValue]) > 0) {
                swap(index, smallestValue);
                index = smallestValue;
            } else {
                break;
            }

        }
    }

    private void resize(){
        T[] tempHeap = (T[]) new Comparable[heap.length * 2];
        for(int i = 0; i < heap.length; i++){
            tempHeap[i] = heap[i];
        }
        heap = tempHeap;
    }

    @Override
    public void add(T t) {
        if(size == heap.length){
            resize();
        }
        heap[size] = t;
        bubbleUp(size);

        size++;
    }

//    @Override
//    public void add(Object o) {
//
//        if(o == null){
//            return;
//        }
//
//        T newList = (T[]) new Object(capacity+1);
//        heap = newList;
//        heap[heap.length-1] = o;
//
//        size();//increase size.
//
//        Object[] arr = (Object[]) sense.clone();
//        sense = arr;
//        sense[0] = o;
//    }

    public void clear() {
        for(int i=0; i<heap.length; i++){
            heap[i] = null;
        }
        size=0;
    }
    public boolean contains(Object o) {

        for(int i = 0; i < size; i++) {
            if (heap[i].equals(o) && heap[i] != null) {
                return true;
            }
        }
        return false;
    }
    public T peek() {
        if(size == 0){
            return null;
        }
        return heap[0];
    }
    public T remove() {
        if(size == 0) {
            return null;
        }
        T t1 = heap[0];
        heap[0] = heap[size-1];
        heap[size-1] = null;
        size--;

        if(size > 0) {
            bubbleDown(0);
        }

        return t1;


    }
    public int size() {
        return size;
    }
}
