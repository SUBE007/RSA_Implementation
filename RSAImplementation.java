import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class RSAImplementation {
    public static void main(String[] args)
    {
		 
		Scanner sc=new Scanner(System.in);
		int bits = 1024;
		Random randomInteger = new Random();
		BigInteger p = BigInteger.probablePrime(bits, randomInteger);
		BigInteger q = BigInteger.probablePrime(bits, randomInteger);
   		BigInteger n = p.multiply(q);
   		BigInteger phi = calcuate_Phi(p, q);
     	BigInteger e = BigInteger.probablePrime(bits, randomInteger);
        while (gcd(e,phi).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0)
        {
            e.add(BigInteger.ONE);
        }

 		BigInteger d = modInverse(e, phi)[1];
 		 
		System.out.println("first prime number of p: " + p+"\n");
		System.out.println("Second prime number q: " + q+"\n");
		System.out.println("Value of n: " + n+"\n");
		System.out.println("Value of Phi: " + phi+"\n");
		System.out.println("Value of Public key choosen e: " + e+"\n");
		System.out.println("Corresponding private key d: " + d+"\n");
		
		System.out.print("Enter the Plaintext: ");
        String message = sc.nextLine();
		
		BigInteger cipherMessage = new BigInteger(message.getBytes());
		 
		BigInteger encrypted = encrypt(cipherMessage, e, n);
		 
		BigInteger decrypted = decrypt(encrypted, d, n);
		 
		String restoredMessage = new String(decrypted.toByteArray());

		System.out.println("Original message: " + message+"\n");
		System.out.println("Encrypted: " + encrypted+"\n");
		System.out.println("Decrypted: " + decrypted+"\n");
	 	System.out.println("Decrypted Original message: " + restoredMessage+"\n");
		sc.close();
	}
 	
 	public static BigInteger calcuate_Phi(BigInteger p, BigInteger q) {
		BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
		return phi;
	}
 

	public static BigInteger gcd(BigInteger a, BigInteger b) {
		if (b.equals(BigInteger.ZERO)) {
			return a;
		} else {
			return gcd(b, a.mod(b));
		}
	}

	public static BigInteger[] modInverse(BigInteger a, BigInteger b) {
		if (b.equals(BigInteger.ZERO)) return new BigInteger[] {
			a, BigInteger.ONE, BigInteger.ZERO
		};                                                              // return( a, 1, 0 ) if b=0
		BigInteger[] vals = modInverse(b, a.mod(b));
		BigInteger d = vals[0];
		BigInteger p = vals[2];
		BigInteger q = vals[1].subtract(a.divide(b).multiply(vals[2]));
		return new BigInteger[] {
			d, p, q
		};
	}
 	

	public static BigInteger encrypt(BigInteger message, BigInteger e, BigInteger n) {
		return message.modPow(e, n);
	}

	public static BigInteger decrypt(BigInteger message, BigInteger d, BigInteger n) {
		return message.modPow(d, n);
	}

	
}