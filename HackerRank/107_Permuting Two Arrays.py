#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'twoArrays' function below.
#
# The function is expected to return a STRING.
# The function accepts following parameters:
#  1. INTEGER k
#  2. INTEGER_ARRAY A
#  3. INTEGER_ARRAY B
#

def twoArrays(k, A, B):
    # Sort A in ascending order
    A.sort()
    
    # Sort B in descending order
    B.sort(reverse=True)
    
    # Check if for every i, A[i] + B[i] >= k
    for i in range(len(A)):
        if A[i] + B[i] < k:
            return "NO"
    
    return "YES"

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    q = int(input().strip())  # Number of queries

    for q_itr in range(q):
        first_multiple_input = input().rstrip().split()

        n = int(first_multiple_input[0])  # Size of the arrays
        k = int(first_multiple_input[1])  # Threshold value

        A = list(map(int, input().rstrip().split()))  # Array A
        B = list(map(int, input().rstrip().split()))  # Array B

        result = twoArrays(k, A, B)

        fptr.write(result + '\n')

    fptr.close()

