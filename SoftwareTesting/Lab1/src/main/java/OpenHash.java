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

    protected Integer convertStringtoInteger(String source){
        if (source== null) return 0;
        long res = 0;
        for(int i=source.length()-1; i>=0;i--){
            if (i <source.length()) res = xor(res);
            res += source.charAt(i);
        }
        return (int)(res % mod);
    }



    private void init(){
        for(int i=0;i<mod;i++){
            hashInteger.add(null);
            hashString.add(null);
        }
    }

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
            newValue = convertStringtoInteger(source);
            if (hashString.get(newValue % mod) == null) {
                hashString.set(newValue % mod,new LinkedList<>());
            }
            hashString.get(newValue % mod).add(source);
        }
        size++;
    }

    public boolean find(Object value){
        Integer newValue ;
        try {
            newValue = (Integer) value;
            if (hashInteger.get(newValue % mod) == null) return false;
            if (hashInteger.get(newValue % mod).contains(newValue)) return true;
        }
        catch (ClassCastException e){
            String source = (String)value;
            newValue = convertStringtoInteger(source);
            if (hashString.get(newValue % mod) == null) return false;
            if (hashString.get(newValue % mod).contains(source)) return true;
        }
        return false;
    }


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
    public int getSize(){
        return this.size;
    }

    public void clean(){
        init();
    }
}
