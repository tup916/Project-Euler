'''For this question, you will parse a string to determine if it contains only "balanced delimiters."

A balanced delimiter starts with an opening character ((, [, {), ends with a matching closing character (), ], } respectively), and has only other matching delimiters in between. A balanced delimiter may contain any number of balanced delimiters.

Examples
The following are examples of balanced delimiter strings:

()[]{}
([{}])
([]{})
The following are examples of invalid strings:

([)]
([]
[])
([})
Input is provided as a single string. Your output should be True or False according to whether the string is balanced. For example:

Input:

([{}])
Output:

True
Input Format and Restrictions
Each test case will consist of a string only containing the characters ()[]{}. The length of the string will not exceed 2KB.

Things to think about
How will you keep track of previous delimiters?
How will you determine if the next character is valid?
When you reach the end of the string, how do you know if it is balanced?
'''
inp = input()
#used as a stack
listInput = []
for i in inp:
	listInput.append(i)
#print(listInput)
Stack = []
counter = 0
while len(listInput) != counter:
	if listInput[counter] == '(':
		Stack.append(')') 
	elif listInput[counter] == '{':
		Stack.append('}') 
	elif listInput[counter] == '[':
		Stack.append(']') 
	elif listInput[counter] == Stack[-1]:
		del Stack[-1]
	elif listInput[counter] != Stack[-1]:
		break
	else:
		print("Not sure what's up")
	counter +=1
if len(Stack) == 0:
	print("True")
else:
	print("False")
