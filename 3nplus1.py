'''
Pick a positive integer n. If it is odd, multiply it by three and then add one. Otherwise (if it is even), divide it by two. The positive integer obtained is the new n, and this procedure is repeated.

It is believed that n will eventually become 1 (this is called the Collatz conjecture.) Computers have checked that any value of n less than 5×1018 does, indeed, eventually become 1 if this procedure is applied enough times.

You will be given the value of n. Determine how many times this procedure must be applied before n becomes 1.

Input

The initial value of n.
Output

The number of operations we have to perform on n before it becomes 1.
Sample Input

7
Sample Output

16
Explanation

n will go through these steps:
7 22 11 34 17 52 26 13 40 20 10 5 16 8 4 2 1
Constraints

Any value of n, initial or intermediate, will be less than 231

'''

def collatz(n):
	if n==1:
	    return 0;
	if n%2 == 0:
	    return 1 + collatz(n/2)
	else:
		return 1 + collatz(3*n+1)

Num = input();
print(collatz(Num))
