package shop.data;

/**
 * Implementation of Video interface.
 * @see Data
 */
final class VideoObj implements Video {
  private final String _title;
  private final int    _year;
  private final String _director;

  /**
   * Initialize all object attributes.
   * Title and director are "trimmed" to remove leading and final space.
   * @throws IllegalArgumentException if object invariant violated.
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
	  if(thatObject!=null){
		if ((this.hashCode()==thatObject.hashCode())) {
			return true;
		}
	  }
		return false;
	}

  public int hashCode() {
		int hashcode = 17;
		hashcode = 37 * hashcode + _title.hashCode();
		hashcode = 37 * hashcode + _year;
		hashcode = 37 * hashcode + _director.hashCode();
		return hashcode;
	}

  public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(this.title());
		result.append(" (");
		result.append(this.year());
		result.append(") : ");
		result.append(this.director());
		return result.toString();
}


public int compareTo(Object thatObject) {
	{  VideoObj that = (VideoObj) thatObject;
	  int tester = _title.compareTo(that.title());
	  if(tester != 0) {
		  return tester;
	  }
	  int tester2 = Integer.compare(_year,that.year());
	  if(tester2 != 0) {
		  return tester2;
	  }
	  int tester3 = _director.compareTo(that.director());
	  if(tester3 != 0) {
		  return tester3;
	  }
	  
	  return 0;}
}
}