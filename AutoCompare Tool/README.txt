to run open CMD in path and copy paste the below line:
java -jar CALC.jar

what is this program?:
This is a small java tool that takes two integer number lists and compares them. It places the unique values in the
file called "Unique.txt" and categorizes the unique integers according to which list  they belong to(based on list name that is inputted list name in input file).
This code was written to automate a redundant work task. Complexity is O(n), because it uses Hash map.
Each branch will hold a different Complexity.


write input list format as below in the files named "input List1.txt" and "input List2.txt" :

listname
,1,2,3,


Note:
	- values to be compared have to be integers and can be several lines long
	- the number list must start and end with this character ','