public class Run extends Entry{
    private int recovery;
    private int repetitions;

    public Run(String n, int d, int m, int y, int h, int min, int s, float dist, int repetitions, int recovery){
        super(n,d,m,y,h,min,s,dist);
        this.repetitions = repetitions;
        this.recovery = recovery;
    }

    public int getRepetitions(){
        return repetitions;
    }
    public int getRecovery(){
        return recovery;
    }

    public String getEntry(){
        String result = getName()+" ran " + getDistance() + " km in "
                +getHour()+":"+getMin()+":"+ getSec() + " on "
                +getDay()+"/"+getMonth()+"/"+getYear()+ " with repetitions: " + getRepetitions()
                + " and recovery: "+ getRepetitions() + "\n";
        return result;
    }

}
