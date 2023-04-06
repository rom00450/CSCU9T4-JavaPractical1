// An implementation of a Training Record as an ArrayList


import java.util.*;


public class TrainingRecord {
    private List<Entry> tr;
    
    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    } //constructor
    
    // add a record to the list
   public void addEntry(Entry e){
        if (!tr.contains(e)) {
            tr.add(e);
        }
        else{
            System.out.println("Could not add entry");
        }
   } // addClass
   
   // look up the entry of a given day and month
   public String lookupEntry (int d, int m, int y) {
       ListIterator<Entry> iter = tr.listIterator();
       String result = "No entries found";
       while (iter.hasNext()) {
          Entry current = iter.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y)
          result = current.getEntry();
          }
       return result;
   } // lookupEntry

    public String lookupAllEntry (int d, int m, int y) {
        ListIterator<Entry> iter = tr.listIterator();
        String result = "No entries found";
        ArrayList<String> results = new ArrayList();
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getDay()==d && current.getMonth()==m && current.getYear()==y)
                results.add(current.getEntry());
        }
        return results.toString();
    } // lookupEntry
   
   // Count the number of entries
   public int getNumberOfEntries(){
       return tr.size();
   }
   // Clear all entries
   public void clearAllEntries(){
       tr.clear();
   }

   public String removeEntry(int d, int m, int y){
       ListIterator<Entry> iter = tr.listIterator();
       String result = "Entry removed";
       while(iter.hasNext()){
           Entry current = iter.next();
           if (current.getDay()==d && current.getMonth()==m && current.getYear()==y){
               tr.remove(current);
           }
       }
       return result;
   }

   
} // TrainingRecord