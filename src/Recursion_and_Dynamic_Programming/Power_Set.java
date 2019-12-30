package Recursion_and_Dynamic_Programming;

import java.util.ArrayList;
import java.util.List;

public class Power_Set {

	public static void main(String[] args) {

		List<Integer> set = new ArrayList<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		ArrayList<ArrayList<Integer>> powerSet = getPowerSet(set,0);
		System.out.println(powerSet);
		
	}

	private static ArrayList<ArrayList<Integer>> getPowerSet(List<Integer> set, int index) {
        
		ArrayList<ArrayList<Integer>> allSubsets = null;
		if(set.size() == index) {
			allSubsets = new ArrayList<ArrayList<Integer>>(); // Intialized
			allSubsets.add(new ArrayList<Integer>()); // EmptySet
		}
		else {
			allSubsets = getPowerSet(set, index+1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> subsetWithAddedItem = new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> subset: allSubsets) {
				ArrayList<Integer> subSetToAddItem = new ArrayList<Integer>();
				subSetToAddItem.addAll(subset);
				subSetToAddItem.add(item);
				subsetWithAddedItem.add(subSetToAddItem);// all subset with new item added
			}
			allSubsets.addAll(subsetWithAddedItem); // all sets will be added
		}
		
		return allSubsets;
	}


}
