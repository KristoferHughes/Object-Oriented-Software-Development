package shop.data;

/**
 * <p>Public view of an inventory record.</p>
 *
 * <p>Records are mutable, but cannot be changed outside the package.</p>
 * 
 * <p>This interface should not be implemented outside the package.</p>
 * 
 * <p><code>equals</code> and <code>hashCode</code> delegate to the
 * underlying Video object.</p>
 * @see Data
 */
public interface Record {
  
  public Video video();
  public int numOwned();
  public int numOut();
  public int numRentals();
  public boolean equals(Object thatObject);
  public int hashCode();
  public String toString();
}
