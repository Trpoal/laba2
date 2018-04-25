package application;

public class User {

    private String ex;
    private int right;
    private int ans;
    private boolean pr;

    public User(String ex, int right, int ans, boolean pr) {
        this.ex = ex;
        this.right = right;
        this.ans = ans;
        this.pr = pr;
    }

    public User() {
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getAns() {
        return ans;
    }

    public void setAns(int ans) {
        this.ans = ans;
    }

    public boolean getPr() {
        return pr;
    }

    public void setPr(boolean pr) {
        this.pr = pr;
    }
   
}
