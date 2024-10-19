#!/bin/python3

import math
import os
import random
import re
import sys
from collections import Counter  # Ensure Counter is imported

#
# Complete the 'missingNumbers' function below.
#
# The function is expected to return an INTEGER_ARRAY.
# The function accepts following parameters:
#  1. INTEGER_ARRAY arr
#  2. INTEGER_ARRAY brr
#

def missingNumbers(arr, brr):
    # Count frequencies of both arrays
    arr_count = Counter(arr)
    brr_count = Counter(brr)
    
    # Find numbers where frequency in brr is greater than in arr
    missing = []
    for num in brr_count:
        if brr_count[num] > arr_count.get(num, 0):
            missing.append(num)
    
    # Return the missing numbers sorted
    return sorted(missing)

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())  # Size of the arr array
    arr = list(map(int, input().rstrip().split()))  # arr array

    m = int(input().strip())  # Size of the brr array
    brr = list(map(int, input().rstrip().split()))  # brr array

    result = missingNumbers(arr, brr)

    fptr.write(' '.join(map(str, result)) + '\n')
    fptr.close()
