#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'timeInWords' function below.
#
# The function is expected to return a STRING.
# The function accepts following parameters:
#  1. INTEGER h
#  2. INTEGER m
#

def timeInWords(h, m):
    # Mapping numbers to words
    num_to_words = {
        1: "one", 2: "two", 3: "three", 4: "four", 
        5: "five", 6: "six", 7: "seven", 8: "eight", 
        9: "nine", 10: "ten", 11: "eleven", 12: "twelve", 
        13: "thirteen", 14: "fourteen", 15: "quarter", 
        16: "sixteen", 17: "seventeen", 18: "eighteen", 
        19: "nineteen", 20: "twenty", 21: "twenty one", 
        22: "twenty two", 23: "twenty three", 24: "twenty four", 
        25: "twenty five", 26: "twenty six", 27: "twenty seven", 
        28: "twenty eight", 29: "twenty nine", 30: "half"
    }

    if m == 0:
        return f"{num_to_words[h]} o' clock"
    elif 1 <= m <= 30:
        if m == 1:
            return f"one minute past {num_to_words[h]}"
        elif m == 15 or m == 30:
            return f"{num_to_words[m]} past {num_to_words[h]}"
        else:
            return f"{num_to_words[m]} minutes past {num_to_words[h]}"
    else:  # 31 <= m < 60
        minutes_to_next_hour = 60 - m
        next_hour = h + 1 if h < 12 else 1
        if minutes_to_next_hour == 1:
            return f"one minute to {num_to_words[next_hour]}"
        elif minutes_to_next_hour == 15:
            return f"quarter to {num_to_words[next_hour]}"
        else:
            return f"{num_to_words[minutes_to_next_hour]} minutes to {num_to_words[next_hour]}"

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    h = int(input().strip())
    m = int(input().strip())

    result = timeInWords(h, m)

    fptr.write(result + '\n')
    fptr.close()
