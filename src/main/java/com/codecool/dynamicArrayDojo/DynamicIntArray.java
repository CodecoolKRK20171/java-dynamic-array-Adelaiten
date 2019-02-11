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
        if(index >= array.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        shiftArrayElements(index);
    }

    private void shiftArrayElements(int index) {
        for(int i = index; i < this.array.length; i++) {
            if(i == this.array.length - 1) {
                this.array[i] = 0;
                this.index--;
            } else {
                this.array[i] = this.array[i+1];
            }
        }
    }


    public void insert(int index, int number) {

        if(index >= this.index) {
            add(number);
        }else {
            for(int i = this.index; i >= index; i--) {
                resizeArrayIfNeeded(i);
                shiftElementsAndInsert(index, number, i);
            }
            this.index++;
        }


    }

    private void shiftElementsAndInsert(int index, int number, int i) {
        if(i == index) {
            this.array[i] = number;
        } else {
            this.array[i] = this.array[i-1];
        }
    }

    private void resizeArrayIfNeeded(int i) {
        if(i == this.array.length) {
            resizeAnArray();
        }
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < this.index; i ++) {
            stringBuilder.append(" " + array[i]);
        }
        return stringBuilder.toString();
    }
}
