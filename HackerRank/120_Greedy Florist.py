#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the getMinimumCost function below.
def getMinimumCost(k, c):
    # Sort the flower prices in descending order
    c.sort(reverse=True)
    
    total_cost = 0
    # For each flower, calculate its cost based on how many the current person has already bought
    for i in range(len(c)):
        # i // k gives the number of flowers already bought by this person
        total_cost += (i // k + 1) * c[i]
    
    return total_cost

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    nk = input().split()

    n = int(nk[0])

    k = int(nk[1])

    c = list(map(int, input().rstrip().split()))

    minimumCost = getMinimumCost(k, c)

    fptr.write(str(minimumCost) + '\n')

    fptr.close()
