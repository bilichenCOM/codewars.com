public class Fracts {
  // your code
  public static String convertFrac(long[][] lst) {
    // your code
    String res = "";
    long lcd = 0;
    long scp = 0;
    long[] num = new long[lst.length];
    long[] den = new long[lst.length];

    for(int i = 0; i<lst.length; i++) {
      num[i] = lst[i][0];
      den[i] = lst[i][1];
      lcd=getLcd(num[i],den[i]);
      num[i]/=lcd;
      den[i]/=lcd;
    }
    
    if(den.length==1) scp=den[0];
    
    for(int i = 1; i<den.length; i++) {
      long x = den[i-1];
      long y = den[i];
      
      lcd=getLcd(x,y);
      scp=x*y/lcd;
      
      den[i]=scp;
    }
    
    for(int i = 0; i<num.length; i++) {
      num[i]=lst[i][0]*scp/lst[i][1];
      res+=String.format("(%d,%d)",num[i],scp);
    }
    
    return res;
  }
  public static long getLcd(long a, long b) {
    
      while(a%b!=0) {
        a%=b;
        a=a+b;
        b=a-b;
        a=a-b;
      }
      
      return b;
  }

}