package secondHW;


public class MyLinked {
    static class Node {
        public Node() { }
        public double item;
        public Node next;
    }

    int N;
    Node first;
    
    public MyLinked () {
        first = null;
        N = 0;
        assert checkInvariants ();
    }


    private boolean checkInvariants() {
        assert((N != 0) || (first == null));
        Node x = first;
        for (int i = 0; i < N; i++) {
            if (x==null) {
                return false;
            }
            x = x.next;
        }
        assert(x == null);
        return true;
    }

    public boolean isEmpty () { return first == null; }
    public int size () { return N; }
    public void add (double item) {
        Node newfirst = new Node ();
        newfirst.item = item;
        newfirst.next = first;
        first = newfirst;
        N++;
    }


    // delete the kth element
    public void delete (int k) {
        if (k < 0 || k >= N) throw new IllegalArgumentException ();
        
        boolean deleteNode = false;
		if(k==0 && N==1) {
        	first = null;
        	deleteNode = true;
        }
  
        if(!deleteNode && k==1 && N==2) {
        	first.next = null;
        	deleteNode = true;
        }
        
        if(!deleteNode && k==0) {
        	first = first.next;
        	deleteNode = true;
        }
        
        if(!deleteNode && k==N-1) {
        	Node x = first;
            for (int i = 0; i < N; i++) {
                if (i==N-2) {
                    x.next = null;
                    deleteNode = true;
                    break;
                }
                x = x.next;
            }
        }
        
        if(!deleteNode) {
        	Node x = first;
        	for(int i = 1; i < N; i++) {
        		if(k==i) {
        			x.next = x.next.next;
        			deleteNode = true;
        			break;
        		}
        		x = x.next;
        	}
        }
        
        assert deleteNode;
        N--;
        assert checkInvariants ();
    }

    // reverse the list "in place"... without creating any new nodes
    public void reverse () {
    if(N == 0 || N ==1) {
        }
        else if (N == 2) {
        	Node last = first;
            first = first.next;
            first.next = last;
            last.next = null;
        }
        else {
        	Node prev = first;
        	Node curr = first.next;
        	Node last = curr.next;
        	first.next = null;
        	first = curr;
        	curr.next = prev;        	
        	
        	while (last != null) {
        		prev = curr;
        		curr = last;
        		last = last.next;
        		curr.next = prev;
        		first = curr;
        	}
        }
        assert checkInvariants ();
    }

    // remove 
    public void remove (double item) {
    	if(first==null) return;
    	while(first!=null && first.item==item) {
    		if(first.next==null) { 
    			first = null; 
    			N--;
    		}
    		else { 
    			first = first.next;
    			N--;
    		}
    	}
  
		Node firstNode = first;
		Node secNode = first;
		while(firstNode!=null) {
			while(firstNode!=null && firstNode.item!=item) {
				secNode = firstNode;
				firstNode = firstNode.next;
			}
			if(firstNode==null) { return; }
			secNode.next = firstNode.next; 
			firstNode = firstNode.next;
			N--;}    
        assert checkInvariants ();}}
    

// TODO: CONVERT THE FOLLOWING TO JUNIT TESTS

  
