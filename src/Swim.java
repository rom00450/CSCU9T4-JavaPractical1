public class Swim extends Entry{
    private String where;

    public Swim(String n, int d, int m, int y, int h, int min, int s, float dist, String where){
        super(n,d,m,y,h,min,s,dist);
        this.where = where;
    }

    public String getWhere(){
        return where;
    }

    public String getEntry(){
        String result = getName()+" swam " + getDistance() + " km in "
                +getHour()+":"+getMin()+":"+ getSec() + " on "
                +getDay()+"/"+getMonth()+"/"+getYear()+ " Where?: " + getWhere() + "\n";
        return result;
    }

}
