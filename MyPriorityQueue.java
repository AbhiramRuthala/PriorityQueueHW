package pq;

// Name: Abhiram Ruthala
// Computing ID: kas4kj@virginia.edu
// Homework Name: HW-12 Priority Queue
// Resources used: Claude Sonnet 4.5 for debugging

import java.awt.*;
import java.util.spi.AbstractResourceBundleProvider;

public class MyPriorityQueue<T extends Comparable<T>> implements SimplePQ<T> {

    private Object[] sense;
    private T[] heap;
    private int size;

    public MyPriorityQueue(int capacity) {
        sense = new Object[capacity];
        heap = (T[]) new Object[capacity];
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

        int parent = parent(index);

        while(index > 0) {
            if(heap[index].compareTo(heap[parent]) < 0) {
                swap(index, parent);
            } else {
                break;
            }

        }


    }

    private void bubbleDown(int index){
        int leftChild = leftChild(index);
        int rightChild = rightChild(index);

        while(index > 0) {
            if (heap[leftChild].compareTo(heap[rightChild]) > 0) {
                swap(index, leftChild);
            } else {
                break;
            }
        }
    }

    @Override
    public void add(T t) {
        heap[heap.length - 1] = t;
        bubbleUp(heap.length - 1);

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
    }
    public boolean contains(Object o) {
        for(int i = 0; i < heap.length; i++) {
            if (heap[i] == o) {
                return true;
            }
        }
        return false;
    }
    public T peek() {
        return heap[0];
    }
    public T remove() {
        if(sense.length == 0) {
            return null;
        } else {
            T t1 = heap[0];
            sense[0] = null;
            bubbleDown(0);
            size--;
            return t1;
        }

    }
    public int size() {
        return heap.length;
    }
}
