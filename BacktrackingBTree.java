import java.util.LinkedList;
import java.util.List;

public class BacktrackingBTree<T extends Comparable<T>> extends BTree<T> {
	public void Backtrack() {
		Node<T> currkey=LastIn.pop();
		Node<T> merger=getNode(currkey.getKey(0));
		delete(currkey.getKey(0),merger);
		if(!currkey.SaverStack.isEmpty())
			merge(currkey);
	}

	private void delete(T curr, Node<T> deleteme){
//		if(deleteme.numOfKeys==1)						//the Node is a Root
//			root=null;
//		else{
		deleteme.removeKey(curr);
//		}
	}

	private void merge(Node<T> curr){
		while (!curr.SaverStack.isEmpty()) {
			Node<T> mid = curr.SaverStack.pop();                                                            //the mid key
			Node<T> left = curr.SaverStack.pop();                                                               //the left side
			Node<T> right = curr.SaverStack.pop();                                                          //the right side
			Node<T> deleteme=getNode(mid.getKey(0));
			delete(deleteme.getKey(0),deleteme);
			left.addKey(mid.getKey(0));
			for (int i = 0; i < right.numOfKeys; i++) {
				deleteme=getNode(right.getKey(i));
				delete(right.getKey(i),deleteme);
				left.addKey(right.getKey(i));
			}
			if(mid.parent==null) {
				left.parent = null;
				left.IsRoot=true;
				root=left;
			}
			else {
				left.parent=mid.parent;
//				mid.parent.removeChild(mid);
				mid.parent.addChild(left);
//				right.parent.removeChild(right);



//				mid.parent.addChild(left);
//				left.parent=mid.parent;
//				delete(mid.getKey(0),mid);
//				for(int i=0;i<right.numOfKeys;i++) {
//					delete(right.getKey(i),right);
//				}



//				Node<T> tempfather=left.parent;
//				this.getNode(tempfather.getKey(0)).removeChild(0);
//				tempfather=mid.parent;
//				left.parent = tempfather;
//				this.getNode(tempfather.getKey(0)).addChild(left);
////				mid.parent.addChild(left);
//				this.getNode(tempfather.getKey(0)).removeChild(tempfather.numOfChildren/2);
////				mid.parent.removeChild((mid.parent.numOfChildren/2));
//				tempfather=right.parent;
//				this.getNode(tempfather.getKey(0)).removeChild(tempfather.numOfChildren);
////				right.parent.removeChild(right.parent.numOfChildren);
			}
		}
	}




























//	//You are to implement the function Backtrack.
//	public void Backtrack() {
//		Node<T> current=LastIn.pop();
//
//
//
//
//
//
//
//
//		//		Node<T> currkey=LastIn.pop();
////		Node<T> merger=getNode(currkey.getKey(0));
//
////		delete(currkey.getKey(0),merger);
////		if(!currkey.SaverStack.isEmpty())
////			merge(currkey);
//    }
//
////    private void delete(T curr, Node<T> deleteme){
//////		if(deleteme.numOfKeys==1)						//the Node is a Root
//////			root=null;
//////		else{
////			deleteme.removeKey(curr);
//////		}
////	}
//
//    private void merge(Node<T> curr){
//		while (!curr.SaverStack.isEmpty()) {
////			Node<T> mid = curr.SaverStack.pop();                                                            //the mid key
////			Node<T> left = curr.SaverStack.pop();                                                               //the left side
////			Node<T> right = curr.SaverStack.pop();                                                          //the right side
////			Node<T> deleteme=right.parent;
////			int index=deleteme.indexOf(right);
////			deleteme.removeChild(index);
////			if(mid.parent==null) {
////				left.parent = null;
////				left.IsRoot=true;
////				root=left;
////			}
////			else {
////				left.parent=mid.parent;
////				mid.parent.removeChild(mid);
////				mid.parent.addChild(left);
////				right.parent.removeChild(right);
//
//
//
////				mid.parent.addChild(left);
////				left.parent=mid.parent;
////				delete(mid.getKey(0),mid);
////				for(int i=0;i<right.numOfKeys;i++) {
////					delete(right.getKey(i),right);
////				}
//
//
//
////				Node<T> tempfather=left.parent;
////				this.getNode(tempfather.getKey(0)).removeChild(0);
////				tempfather=mid.parent;
////				left.parent = tempfather;
////				this.getNode(tempfather.getKey(0)).addChild(left);
//////				mid.parent.addChild(left);
////				this.getNode(tempfather.getKey(0)).removeChild(tempfather.numOfChildren/2);
//////				mid.parent.removeChild((mid.parent.numOfChildren/2));
////				tempfather=right.parent;
////				this.getNode(tempfather.getKey(0)).removeChild(tempfather.numOfChildren);
//////				right.parent.removeChild(right.parent.numOfChildren);
//			}
//		}
//	}




	//Change the list returned to a list of integers answering the requirements
	public static List<Integer> BTreeBacktrackingCounterExample(){
	 List<Integer> example=new LinkedList<>();
	 example.add(30);
	 example.add(40);
	 example.add(57);
	 example.add(50);
	 example.add(42);
	 example.add(60);
	 return example;
	}


	public static<T> void main (String[] args){
		BacktrackingBTree<Integer> t=new BacktrackingBTree<>();
		t.insert(3);
		System.out.println("after inserting 3: " + t.toString());
//		t.Backtrack();
//		System.out.println("after bt 3: " +t.toString());
		t.insert(5);
		System.out.println("after inserting 5: "+t.toString());
//		t.Backtrack();
//		System.out.println("after bt 5: " + t.toString());
		t.insert(2);
		System.out.println("after inserting 2: "+t.toString());
//		t.Backtrack();
//		System.out.println("after bt 2 : " + t.toString());
		t.insert(10);
		System.out.println("after inserting 10: " +t.toString());
//		t.Backtrack();
//		System.out.println("after bt 10: "+t.toString());
		t.insert(20);
		System.out.println("after inserting 20: " +t.toString());
//		t.Backtrack();
//		System.out.println("after bt 20: " + t.toString());
		t.insert(18);
		System.out.println("after inserting 18: " +t.toString());
		t.Backtrack();
		System.out.println("after bt 18: " + t.toString());
//		t.insert(40);
//		System.out.println(t.toString());
//		t.insert(9);
//		System.out.println(t.toString());
//		t.insert(4);
//		System.out.println(t.toString());
//		t.insert(7);
//		System.out.println(t.toString());
//		t.insert(8);
//		System.out.println(t.toString());
	}


}
