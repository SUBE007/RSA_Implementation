import java.util.Scanner;

class Factor
{
	public static void main(String args[])
    {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the value of n: ");
		int n=sc.nextInt();	
		System.out.println("One of the divisors for "+ n + " is "+factorization(n,getRandomNumber(2,n)));
		sc.close();
	}
	public static int factorization(int n, int ri){
			int d=0;
		    if (n == 1)
            {
		        return n;
		    }
            
            if (n % 2 == 0)
            {
		        return 2;
		    }

		    while(true)
            {
		      //we will pick from the range [2, N)
		      int rj = ri;        //j < i
		      ri = getRandomNumber(2, n);
		      d = gcd(Math.abs(ri - rj), n);
		      if (d > 1)
		        break;
		    }
		    return d;
	}
	public static int getRandomNumber(int min, int max)
	{
	    return (int) ((Math.random() * (max - min)) + min);
	}
	static int gcd(int i, int j)
	{
		if(i==0)
			return j;	
		else
			return gcd(j%i,i);
	}	    
}