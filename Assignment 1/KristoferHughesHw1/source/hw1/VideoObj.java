package hw1;
//Kristofer Hughes
//SE 350
/**
 * Immutable Data Class for video objects.
 * Comprises a triple: title, year, director.
 *
 * @objecttype Immutable Data Class
 * @objectinvariant
 *   Title is non-null, no leading or final spaces, not empty string.
 * @objectinvariant
 *   Year is greater than 1800, less than 5000.
 * @objectinvariant
 *   Director is non-null, no leading or final spaces, not empty string.
 */
final class VideoObj implements Comparable<VideoObj> {
  /** @invariant non-null, no leading or final spaces, not empty string */
  private final String _title;
  /** @invariant greater than 1800, less than 5000 */
  private final int    _year;
  /** @invariant non-null, no leading or final spaces, not empty string */
  private final String _director;

  /**
   * Initialize all object attributes.
   * Title and director are "trimmed" to remove leading and final space.
   * @throws IllegalArgumentException if any object invariant is violated.
   */
  VideoObj(String title, int year, String director) {

		_title = title;
		if (_title == null || _title == "" || _title == " " ) {
			throw new IllegalArgumentException("title must be non-null");}
		
		_year = year;
		
		if (_year <= 1800 || _year >= 5000 ) {
			throw new IllegalArgumentException("year must be greater than 1800, less than 5000");}
		_director = director;
		if (_director == null ) {
			throw new IllegalArgumentException("director cannot be null");}
		
	}

	public String director() {
		return _director.trim();
	}

	public String title() {
		return _title.trim();
	}


	public int year() {
		return _year;
	}

	
	public boolean equals(Object thatObject) {
		if (this == thatObject) {
			return true;
		}
		if ((this.getClass().equals(thatObject.getClass()))) {
			return true;
		}
		return thatObject.equals(this) && this.equals(thatObject);
	}

	
	public int hashCode() {
		int hashcode = 17;
		hashcode = 37 * hashcode + _title.hashCode();
		hashcode = 37 * hashcode + _year;
		hashcode = 37 * hashcode + _director.hashCode();
		return hashcode;
	}

	public int compareTo(VideoObj that) {
		int check = that._title.compareTo(_title);
		if (check != 0) {
			return check;
		}
		if (_year - that._year != 0) {
			return _year - that.year();
		}
		check = _director.compareTo(that.director());
		if (check != 0) {
			return check;
		}
		return 0;
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(this.title());
		result.append(" (");
		result.append(this.year());
		result.append(") : ");
		result.append(this.director());
		return result.toString();
		
    //return "El Mariachi (1996) : Rodriguez";
  }
}
