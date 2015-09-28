
public class ListUtilOld {
	
	/**
	Given a list and an int, return the number of times that int occurs in the list.
	*/ 
	public static int count(ListCell head, int searchFor){
		ListCell next = head.getNext();
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
	
	public static ListCell InsertNth(ListCell headRef, int index, int data){
		int count = 0;
		ListCell prev = headRef.getNext();
		ListCell newCell = null;
		while(count <= index){
			if(count < index){
				count++;
				prev = prev.getNext();
			} else {
				ListCell oldNext = prev.getNext();
				newCell = new ListCell<Integer>(data, oldNext);
				prev.setDatum(newCell);
			}
		}
		return newCell;
	}
	
	public static ListCell SortedInsert(ListCell headRef, ListCell newNode){
		ListCell prev = headRef.getNext();
		ListCell next;
		int newDatum =(Integer)(newNode.getDatum());
		newNode.setNext(null);
		while(true){
			
			next = prev.getNext();
			if(next == null) break;
			int prevDatum = (Integer)(prev.getDatum());
			int nextDatum = (Integer)(next.getDatum());
			if(prevDatum <= newDatum && nextDatum > newDatum){
				System.out.println("insert");
				prev.setNext(newNode);
				newNode.setNext(next);
				break;
			}else if(next.getNext() == null){
				next.setNext(newNode);
				break;
			}
			prev = next;
			
			
		}
		return headRef;
	}
	
	public static ListCell InsertSort(ListCell headRef){
		ListCell nextCell = headRef.getNext();
		ListCell newList = new ListCell(0, nextCell);
		nextCell = nextCell.getNext();
		int i = 0;
		while(i < 13 && nextCell != null){
			SortedInsert(newList, nextCell);
			System.out.println("insert sort: " + nextCell.getDatum() + " " + nextCell.getNext());
			ListCell temp = nextCell.getNext();
			nextCell = temp;
			i++;
		}
		return newList;
	}
	
	public static ListCell RemoveDuplicates(ListCell head){
		ListCell prevCell = head.getNext();
		ListCell nextCell = prevCell.getNext();
		while(prevCell != null){
			int next = (Integer)nextCell.getDatum();
			int prev = (Integer)prevCell.getDatum();
			if(next == prev){
				prevCell.setNext(nextCell.getNext());
				nextCell = prevCell.getNext();
			} else {
				prevCell = nextCell;
				nextCell = nextCell.getNext();
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
		System.out.print("\nSorted List: ");
		header = InsertSort(header);
//		next = header.getNext();
//		while(next != null){
//			System.out.print(next.getDatum().toString() + " ");
//			next = next.getNext();
//		}
		
		
	}
}
