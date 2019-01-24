package com.codecool.dynamicArrayDojo;

import java.util.Arrays;

// put your code here!
public class DynamicIntArray {

    private int[] array;

    public DynamicIntArray() {
        array = new int[0];
    }

    public DynamicIntArray(int size) {
        array = new int[size];
    }


    public void add(int number) {
        int length = array.length;
        int[] newArray = new int[length + 1];
        System.arraycopy(array, 0, newArray, 0, length);
        newArray[length] = number;
        array = newArray;
    }

    public void remove(int index) {
        int length = array.length;
        if(index < 0 || index > length) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int[] newArray = new int[length - 1];
        if (index > 0) {
            System.arraycopy(array, 0, newArray, 0, index);
        }
        if (index < length) {
            System.arraycopy(array, index + 1, newArray, index, length - (index + 1));
        }
        array = newArray;
    }

    public void insert(int index, int number) {
        int length = array.length;
        if(index > length) {
            index = length;
        } else if(index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        int[] newArray = new int[length + 1];

        if (index == 0) {
            newArray[0] = number;
            System.arraycopy(array, 0, newArray, index + 1, length);
        } else if (index > 0 && index < length) {
            System.arraycopy(array, 0, newArray, 0, index);
            newArray[index] = number;
            System.arraycopy(array, index, newArray, index + 1, length - index);
        } else {
            System.arraycopy(array, 0, newArray, 0, length);
            newArray[index] = number;
        }
        array = newArray;
    }

    @Override
    public String toString() {
        String result = "";

        for (int i = 0; i < array.length; i++) {
            result += " " + array[i];
        }
        return result;
    }
}
