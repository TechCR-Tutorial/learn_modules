package design.first;

public enum ChannelCategory {
    CHILD(0),
    ADULT(18),
    ELDER(45),
    ALL(0);
   
   private  int limit;

   ChannelCategory(int limit) {
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }
}
