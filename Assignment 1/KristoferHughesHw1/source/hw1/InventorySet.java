package hw1;
//Kristofer Hughes
//SE 350

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;

// TODO:  complete the methods
/**
 * An Inventory implemented using a <code>HashMap&lt;Video,Record&gt;</code>.
 * Keys are Videos; Values are Records.
 *
 * @objecttype Mutable Collection of Records
 * @objectinvariant
 *   Every key and value in the map is non-<code>null</code>.
 * @objectinvariant
 *   Each value <code>r</code> is stored under key <code>r.video</code>.
 */
final class InventorySet {
  /** @invariant <code>_data != null</code> */
  private final Map<VideoObj,Record> _data;

  InventorySet() {
    _data = new HashMap<VideoObj,Record>();
  }

  
  public int size() {
	    return _data.size();
	}

	
	public Record get(VideoObj v) {
	  
	      Record r = _data.get(v);
	      if (r == null)
	          return null;
	  
	      return r.copy();
	}

	
	public Collection<Record> toCollection() {
		Collection<Record> collect_output = new ArrayList<Record>();
		collect_output = _data.values();
		return collect_output;
	}

	public void addNumOwned(VideoObj video, int change) {
		 if ( video == null || change == 0)
	          throw new IllegalArgumentException("Value for video is null, or change equals 0");
	      if ( !_data.containsKey(video) && change > 0){
	          Record newRec = new Record(video, change, 0, 0);
	          _data.put(video, newRec);
	      }
	      else if (_data.containsKey(video)){
	          Record newRec = _data.get(video);
	          if ((newRec.numOwned + change) == 0){
	              if( newRec.numOut > 0)
	                  throw new IllegalArgumentException("Cannot remove checked out copies.");
	              _data.remove(video);}
	          else if ((newRec.numOwned + change) < newRec.numOut )
	              throw new IllegalArgumentException("Cannot check out more than owned amount.");
	          newRec.numOwned += change;
	      }
	}

	public void checkOut(VideoObj video) {
		if (_data.containsValue(_data.get(video)) == false
				|| (_data.get(video).numOut) == (_data.get(video).numOwned)) {
			throw new IllegalArgumentException("No record found for Video, or numOut is equal to numOwned!");
		}
		_data.get(video).numOut += 1;
	}

	
	public void checkIn(VideoObj video) {
		if (_data.containsValue(_data.get(video)) == false || (_data.get(video).numOut < 0)) {
			throw new IllegalArgumentException("No record found for Video, or numOut is a non-positive!");
		}
		_data.get(video).numOut -= 1;
	}
	

	
	public void clear() {
	      _data.clear();
	}

  /**
   * Return the contents of the inventory as a string.
   */
  public String toString() {
    StringBuffer buffer = new StringBuffer();
    buffer.append("Database:\n");
    for (Record r : _data.values()) {
      buffer.append("  ");
      buffer.append(r);
      buffer.append("\n");
    }
    return buffer.toString();
  }
}
