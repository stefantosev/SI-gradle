package  mk.ukim.finki;

class Calculator{
    public double divide(double a, double b){
        if(b==0){
            throw new RuntimeException("Can not divide by zero");
        }
        return a/b;
    }

    public int calculateTotalInInterval(int from, int to){
        int total = 0;
        for(int i= from; i<to; i++){
            total +=i;
        }
        return total;
    }
}