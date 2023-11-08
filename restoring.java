import java.util.*;
//Python program to divide two
// unsigned integers using
// Restoring Division Algorithm
public class restoring {
	// Function to add two binary numbers
	public static String add(String A, String M)
	{
		int carry = 0;
		StringBuilder Sum = new StringBuilder();
		// Iterating through the number
		// A. Here, it is assumed that
		// the length of both the numbers
		// is same
		for (int i = A.length() - 1; i >= 0; i--)
		{
			//Adding the values at both
			// the indices along with the
			//carry
			int temp
					= Character.getNumericValue(A.charAt(i))
					+ Character.getNumericValue(M.charAt(i))
					+ carry;
			// If the binary number exceeds 1
			if (temp > 1) {
				Sum.append(temp % 2);
				carry = 1;
			}
			else {
				Sum.append(temp);
				carry = 0;
			}
		}
		// Return the sum from Most Significant to Low Significant
		return Sum.reverse().toString();
	}
	// Function of find the complement of the binary number
	public static String complement(String m)
	{
		StringBuilder M = new StringBuilder();

		// Iterating through the number
		for (int i = 0; i < m.length(); i++)
		{
			// Computing the Complement
			M.append(
					(Character.getNumericValue(m.charAt(i)) + 1)
							% 2);
		}
		// Adding 1 to the computed value
		M = new StringBuilder(add(M.toString(), "0001"));
		return M.toString();
	}
	// Function to find the quotient and remainder
	// Using Restoring Division
	public static void restoringDivision(String Q, String M,
										String A)
	{
		int count = M.length();
		//Printing the initial values
		// of the accumulator, dividend
		// and divisor
		System.out.println("Initial Values: A:" + A
				+ " Q:" + Q + " M:" + M);
		// The number of steps is equal to the 
		// length of the binary number
		while (count > 0) {
			// Printing the values at every step
			System.out.println("\nstep:"
					+ (M.length() - count + 1));
			A = A.substring(1) + Q.charAt(0);
			// Taking complement and adding it to A 
			// Indirectly we are subtracting(A-M)
			String comp_M = complement(M);
			A = add(A, comp_M);
			// Left shift,assigning LSB of Q to MSB of A.
			System.out.print("Left Shift and Subtract: ");
			System.out.println(" A:" + A);
			System.out.print(
					"A:" + A + " Q:" + Q.substring(1) + "_");
			if (A.charAt(0) == '1') {
				// Unsuccessful and Quotient bit will be zero
				Q = Q.substring(1) + '0';
				System.out.println(" -Unsuccessful");
				// Restoration is required for A
				A = add(A, M);
				System.out.println("A:" + A + " Q:" + Q
						+ " -Restoration");
			}
			else {
				// Quotient bit will be 1
				Q = Q.substring(1) + '1';
				System.out.println(" Successful");
				// No restoration
				System.out.println("A:" + A + " Q:" + Q
						+ " -No Restoration");
			}
			count--;
		}
		// Final quotient and remainder of the 
		// given dividend and divisor
		System.out.println("\nQuotient(Q):" + Q
				+ " Remainder(A):" + A);
	}

	public static void main(String[] args)
	{
		String dividend = "0110";
		String divisor = "0100";
		String accumulator
				= new String(new char[dividend.length()])
				.replace("\0", "0");


		restoringDivision(dividend, divisor,
				accumulator);
	}
}
