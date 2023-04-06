public class Cycle extends Entry{
    private String terrain;
    private String tempo;

    public Cycle(String n, int d, int m, int y, int h, int min, int s, float dist, String terrain, String tempo){
        super(n,d,m,y,h,min,s,dist);
        this.terrain = terrain;
        this.tempo = tempo;
    }

    public String getTempo(){
        return tempo;
    }

    public String getTerrain(){
        return terrain;
    }

    public String getEntry(){
        String result = getName()+" cycled " + getDistance() + " km in "
                +getHour()+":"+getMin()+":"+ getSec() + " on "
                +getDay()+"/"+getMonth()+"/"+getYear()+ " on " + getTerrain()
                + " at "+ getTempo() + " tempo" + "\n";
        return result;
    }

}
