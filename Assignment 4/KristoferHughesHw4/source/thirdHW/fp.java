package thirdHW;

//Kristofer Hughes
//Object Oriented Software Development

import java.util.List;
import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class fp {
	
static <U,V> List<V> map(Iterable<U> l, Function<U,V> f) {
	List<V> mapList = new ArrayList<V>();
		for (Iterator<U> iterator = l.iterator(); iterator.hasNext();) { //using hasNext
			mapList.add(f.apply(iterator.next()));
		}
		return mapList;}



static <U,V> V foldLeft(V e, Iterable<U>l, BiFunction<V,U,V> f){
	if (l != null) {
			if (l.iterator().hasNext() && l != null) {
				List<U> leftList = new ArrayList<>(); 
				l.forEach(leftList::add);
				return foldLeft(f.apply(e, l.iterator().next()), leftList.subList(1, leftList.size()), f);
			} else
				return e;
		} else
			return e; }




static <U,V> V foldRight(V e, Iterable<U>l, BiFunction<U,V,V> f){
	 for(U u:l) { //new method to avoid using .compare
	      e = f.apply(u, e);
	   }
	return e;}




static <U> Iterable<U> filter(Iterable<U> l, Predicate<U> p){
	List<U> result = new ArrayList<>();
    for(U item: l){
        if(p.test(item)){
            result.add(item);
        }
    }
    return result;
}

static <U> U minVal(Iterable<U> l, Comparator<U> c){
	 return foldLeft(l.iterator().next(), l, (u, u2) -> c.compare(u, u2) < 0 ? u : u2);}

static <U extends Comparable<U>> int minPos(Iterable<U> l){
	  U posVar = null;
      int posVar2 = -1;
      for(U u: l) {
        if(u != null) {
          if(posVar == null) {
            posVar = u;
          } else {
            if(posVar.compareTo(u) > 0) {
              posVar = u;
              posVar2 = 0;   } } }}
      return posVar2; }


	public static void main(String[] args) {
		// (1) Use map to implement the following behavior (described in Python).  i.e given a List<T> create a List<Integer> of the hashes of the objects.
		// names = ['Mary', 'Isla', 'Sam']
		
		
		// (2) Use foldleft to calculate the sum of a list of integers.
		// i.e write a method: int sum(List<Integer> l)
		
		// (3) Use foldRight to concatenate a list of strings i.e write a method
		// String s (List<String> l)
		
		// (4) consider an array of Persons. Use filter to 
		// print the names of the Persons whose salary is
		// greater than 100000
		
		// (5) Use minVal to calculate the minimum of a List of 
		//       Integers
		
        // (6) Use minVal to calculate the maximum of a List of 
		//       Integers
		
		// (7)  Use minPos to calculate the position of the
		// minimum in  a List of  Integers

		// (8)  Use minPos to calculate the position of the
		// minimum in  a List of  String

	}

}

class Person{
	final int salary;
	final String name;
	
	Person(int salary, String name){
		this.salary = salary;
		this.name = name;
	}
	
	int getSalary() { return salary; }
	String name() { return name;}
	
}