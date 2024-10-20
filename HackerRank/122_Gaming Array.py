#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'gamingArray' function below.
#
# The function is expected to return a STRING.
# The function accepts INTEGER_ARRAY arr as parameter.
#

def gamingArray(arr):
    # Initialize variables
    max_value = -1  # To keep track of the maximum element seen so far
    moves = 0  # Count how many moves will be made
    
    # Iterate over the array
    for num in arr:
        if num > max_value:  # If we found a new maximum
            max_value = num
            moves += 1  # Increment the moves counter
    
    # Determine the winner based on the number of moves
    if moves % 2 == 0:
        return "ANDY"
    else:
        return "BOB"

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    g = int(input().strip())

    for g_itr in range(g):
        arr_count = int(input().strip())

        arr = list(map(int, input().rstrip().split()))

        result = gamingArray(arr)

        fptr.write(result + '\n')

    fptr.close()
