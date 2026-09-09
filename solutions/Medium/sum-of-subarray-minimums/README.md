# Sum of Subarray Minimums

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-ffb800?style=flat-square)

**LeetCode Link:** [Sum of Subarray Minimums](https://leetcode.com/problems/sum-of-subarray-minimums/)

---

## Problem Description

_Source: LeetCode_

Given an array of integers arr, find the sum of `min(b)`, where `b` ranges over every (contiguous) subarray of `arr`. Since the answer may be large, return the answer **modulo** `109 + 7`.

**Example 1:**

```text
**Input:** arr = [3,1,2,4]
**Output:** 17
**Explanation:**
Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
Sum is 17.

```

**Example 2:**

```text
**Input:** arr = [11,81,94,43,3]
**Output:** 444

```

**Constraints:**

- `1 <= arr.length <= 3 * 104`

- `1 <= arr[i] <= 3 * 104`

