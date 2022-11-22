import java.util.Scanner;

public class ExtendedEuclidAlgo {
    public static int[] gcdOfTwoNumberUsingExtendedAlgo(int a, int b) {
        if (b == 0){
            int arr[]={a,1,0};
             return arr;
        }
        int[] result = gcdOfTwoNumberUsingExtendedAlgo(b, a % b);
        int gcd = result[0], x1 = result[1], y1 = result[2];
        int x = y1;
        int y = x1 - (a / b) * y1;
        int brr[]={gcd,x,y};
        return brr;
          
     }
   static int multiplicative_Inverse(int e, int r){

       for (int i = 1; i < r; i++)
           if (((e % r) * (i % r)) % r == 1)
               return e;
       return 1;
   }

   public static double calculateCubeRoot(double num){
    return  Math.cbrt(num);
   }

public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("enter the value of and b:");
    int a=sc.nextInt();
    int b=sc.nextInt();
    int crr[]=ExtendedEuclidAlgo.gcdOfTwoNumberUsingExtendedAlgo(a, b);
    System.out.println("gcd is:"+crr[0]);

    System.out.println("Enter first cipher text: ");
    int c1=sc.nextInt();
    System.out.println("Enter Modlus for the first party: ");
    int n1=sc.nextInt();
    System.out.println("Enter second cipher text: ");
    int c2=sc.nextInt();
    System.out.println("Enter Modlus for the second party: ");
    int n2=sc.nextInt();
    System.out.println("Enter third cipher : ");
    int c3=sc.nextInt();
    System.out.println("Enter Modlus for the third party: ");
    int n3=sc.nextInt();

    int M=(n1*n2*n3);
    int M1=(n1*n2*n3)/n1;
    int M2=(n1*n2*n3)/n2;
    int M3=(n1*n2*n3)/n3;

    int N1=multiplicative_Inverse(M1, n1);
    int N2=multiplicative_Inverse(M2, n2);
    int N3=multiplicative_Inverse(M3, n3);

    int m=((M1*N1*c1) +(M2*N2*c2)+(M3*N3*c3))%M;
    double message=calculateCubeRoot(m);
    System.out.println("value of the  :"+message);
    sc.close();
  }
}
