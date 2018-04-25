package application;

public class NameRes {

	public String name;
	public int res;
   
    public NameRes(String name, int res) {
        this.name = name;
        this.res=res;
    }
    
    public NameRes()
    {
    	
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }
}
