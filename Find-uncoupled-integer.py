'''
Find the only uncoupled integer in an array.

Problem Statement
Write a program that, given a list of integers as an argument to STDIN

n1, n2, n3, ..
Prints out the only uncoupled (unpaired) integer in the list to STDOUT.

Example 1:

Given the input

1, 2, 3, 1, 2
your program should output:

3
Example 2:

Given the input

1, 2, 3, 4, 5, 99, 1, 2, 3, 4, 5
your program should output:

99
Hints
It is possible to solve this with

Time: O(n) and Space: O(1)
'''
#Solution uses bitwise operation of XOR to solve in O(n) time and O(1) space.
inputStr = input()
inputArr = inputStr.split(", ")
#print(inputArr)
list = [int(i) for i in inputArr]
#print(list)
integer = list[0]
for item in range(1, len(list)):
	integer = integer ^ list[item]

print(integer)
