# Filename gol.py
# Alana Robinson
# CSCI 77800 Fall 2022
# collaborators: Patti Elfers
# consulted GeekforGeeks and StackOverflow and levelup.gitconnected.com

# create the board
def firstBoard(rows, cols, array):
    myList = [[0]*cols for i in range(rows)]
    for i in myList:
        i.append(-1)
        i.insert(0,-1)
    myList.insert(0,[-1]* (cols+2))
    myList.append([-1]* (cols+2))

   #user input asking how many rows and columns
    while True:
        rows = input("Enter the row or 'q': ")
        if rows == 'q':
            break
        cols = input("Enter the column: ")
        print()
        myList[int(rows)][int(cols)] = 1
    return myList

#defines the rows and colunms
def nextGen(cols, rows, cur, nxt):
    for i in range(1,rows-1):
        for j in range(1,cols-1):
            nxt[i][j] = processNeighbours(i, j, cur)

#create array
def processNeighbours(x, y, array):
    nCount = 0
    for j in range(y-1,y+2):
        for i in range(x-1,x+2):
            if not(i == x and j == y):
                if array[i][j] != -1:
                    nCount += array[i][j]
    if array[x][y] == 1 and nCount < 2:
        return 0
    if array[x][y] == 1 and nCount > 3:
        return 0
    if array[x][y] == 0 and nCount == 3:
        return 1
    else:
        return array[x][y]

#draws the board and prints it
def printBoard(cols, rows, array):
    for i in range(rows+2):
        for j in range(cols+2):
            if array[i][j] == -1:
                print("#", end=" ")
            elif array[i][j] == 1:
                print(".", end=" ")
            else:
                print(" ", end=" ")
        print()

#user input to create the board
def main():
    rows = int(input("Please enter the number of rows: "))
    cols = int(input("Please enter the number of columns: "))
    myList = []
    newList = []
    myList = firstBoard(rows, cols, myList)
    newList = myList

    print()

 #user input that runs the iterations
    generations = int(input("How many iterations should I run? "))+1
    for gens in range(generations):
        printBoard(cols, rows, myList)
        nextGen(cols, rows, myList, newList)
        myList, newList = newList, myList

main()

