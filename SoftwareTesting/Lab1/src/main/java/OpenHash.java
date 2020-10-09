import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OpenHash {
    final long bit = 1 << 31;
    private final Integer mod = 13;
    private final List<LinkedList<Integer>> hashInteger;
    private final List<LinkedList<String>> hashString;
    private int size;

    public OpenHash(){
        hashInteger = new ArrayList<>(mod);
        hashString = new ArrayList<>(mod);
        size = 0;
        init();
    }

    private long xor(long source){
        long valueToXor = 0;
        for(int i=0;i<4;i++){
            valueToXor += (source & bit)!=0? 1<<(21-i) : 0;
            source = source << 1;
        }
        return source ^ valueToXor;
    }

    /**
     * Convert String to Integer
     * @param source : String
     * @return number
     */
    protected Integer convertStringtoInteger(String source){
        if (source== null) return 0;
        long res = 0;
        for(int i=source.length()-1; i>=0;i--){
            if (i <source.length()) res = xor(res);
            res += source.charAt(i);
        }
        return (int)(res % mod);
    }


    /**
     * Init new hash
     */
    private void init(){
        for(int i=0;i<mod;i++){
            hashInteger.add(null);
            hashString.add(null);
        }
    }

    /**
     *
     */
    private boolean checkSizeHashInteger(){
        for (int i =0; i< hashInteger.size();i++){
            if (hashInteger.get(i)!= null) return false;
        }

        return true;
    }

    /**
     * Add new item to hash. If hash is Integer hash, and value is String, so don't do anythin
     * @param value : {String, Integer}
     */
    public void add(Object value){
        Integer newValue ;
        try {
            newValue = (Integer) value;

            if (hashInteger.get(newValue % mod) == null){
                hashInteger.set(newValue % mod,new LinkedList<>());
            }
            hashInteger.get(newValue % mod).add(newValue);
        }
        catch (ClassCastException e){
            String source = (String)value;
            if (!checkSizeHashInteger()) return;
            newValue = convertStringtoInteger(source);
            if (hashString.get(newValue % mod) == null) {
                hashString.set(newValue % mod,new LinkedList<>());
            }
            hashString.get(newValue % mod).add(source);
        }
        this.size++;
    }

    /**
     * Find a item from hash
     * @param value : {String, Integer}
     * @return True if item in hash, otherwise False
     */
    public boolean find(Object value){
        Integer newValue ;
        try {
            newValue = (Integer) value;
            if (hashInteger.get(newValue % mod) == null) return false;
            if (hashInteger.get(newValue % mod).contains(newValue)) return true;
        }
        catch (ClassCastException e){
            String source = (String)value;
            if (!checkSizeHashInteger()) return false;
            newValue = convertStringtoInteger(source);
            if (hashString.get(newValue % mod) == null) return false;
            if (hashString.get(newValue % mod).contains(source)) return true;
        }
        return false;
    }

    /**
     * Delete item from hash
     * @param value : {String, Integer}
     * @return True if item is successfully deleted, otherwise False
     */
    public boolean delete(Object value){
        Integer newValue ;
        try {
            newValue = (Integer) value;

            if (hashInteger.get(newValue % mod)!= null && hashInteger.get(newValue % mod).contains(newValue)) {
                hashInteger.get(newValue % mod).remove(newValue);
                this.size--;
                return true;
            }
            return false;
        }
        catch (ClassCastException e){
            String source = (String)value;
            if (!checkSizeHashInteger()) return false;
            newValue = convertStringtoInteger(source);
            if (hashString.get(newValue % mod)==null) return false;

            if (hashString.get(newValue % mod).contains(source)){
                hashString.get(newValue % mod).remove(source);
                this.size--;
                return true;
            }
            return false;
        }

    }

    /**
     * Count how many item has the same value value
     * @param value : {String, Integer}
     * @return size of hash value array
     */
    public int getSizeHashValue(Object value){
        Integer newValue;
        try{
            newValue = (Integer) value;
            if (hashInteger.get(newValue % mod) == null) return 0;
            return hashInteger.get(newValue % mod).size();
        }catch (ClassCastException e){
            String source = (String)value;
            newValue = convertStringtoInteger(source);
            if (hashString.get(newValue % mod) == null) return 0;
            return hashString.get(newValue % mod).size();
        }
    }

    /**
     * Get size of hash
     * @return
     */
    public int getSize(){
        return this.size;
    }


    /**
     * Remove all items in hash
     */
    public void clean(){
        init();
    }
}
