package shop.data;

import java.lang.Comparable;

/**
 * <p>An immutable video object.</p>
 *
 * <p>Comprises a triple: title, year, director.</p>
 *
 * <p><b>Object invariant:</b></p>
 * <ul>
 *   <li>title is non-null, no leading or final spaces, not empty string</li>
 *   <li>year is greater than 1800, less than 5000</li>
 *   <li>director is non-null, no leading or final spaces, not empty string</li>
 * </ul>
 * @see Data
 */
public interface Video extends Comparable {

  public String director();

  public String title();

  public int year();

  
  public boolean equals(Object thatObject);

  public int hashCode();

  
  public int compareTo(Object thatObject);

 
  public String toString();
}
