public class Semi1 {
    public static void main(String[] args) {
        int res = TriangularNumber(8);
        System.out.println(res);

    }
    static int TriangularNumber(int value){
        return (value*(value+1))/2;
    }
}
