package com.epam;

import org.testng.Assert;
import org.testng.annotations.Test;
import sorts.BubbleSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BubbleSortTest {

    @Test
    public void bubbleSortTest() {
        ArrayList<Integer> actualList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            actualList.add(i);
        }
        Collections.shuffle(actualList);
        ArrayList<Integer> expectedList = new ArrayList<>();
        expectedList.add(0);
        expectedList.add(1);
        expectedList.add(2);
        expectedList.add(3);
        expectedList.add(4);
        Assert.assertEquals(BubbleSort.bubbleSort(actualList), expectedList);
    }
}
