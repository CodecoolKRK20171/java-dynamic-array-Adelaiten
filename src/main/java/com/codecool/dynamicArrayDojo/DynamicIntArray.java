package com.codecool.dynamicArrayDojo;


public class DynamicIntArray {

    private int array[];
    private int index;

    public DynamicIntArray() {
        this.array = new int[10];
        this.index = 0;
    }


    public DynamicIntArray(int size) {
        this.array = new int[size];
        this.index = 0;
    }


    public void add(int number) {
        if(index == array.length) {
            resizeAnArray();
            this.array[index++] = number;
        }else {
            this.array[index++] = number;
        }

    }

    private void resizeAnArray() {
        int RESIZED_ARRAY_LENGTH = this.array.length * 2;
        int tempArray[] = this.array.clone();
        this.array = new int[RESIZED_ARRAY_LENGTH];
        for(int i = 0; i < tempArray.length; i++) {
            this.array[i] = tempArray[i];
        }
    }


    public void remove(int index) {

    }


    public void insert(int index, int number) {

    }


}
