package sorts;

import java.util.ArrayList;

public class BubbleSort {

    public static ArrayList<Integer> bubbleSort(ArrayList<Integer> arrayList) {
        int length = arrayList.size();
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arrayList.get(j).compareTo(arrayList.get(j + 1)) > 0) {
                    int temp = arrayList.get(j);
                    arrayList.set(j, arrayList.get(j + 1));
                    arrayList.set(j + 1, temp);
                }
            }
        }
        return arrayList;
    }
}
