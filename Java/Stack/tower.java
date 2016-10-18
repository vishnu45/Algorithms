/* --------------------------------------------------------
	Tower of Hanoi implementation
-------------------------------------------------------- */
import java.util.Stack;
public class tower {		

	private Stack<Integer> disks;	// each tower
	public int diskNo;				// which disk(rod)

	// creates a tower (stack) with index the number of disks
	public tower(int i) {
		disks = new Stack<Integer>();
		diskNo = i;
	}

	// adds a disk to the tower
	public void add(int i) {
		// check the disk is placed according to rules
		// only smaller disks should be placed on top of others
		if (!disks.empty() && i > disks.peek()) {
			System.out.println("Error in placing disk");
			return;
		}
		disks.push(i);
		return;
	}

	// move top to another tower
	public void moveTopTo(tower t) {
		int top = disks.pop();
		t.add(top);
		System.out.println("Moving disk " + top + " from Tower#" 
			+ this.diskNo + " to Tower#" + t.diskNo);
	}

	// move disks from a tower to a tower given an aux tower
	public static void moveDisks(int n, tower from, tower aux, tower to) {
		if (n==1) {
			from.moveTopTo(to);
			return;
		}
		moveDisks(n-1, from, to, aux);
		from.moveTopTo(to);
		moveDisks(n-1, aux, from, to);
	}

	// returns string representation of tower
	public String toString() {
		return disks.toString();
	}

	// ------------------------ MAIN ------------------------
	public static void main(String[] args) {
		tower A = new tower(1);
		A.add(5); A.add(4); A.add(3); A.add(2); A.add(1);
		tower B = new tower(2);
		tower C = new tower(3);
		System.out.println("Before:");
		System.out.println("A: " + A.toString());
		System.out.println("B: " + B.toString());
		System.out.println("C: " + C.toString());
		moveDisks(5, A, B, C);
		System.out.println("After:");
		System.out.println("A: " + A.toString());
		System.out.println("B: " + B.toString());
		System.out.println("C: " + C.toString());
	}
}