public class Semi2 {
    public static void main(String[] args) {
        int res = exponentiation(4,4);
        System.out.println(res);

    }
    static int exponentiation(int a, int b){
        if(b==0) return 1;
        return a*exponentiation(a,b-1);
    }

}
