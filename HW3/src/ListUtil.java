
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
	public static void main(String[]args){
		ListCell<Integer> header = new ListCell<Integer>(0, null);
		System.out.print("List: ");
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
		next = header;
		while(next != null){
			System.out.print(next.getDatum()+ " ");
			next = next.getNext();
		}
		
		System.out.print("\nInsert -1 at 0: ");
		header = InsertNth(header, 0, -1);
		next = header;
		while(next != null){
			System.out.print(next.getDatum()+ " ");
			next = next.getNext();
		}
		
		System.out.print("\nDo InsertSort: ");
		header = InsertSort(header);
		next = header;
		while(next != null){
			System.out.print(next.getDatum()+ " ");
			next = next.getNext();
		}
		
		System.out.print("\nInsert 5 with SortedInsert: ");
		header = SortedInsert(header, new ListCell(5, null));
		next = header;
		while(next != null){
			System.out.print(next.getDatum()+ " ");
			next = next.getNext();
		}
		
		
		
		System.out.print("\nInsert -1 with SortedInsert: ");
		header = SortedInsert(header, new ListCell(-1, null));
		next = header;
		while(next != null){
			System.out.print(next.getDatum()+ " ");
			next = next.getNext();
		}
		
		
	
		System.out.print("\nDelete Duplicates: ");
		header = RemoveDuplicates(header);
		next = header;
		while(next != null){
			System.out.print(next.getDatum()+ " ");
			next = next.getNext();
		}
		
		System.out.print("\n\nList: ");
		ListCell head2 = new ListCell(0, null);
		ListCell next2 = head2;
		for(int i = 1; i <= 20; i++){
			head2 = InsertNth(head2,i,i);
		}
		for(int i = 0; i <=20; i++){
			System.out.print(next2.getDatum()+ " ");
			next2 = next2.getNext();
		}
		
		System.out.print("\nDelete duplicates: ");
		head2 = RemoveDuplicates(head2);
		next2 = head2;
		while(next2 != null){
			System.out.print(next2.getDatum() + " ");
			next2 = next2.getNext();
		}
		
		System.out.print("\nDo InsertSort: ");
		head2 = InsertSort(head2);
		next2 = head2;
		while(next2 != null){
			System.out.print(next2.getDatum() + " ");
			next2 = next2.getNext();
		}
		
		System.out.print("\n\nList: ");
		ListCell head3 = new ListCell(5, null);
		ListCell next3 = head3;
		while(next3 != null){
			System.out.print(next3.getDatum() + " ");
			next3 = next3.getNext();
		}
		
		System.out.print("\nDo insertSort: ");
		head3 = InsertSort(head3);
		next3 = head3;
		while(next3 != null){
			System.out.print(next3.getDatum() + " ");
			next3 = next3.getNext();
		}
		
		System.out.print("\nInsert 5 with SortedInsert: ");
		head3 = SortedInsert(head3,new ListCell(5, head2));
		next3 = head3;
		while(next3 != null){
			System.out.print(next3.getDatum() + " ");
			next3 = next3.getNext();
		}
		
		System.out.print("\nInsert -100 at 0: ");
		head3 = InsertNth(head3, 0, -100);
		next3 = head3;
		while(next3 != null){
			System.out.print(next3.getDatum() + " ");
			next3 = next3.getNext();
		}
		
		System.out.print("\nInsert -1100 at 0: ");
		head3 = InsertNth(head3, 0, -1100);
		next3 = head3;
		while(next3 != null){
			System.out.print(next3.getDatum() + " ");
			next3 = next3.getNext();
		}
		
		System.out.println("\nInsert -500 with SortedInsert: ");
		head3 = SortedInsert(head3, new ListCell(-500, null));
		next3 = head3;
		while(next3 != null){
			System.out.print(next3.getDatum() + " ");
			next3 = next3.getNext();
		}
		
		ListCell head4 = new ListCell(5, null);
		ListCell next4 = head4;
		for(int i = 0; i < 5; i++){
			head4 = SortedInsert(head4, new ListCell(5, null));
		}
		
		System.out.print("\n\nList: ");
		next4 = head4;
		while(next4 != null){
			System.out.print(next4.getDatum() + " ");
			next4 = next4.getNext();
		}
		
		System.out.println("\nCount 5: " + Count(head4, 5));
		System.out.println("Count 0: " + Count(head4, 0));
		
		System.out.print("Do InsertSort: ");
		head4 = InsertSort(head4);
		next4 = head4;
		while(next4 != null){
			System.out.print(next4.getDatum() + " ");
			next4 = next4.getNext();
		}
		
		System.out.print("\nRemove Duplicates: ");
		head4 = RemoveDuplicates(head4);
		next4 = head4;
		while(next4 != null){
			System.out.print(next4.getDatum() + " ");
			next4 = next4.getNext();
		}
	}
}
