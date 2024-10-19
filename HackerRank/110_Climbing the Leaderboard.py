#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'climbingLeaderboard' function below.
#
# The function is expected to return an INTEGER_ARRAY.
# The function accepts following parameters:
#  1. INTEGER_ARRAY ranked
#  2. INTEGER_ARRAY player
#

def climbingLeaderboard(ranked, player):
    # Create a list of unique scores in descending order
    unique_ranks = sorted(set(ranked), reverse=True)
    
    player_ranks = []
    current_rank_index = len(unique_ranks) - 1  # Start from the lowest rank

    for score in player:
        # Move up the ranks until we find a score higher than the player's score
        while current_rank_index >= 0 and score >= unique_ranks[current_rank_index]:
            current_rank_index -= 1
        # The rank of the player's score is current_rank_index + 2
        player_ranks.append(current_rank_index + 2)

    return player_ranks

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    ranked_count = int(input().strip())
    ranked = list(map(int, input().rstrip().split()))

    player_count = int(input().strip())
    player = list(map(int, input().rstrip().split()))

    result = climbingLeaderboard(ranked, player)

    fptr.write('\n'.join(map(str, result)))
    fptr.write('\n')

    fptr.close()
