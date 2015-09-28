
public class ListUtil2 {

	/**
	 * Given a list and an int, return the number of times that int occurs in the list.
	 */
	static int count(ListCell head, int searchFor) {
		ListCell next = head;
		int count = 0;
		while(next != null){
			Object obj = next.getDatum();
			if(obj.equals(searchFor)){
				count++;
			}
			next = next.getNext();
		}
		return count;
	}
	
	/**
	 * Given a list, an index 'n' in the range 0..length, and a data element, add a new node to the list so that it has the given index. 
	 */
	static ListCell insertNth(ListCell headRef, int index, int data){
		int count = 0;
		ListCell front = headRef;
		ListCell back = headRef.getNext();
		while(count <= index){
			if(count == index){
				front.setNext(new ListCell(data, back));
				break;
			}
			front = back;
			back = back.getNext();
			count++;
		}
		return headRef;
	}
	
	static ListCell sortedInsert(ListCell headRef, ListCell newNode){
		ListCell curr = headRef;
		ListCell next = curr.getNext();
		int newVal = (int)(newNode.getDatum());
		
		while(next != null){
			int currVal = (int)(curr.getDatum());
			int nextVal = (int)(next.getDatum());
			if(currVal <= newVal){
				curr.setNext(newNode);
				newNode.setNext(next);
				break;
			}else{
				curr = next;
				next = next.getNext();
			}
			
		}
		return headRef;
	}
	
	static ListCell insertSort(ListCell headRef){
		ListCell nextCell = headRef;
		ListCell newList = new ListCell(0, nextCell);
		nextCell = nextCell.getNext();
		while(nextCell != null){
			ListCell temp = nextCell.getNext();
			sortedInsert(newList, nextCell);
			nextCell = temp;
		}
		return newList;
	}
	
	static ListCell removeDuplicates(ListCell head){
		ListCell curr = head;
		ListCell next = curr.getNext();
		while(next != null){
			int currVal = (int)(curr.getDatum());
			int nextVal = (int)(next.getDatum());
			if(currVal == nextVal){
				curr.setNext(next.getNext());
				curr = curr.getNext();
			}else{
				curr = next;
			}
		}
		return head;
	}
	
	public static void main(String[]args){
		ListCell<Integer> header = new ListCell<Integer>(0, null);
		System.out.print("List cell: ");
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
		
		System.out.println("\nCount 5: " + count(header, 5));
		
		
		System.out.print("Insert 13 at 10: ");
		header = insertNth(header, 10, 13);
		next = header;
		while(next != null){
			System.out.print(next.getDatum()+ " ");
			next = next.getNext();
		}
		
		
		System.out.print("\nInsert -1 with sortedInsert: ");
		header = sortedInsert(header, new ListCell(-1, null));
		next = header;
		while(next != null){
			System.out.print(next.getDatum()+ " ");
			next = next.getNext();
		}
		
		System.out.print("\nDo insertSort: ");
		ListCell header2 = insertSort(header);
		ListCell next2 = header2;
		int i = 0;
		while(next2 != null){
			System.out.print(next2.getDatum()+ " ");
			next2 = next2.getNext();
		}
		
		System.out.print("\nDelete Duplicates");
		removeDuplicates(header2);
		next = header2;
		while(next2 != null){
			System.out.print(next2.getDatum()+ " ");
			next2 = next2.getNext();
		}
		
	}


	
}
