
public class ListUtil {

	static int Count(ListCell head, int searchFor){
		int Count = 0;
		while(head != null){
			if((int)(head.getDatum()) == searchFor){
				Count++;
			}
			head = head.getNext();
		}
		return Count;
	}
	
	static ListCell InsertNth(ListCell headRef, int index, int data){
		int count = 0;
		ListCell curr = headRef;
		while(count < index - 1){
			curr = curr.getNext();
			count++;
		}
		ListCell newCell = new ListCell<Integer>(data, curr);;
		
		if(index == 1 || count != 0){
			newCell.setNext(curr.getNext());
			curr.setNext(newCell);
			return headRef;
		}
		return newCell;
	}
	
	static ListCell SortedInsert(ListCell headRef, ListCell newNode){
		ListCell curr = headRef;
		ListCell next = headRef.getNext();
		newNode.setNext(null);
		int newVal = (int)(newNode.getDatum());
		if(((int)(curr.getDatum()) > newVal)){
			newNode.setNext(curr);
			return newNode;
		}
		
		while(next != null){
			int currVal = (int)(curr.getDatum());
			int nextVal = (int)(next.getDatum());
			if(currVal <= newVal && newVal < nextVal){
				curr.setNext(newNode);
				newNode.setNext(next);
				break;
			}else{
				curr = next;
				next = next.getNext();
			}
			
		}
		if(next == null){
			curr.setNext(newNode);
		}
		return headRef;
		
	}
	
	static ListCell InsertSort(ListCell headRef){
		ListCell newList = new ListCell(headRef.getDatum(), null);
		headRef = headRef.getNext();
		while(headRef != null){
			ListCell temp = headRef.getNext();
			headRef.setNext(null);
			newList = SortedInsert(newList, headRef);
			headRef = temp;
			
		}
		return newList;
	}
	
	static ListCell RemoveDuplicates(ListCell head){
		ListCell curr = head;
		ListCell next = head.getNext();
		while(next != null){
			int currVal = (int)(curr.getDatum());
			int nextVal = (int)(next.getDatum());
			if(currVal == nextVal){
				curr.setNext(next.getNext());
			}else{
				curr = next;
			}
			next = curr.getNext();
		}
		return head;
		
	}
	
	static void printList(ListCell head){
		ListCell next = head;
		while(next != null){
			System.out.print(next.getDatum() + " ");
			next = next.getNext();
		}
		System.out.println();
	}
	
	public static void main(String[]args){
		
		System.out.println("########## Test cases : Random List ##########");
		
		ListCell<Integer> header = new ListCell<Integer>(0, null);
		System.out.print("List: 0 ");
		ListCell<Integer> next = null;
		for(int i = 0; i < 10; i++){
			ListCell<Integer> temp = new ListCell<Integer>((int)Math.round(10*Math.random()),null);
			System.out.print(temp.getDatum() + " ");
			if(header.getNext() == null){
				header.setNext(temp);
			} else {
				next.setNext(temp);
			}
			next = temp;
		}
		
		System.out.println("\nCount 5: " + Count(header, 5));
		
		System.out.print("Insert 13 at 11: ");
		header = InsertNth(header, 11, 13);
		printList(header);
		
		System.out.print("Insert -1 at 0: ");
		header = InsertNth(header, 0, -1);
		printList(header);
		
		System.out.print("Do InsertSort: ");
		header = InsertSort(header);
		printList(header);
		
		System.out.print("Insert 5 with SortedInsert: ");
		header = SortedInsert(header, new ListCell(5, null));
		printList(header);
		
		System.out.print("Insert -1 with SortedInsert: ");
		header = SortedInsert(header, new ListCell(-1, null));
		printList(header);
		
		System.out.print("Remove Duplicates: ");
		header = RemoveDuplicates(header);
		printList(header);
		System.out.println("########## END OF TEST CASE : RANDOM LIST ##########");
		
		
		System.out.println("\n\n\n########## Test cases: RemoveDuplicates and InsertSort on sorted list ##########");
		System.out.print("List: ");
		ListCell head2 = new ListCell(0, null);
		ListCell next2 = head2;
		for(int i = 1; i <= 20; i++){
			head2 = InsertNth(head2,i,i);
		}
		for(int i = 0; i <=20; i++){
			System.out.print(next2.getDatum()+ " ");
			next2 = next2.getNext();
		}
		
		System.out.print("\nRemove duplicates: ");
		head2 = RemoveDuplicates(head2);
		printList(head2);
		
		System.out.print("Do InsertSort: ");
		head2 = InsertSort(head2);
		printList(head2);
		System.out.println("########## END OF TEST CASES : REMOVEDUPLICATES AND INSERTSORT ON SORTEDLIST ##########");
		
		
		System.out.println("\n\n\n########## Test cases : InsertSort on single cell-list, and SortedInsert with negative value ##########");
		System.out.print("List: ");
		ListCell head3 = new ListCell(5, null);
		printList(head3);
		
		System.out.print("Do insertSort: ");
		head3 = InsertSort(head3);
		printList(head3);
		
		System.out.print("Insert 5 with SortedInsert: ");
		head3 = SortedInsert(head3,new ListCell(5, head2));
		printList(head3);
		
		System.out.print("Insert -100 at 0: ");
		head3 = InsertNth(head3, 0, -100);
		printList(head3);
		
		System.out.print("Insert -1100 at 0: ");
		head3 = InsertNth(head3, 0, -1100);
		printList(head3);
		
		System.out.println("Insert -500 with SortedInsert: ");
		head3 = SortedInsert(head3, new ListCell(-500, null));
		printList(head3);
		
		ListCell head4 = new ListCell(5, null);
		for(int i = 0; i < 5; i++){
			head4 = SortedInsert(head4, new ListCell(5, null));
		}
		System.out.println("########## TEST CASES : INSERTSORT ON SINGLE CELL-LIST, AND SORTEDINSERT WITH NEGATIVE VALUE ##########");
		
		System.out.println("\n\n\n########## Test cases : InsertSort, Count and RemoveDuplicates on the list that has the same values in it ##########");
		System.out.print("List: ");
		printList(head4);
		
		System.out.println("Count 5: " + Count(head4, 5));
		System.out.println("Count 0: " + Count(head4, 0));
		
		System.out.print("Do InsertSort: ");
		head4 = InsertSort(head4);
		printList(head4);
		
		System.out.print("Remove Duplicates: ");
		head4 = RemoveDuplicates(head4);
		printList(head4);
		System.out.println("########## END OF TEST CASES : INSERTSORT, COUNT AND REMOVEDUPLICATES ON THE LIST THAT HAS THE SAME VALUES IN IT ##########");
	}
}
