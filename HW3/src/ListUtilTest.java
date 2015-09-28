import java.lang.reflect.Array;
import java.util.*;

import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import static org.junit.Assert.*;

/**
 * Created by WIT-PC on 26/9/2558.
 */
public class ListUtilTest {
    public ListUtil listUtil = new ListUtil();
    public ListCell listCell1 = new ListCell<Integer>(1,
            new ListCell<Integer>(2,
                    new ListCell<Integer>(3,
                            new ListCell<Integer>(4,
                                    new ListCell<Integer>(5,null)))));
    private ListCell<Integer> createList(int[] array){
        ListCell<Integer> head = new ListCell<Integer>(array[0],null);
        ListCell<Integer> temp=head;
        for(int i =1;i<array.length;i++){
            temp.setNext(new ListCell<Integer>(array[i],null));
            temp = temp.getNext();
        }
        return head;
    }
    private ArrayList<Integer> createSortedArrayList(Integer[] array){
        ArrayList<Integer> sorted = new ArrayList<Integer>();
        sorted.addAll(Arrays.asList(array));
        Collections.sort(sorted);
        return sorted;
    }
    @Test
    public void countTest1(){
        assertSame(listUtil.Count(listCell1,1),1);
        assertSame(listUtil.Count(listCell1,2),1);
        assertSame(listUtil.Count(listCell1,3),1);
        assertSame(listUtil.Count(listCell1, 4), 1);
        assertSame(listUtil.Count(listCell1, 5), 1);
    }
    @Test
    public void countTest2(){
        ListCell<Integer> cell = createList(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20});
        for(int i = 1;i<=20;i++){
            assertSame(listUtil.Count(cell,i),1);
        }
    }
    @Test
    public void countTest3(){
        ListCell<Integer> cell = createList(new int[]{3,6, 9,12, 3,6, 9,12, 3,6, 9,12,
                3,6, 9,12, 3,6, 9,12, 3,6, 9,12,
                3,6, 9,12, 3,6, 9,12, 3,6, 9,12,
                3,6, 9,12, 3,6, 9,12, 3,6, 9,12,
                3,6, 9,12, 3,6, 9,12, 3,6, 9,12,
                3,6, 9,12, 3,6, 9,12, 3,6, 9,12});

        assertSame(listUtil.Count(cell,3),18);
        assertSame(listUtil.Count(cell,6),18);
        assertSame(listUtil.Count(cell,9),18);
        assertSame(listUtil.Count(cell,12),18);
    }
    @Test
    public void countTest4(){
        ListCell<Integer> cell = createList(new int[]{
                1,
                2,2,
                3,3,3,
                4,4,4,4,
                5,5,5,5,5,
                6,6,6,6,6,6,
                7,7,7,7,7,7,7,
                8,8,8,8,8,8,8,8,
                9,9,9,9,9,9,9,9,9,
                10,10,10,10,10,10,10,10,10,10,
                11,11,11,11,11,11,11,11,11,11,11,
                12,12,12,12,12,12,12,12,12,12,12,12,
                13,13,13,13,13,13,13,13,13,13,13,13,13,
                14,14,14,14,14,14,14,14,14,14,14,14,14,14,
                15,15,15,15,15,15,15,15,15,15,15,15,15,15,15,
                16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,16,
                17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,
                18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,18,
                19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,19,
                20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20
        });
        for(int i = 1;i<=20;i++){
            assertSame(listUtil.Count(cell,i),i);
        }

    }
    @Test
    public void countTest5() {
        ListCell<Integer> cell = createList(new int[]{
                15, 15, 15, 15, 15, 15, 15, 15,5, 5, 5, 5, 5,
                9, 9, 9, 4, 4, 4, 4, 15, 15, 15, 15, 15, 15, 15,
                16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16,
                8, 8, 8, 8, 18, 18, 18, 18, 18, 18, 18, 18,
                9, 9, 9, 9, 9, 9, 8, 8, 8, 8,
                19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19,
                14, 14, 14, 14, 14, 14, 14, 17, 17, 17, 17, 17, 17, 17, 17,
                11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 6, 6, 6, 6, 6, 6,
                10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13,
                14, 14, 14, 14, 14, 14, 14,
                12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12,
                17, 17, 17, 17, 17, 17, 17, 17, 17,
                18, 18, 18, 18, 18, 18, 18, 18,
                7, 7, 7, 7, 7, 7, 7, 3, 3, 3, 18, 18, 2, 2, 1,
                20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20
        });
        for (int i = 1; i <= 20; i++) {
            assertSame(listUtil.Count(cell, i), i);
        }
    }
    @Test
    public void countTest6(){
        ListCell<Integer> cell = createList(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,24,1,2,4,8,2,5,4,8,6,4,8,5,1,2,15,1,1,5,5,48,4,8});
        for(int i = 1;i<=20;i++){
            assertSame(listUtil.Count(cell,i+50),0);
        }
    }
    @Test
    public void insertNth1(){
        ListCell<Integer> cell = new ListCell<Integer>(0,null);
        cell = listUtil.InsertNth(cell,0,1);
        assertSame(cell.getDatum(), 1);
        assertSame(cell.getNext().getDatum(), 0);
        assertSame(cell.getNext().getNext(), null);
    }
    @Test
    public void insertNth2(){
        ListCell<Integer> cell = new ListCell<Integer>(0,null);
        for(int i = 0;i<=20;i++){
            cell = listUtil.InsertNth(cell,0,i);
        }
        for(int i = 20;i>=0;i--){
            assertSame(cell.getDatum(), i);
            cell=cell.getNext();
        }
        assertSame(cell.getDatum(), 0);
        assertSame(cell.getNext(), null);
    }
    @Test
     public void insertNth3(){
        ListCell<Integer> cell = new ListCell<Integer>(0,null);
        for(int i = 0;i<=20;i++){
            cell = listUtil.InsertNth(cell,i,i);
        }
        for(int i = 0;i<=20;i++){
        	assertSame(cell.getDatum(), i);
            cell=cell.getNext();
        }
        assertSame(cell.getDatum(), 0);
        assertSame(cell.getNext(), null);
    }
    @Test
    public void insertNth4(){
        ListCell<Integer> cell = new ListCell<Integer>(0,null);
        for(int i = 0;i<=20;i++){
            ListCell<Integer> last = cell;
            int count =0;
            while (last!=null){
                last=last.getNext();
                count++;
            }
            cell = listUtil.InsertNth(cell, count, i);
        }
        assertSame(cell.getDatum(), 0);
        cell = cell.getNext();
        for(int i = 0;i<=20;i++){
            assertSame(cell.getDatum(), i);
            cell=cell.getNext();
        }
        assertSame(cell, null);
    }
    @Test
    public void SortedInsert1(){
        ListCell<Integer> cell = new ListCell<Integer>(0,null);
        cell = listUtil.SortedInsert(cell,new ListCell(1,null));
        assertSame(cell.getDatum(),0);
        assertSame(cell.getNext().getDatum(),1);
        assertSame(cell.getNext().getNext(),null);
    }
    @Test
    public void SortedInsert2(){
        ListCell<Integer> cell = new ListCell<Integer>(1,null);
        cell = listUtil.SortedInsert(cell,new ListCell(0,null));
        assertSame(cell.getDatum(),0);
        assertSame(cell.getNext().getDatum(),1);
        assertSame(cell.getNext().getNext(),null);
    }
    @Test
     public void SortedInsert3() {
        ListCell<Integer> cell = createList(new int[]{2,4,5,6,8,9,11,12,14,16,17,19,20});
        cell = listUtil.SortedInsert(cell,new ListCell<Integer>(0,null));
        cell = listUtil.SortedInsert(cell,new ListCell<Integer>(3,null));
        cell = listUtil.SortedInsert(cell,new ListCell<Integer>(18,null));
        cell = listUtil.SortedInsert(cell,new ListCell<Integer>(13,null));
        cell = listUtil.SortedInsert(cell,new ListCell<Integer>(15,null));
        cell = listUtil.SortedInsert(cell,new ListCell<Integer>(1,null));
        cell = listUtil.SortedInsert(cell,new ListCell<Integer>(7,null));
        cell = listUtil.SortedInsert(cell, new ListCell<Integer>(10, null));

        for(int i=0;i<=20;i++){
            assertSame(cell.getDatum(), i);
            cell=cell.getNext();
        }
        assertSame(cell,null);
    }
    @Test
      public void SortedInsert4() {
        Integer[] array = new Integer[]{1,4,5,415,458,4,521,2,151,20,4,5,45,16,4,84,16,1,4,8,4,551,6,48,4,21,8,415,165,4985,41,561,65,54,84,5,112,1,984,89,45,56,45,41,21,2,1541,5,3,1,54,5,165,165,4,5415,614,54,54};
        ListCell<Integer> cell =new ListCell<Integer>(0,null);
        for(int i=0;i<array.length;i++){
            cell = listUtil.SortedInsert(cell,new ListCell(array[i],null));
        }
        ArrayList<Integer> sorted = createSortedArrayList(array);
        assertSame(cell.getDatum(),0);
        cell=cell.getNext();
        for(int i=0;i<array.length;i++){
            assertEquals(cell.getDatum(), sorted.get(i));
            cell=cell.getNext();
        }
        assertSame(cell,null);
    }
    @Test
     public void InsertSort1(){
        ListCell<Integer> cell = new ListCell<Integer>(1,null);
        cell =listUtil.InsertSort(cell);
        assertSame(cell.getDatum(), 1);
        assertSame(cell.getNext(),null);
    }
    @Test
    public void InsertSort2(){
        ListCell<Integer> cell = createList(new int[]{5,4,3,2,1});
        ArrayList<Integer> sorted = createSortedArrayList(new Integer[]{5,4,3,2,1});
        cell =listUtil.InsertSort(cell);
        for(int i =0;i<sorted.size();i++){
            assertEquals(cell.getDatum(), sorted.get(i));
            cell=cell.getNext();
        }
        assertSame(cell,null);
    }
    @Test
    public void InsertSort3(){
        ListCell<Integer> cell = createList(new int[]{0,1,51,9,456,15,1485,15,1652,195,156,2162,15,4198,121,21,6514,651,561,564,8741,561,62,15,498,45,162,19498,41,521,6,489,45,1,61,41,8941,521,26,1,418,15,126,165,48,4,8541});
        ArrayList<Integer> sorted = createSortedArrayList(new Integer[]{0,1,51,9,456,15,1485,15,1652,195,156,2162,15,4198,121,21,6514,651,561,564,8741,561,62,15,498,45,162,19498,41,521,6,489,45,1,61,41,8941,521,26,1,418,15,126,165,48,4,8541});
        cell =listUtil.InsertSort(cell);
        for(int i =0;i<sorted.size();i++){
            assertEquals(cell.getDatum(), sorted.get(i));
            cell=cell.getNext();
        }
        assertSame(cell,null);
    }
    @Test
    public void InsertSort4(){
        ListCell<Integer> cell = createList(new int[]{51,515,61,651,51,21,64,8941,562,154,12,12,12,131,2,15,15,13,21,61,151,4561,23,15,415,5,410,61,651,451,5621,65,415,16,521,604,156,15,15,6156,1,45,4,54,564,541,62,165,45,16,21,94,9854,156,162,1,841,851,5621,2315,148,4185,156,123,15,1,951,521212,13,15,15,4189,485,156,21,61,49841,5,156,1,651,9841,95,165,16,51,98541,5,156,165,419841,65165,165,41985,4156,13216,5498,465,1,321,151587});
        ArrayList<Integer> sorted = createSortedArrayList(new Integer[]{51, 515, 61, 651, 51, 21, 64, 8941, 562, 154, 12, 12, 12, 131, 2, 15, 15, 13, 21, 61, 151, 4561, 23, 15, 415, 5, 410, 61, 651, 451, 5621, 65, 415, 16, 521, 604, 156, 15, 15, 6156, 1, 45, 4, 54, 564, 541, 62, 165, 45, 16, 21, 94, 9854, 156, 162, 1, 841, 851, 5621, 2315, 148, 4185, 156, 123, 15, 1, 951, 521212, 13, 15, 15, 4189, 485, 156, 21, 61, 49841, 5, 156, 1, 651, 9841, 95, 165, 16, 51, 98541, 5, 156, 165, 419841, 65165, 165, 41985, 4156, 13216, 5498, 465, 1, 321, 151587});
        cell =listUtil.InsertSort(cell);
        for(int i =0;i<sorted.size();i++){
            assertEquals(cell.getDatum(), sorted.get(i));
            cell=cell.getNext();
        }
        assertSame(cell, null);
    }
    @Test
    public void RemoveDuplicates1(){
        ListCell<Integer> cell = createList(new int[]{1, 1});
        cell = listUtil.RemoveDuplicates(cell);
        assertSame(cell.getDatum(),1);
        assertSame(cell.getNext(),null);
    }
    @Test
    public void RemoveDuplicates2(){
        ListCell<Integer> cell = createList(new int[]{1});
        cell = listUtil.RemoveDuplicates(cell);
        assertSame(cell.getDatum(),1);
        assertSame(cell.getNext(),null);
    }
    @Test
    public void RemoveDuplicates3(){
        ListCell<Integer> cell = createList(new int[]{1,1,1,1,2,2,2,2,2,2,2,2,3,3,3,3,3,4,4,4,4,4,4,4,4,4,4,4,4,5,5,5,5,6,6,6,6,6,6,6,7,7,7,7,8,8,8,8,8,9,9,9});
        cell = listUtil.RemoveDuplicates(listUtil.InsertSort(cell));
        for(int i =1;i<10;i++){
            assertSame(cell.getDatum(), i);
            cell=cell.getNext();
        }
        assertSame(cell,null);
    }
    @Test
    public void RemoveDuplicates4(){
        ListCell<Integer> cell = createList(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,3,3,4,4,4,4,5,5,5,5,5,5,11,11,12,12,15,15,15,15,15,21,21,21,21,21,21,21,21,21,23,31,31,31,32,33,45,45,45,45,46,48,48,51,51,51,51,51,54,54,54,61,61,62});
        ArrayList<Integer> list = createSortedArrayList(new Integer[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,3,3,4,4,4,4,5,5,5,5,5,5,11,11,12,12,15,15,15,15,15,21,21,21,21,21,21,21,21,21,23,31,31,31,32,33,45,45,45,45,46,48,48,51,51,51,51,51,54,54,54,61,61,62});
        list = new ArrayList<Integer>(new HashSet<Integer>(list));
        Collections.sort(list);
        cell = listUtil.RemoveDuplicates(cell);
        for(int i =0;i<list.size();i++){
            assertEquals(cell.getDatum(), list.get(i));
            cell=cell.getNext();
        }
        assertSame(cell,null);
    }
    public static void main(String[] args) {
        Class<?> testclass = ListUtilTest.class;
        Result result = org.junit.runner.JUnitCore.runClasses( testclass );
    }
}