package codechallenges;

import Sort.Sort;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SortTest {
    Integer[] emptyArr;
    Sort<Integer> emptySort;
    Integer[] integerArr;
    Sort<Integer> integerSort;
    Integer[] integerNegArr;
    Sort<Integer> integerNegSort;
    Integer[] uniquesIntegerArr;
    Sort<Integer> uniquesIntegerSort;

    @Before
    public void init(){
        emptyArr =  new Integer[0];
        emptySort = new Sort<Integer>();
        integerArr = new Integer[]{4, 25, 30, 15, 16};
        integerSort = new Sort<Integer>();
        integerNegArr = new Integer[]{4, -25, 30, 15, -15, 99, 3, 0};
        integerNegSort = new Sort<Integer>();
        uniquesIntegerArr = new Integer[]{5,12,7,5,5,7};
        uniquesIntegerSort = new Sort<Integer>();
    }

    @Test
    public void testInsertionSortEmpty() {
        assertArrayEquals(new Integer[]{}, emptySort.insertionSort(emptyArr));
    }

    @Test
    public void testInsertionSortMultNum() {
        assertArrayEquals(new Integer[]{4, 15, 16, 25, 30}, integerSort.insertionSort(integerArr));
    }

    @Test
    public void testInsertionSortNeg() {
        assertArrayEquals(new Integer[]{-25, -15, 0, 3, 4, 15, 30, 99},
                integerNegSort.insertionSort(integerNegArr));
    }

    @Test
    public void testUniquesIntegerSort() {
        assertArrayEquals(new Integer[]{5, 5, 5, 7, 7, 12},
                integerNegSort.insertionSort(uniquesIntegerArr));
    }

    @Test
    public void testInsertionSortEmptyMergeSort() {
        assertArrayEquals(new Integer[]{}, emptySort.mergeSort(emptyArr));
    }

    @Test
    public void testInsertionSortMultNumMergeSort() {
        assertArrayEquals(new Integer[]{4, 15, 16, 25, 30}, integerSort.mergeSort(integerArr));
    }

    @Test
    public void testInsertionSortNegMergeSort() {
        assertArrayEquals(new Integer[]{-25, -15, 0, 3, 4, 15, 30, 99},
                integerNegSort.mergeSort(integerNegArr));
    }

    @Test
    public void testUniquesIntegerSortMergeSort() {
        assertArrayEquals(new Integer[]{5, 5, 5, 7, 7, 12},
                integerNegSort.mergeSort(uniquesIntegerArr));
    }

    @Test
    public void testInsertionSortEmptyQuickSort() {
        assertArrayEquals(new Integer[]{},
                emptySort.quicksort(emptyArr, 0,  (emptyArr.length - 1) ));
    }

    @Test
    public void testInsertionSortMultNumQuickSort() {
        assertArrayEquals(new Integer[]{4, 15, 16, 25, 30},
                integerSort.quicksort(integerArr, 0, (integerArr.length - 1))
        );
    }

    @Test
    public void testInsertionSortNegQuickSort() {
        assertArrayEquals(new Integer[]{-25, -15, 0, 3, 4, 15, 30, 99},
                integerNegSort.quicksort(integerNegArr,0, (integerNegArr.length - 1))
        );
    }

    @Test
    public void testUniquesIntegerSortQuickSort() {
        assertArrayEquals(new Integer[]{5, 5, 5, 7, 7, 12},
                integerNegSort.quicksort(uniquesIntegerArr,0, (uniquesIntegerArr.length - 1))
        );
    }
}
