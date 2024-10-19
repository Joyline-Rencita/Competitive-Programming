#!/bin/python3

import math
import os
import random
import re
import sys

def formingMagicSquare(s):
    # All possible 3x3 magic squares as 2D lists
    magic_squares = [
        [[8, 1, 6], [3, 5, 7], [4, 9, 2]],
        [[6, 1, 8], [7, 5, 3], [2, 9, 4]],
        [[4, 9, 2], [3, 5, 7], [8, 1, 6]],
        [[2, 9, 4], [7, 5, 3], [6, 1, 8]],
        [[8, 3, 4], [1, 5, 9], [6, 7, 2]],
        [[4, 3, 8], [9, 5, 1], [2, 7, 6]],
        [[6, 7, 2], [1, 5, 9], [8, 3, 4]],
        [[2, 7, 6], [9, 5, 1], [4, 3, 8]],
    ]
    
    # Initialize the minimum cost to a large number
    min_cost = float('inf')
    
    # Compare the input square with each magic square
    for magic in magic_squares:
        cost = 0
        # Calculate the cost to convert s to the current magic square
        for i in range(3):
            for j in range(3):
                cost += abs(s[i][j] - magic[i][j])
        
        # Update the minimum cost
        min_cost = min(min_cost, cost)
    
    return min_cost

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')
    
    s = []
    for _ in range(3):
        s.append(list(map(int, input().rstrip().split())))
    
    result = formingMagicSquare(s)
    
    fptr.write(str(result) + '\n')
    fptr.close()
