what is this program?:
This is a small java tool that takest two integer number lists and compares them. It places the unique values in the
file called "Unique.txt" and chategorizes the unique integers according to which list  they belong to(based on list name thet is inputed list name in input file).
This code was written to automate a redundant work task. Complexity is O(n^2), because it uses built Contains for ArrayList.
Each branch will hold a different Complexity.


write input list format as below in the files named "input List1.txt" and "input List2.txt" :

listname
,1,2,3,


Note:
	- values to be compared have to be integers and can be several lines long
	- the number list must start and end with this character ','