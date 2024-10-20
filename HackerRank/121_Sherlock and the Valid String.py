#!/bin/python3

import math
import os
import random
import re
import sys
from collections import Counter
#
# Complete the 'isValid' function below.
#
# The function is expected to return a STRING.
# The function accepts STRING s as parameter.
#

def isValid(s):
    # Step 1: Count the frequency of each character in the string
    char_count = Counter(s)
    
    # Step 2: Count how many times each frequency occurs
    freq_count = Counter(char_count.values())
    
    # Step 3: Check the validity conditions
    if len(freq_count) == 1:
        # All characters have the same frequency
        return "YES"
    elif len(freq_count) == 2:
        # There are two different frequencies
        freq_list = list(freq_count.items())  # Get the (frequency, count) pairs
        
        # Case 1: One frequency occurs exactly once and it is 1 (we can remove one character)
        if (1 in freq_count and freq_count[1] == 1):
            return "YES"
        # Case 2: One frequency is higher than the other by exactly 1 and it occurs only once
        # Example: {2: 1, 3: 4} -> We can reduce the frequency of the character with count 3
        if (abs(freq_list[0][0] - freq_list[1][0]) == 1 and
            (freq_list[0][1] == 1 or freq_list[1][1] == 1)):
            return "YES"
    
    # If neither condition holds, return "NO"
    return "NO"

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    result = isValid(s)

    fptr.write(result + '\n')

    fptr.close()
