// Last updated: 7/14/2026, 10:53:28 PM
1class Solution {
2    public List<List<Integer>> combinationSum(int[] candidates, int target) {
3        List<List<Integer>> result = new ArrayList<>();
4        backtrack(candidates, target, 0, new ArrayList<>(), result);
5        return result;
6    }
7
8    private void backtrack(int[] candidates, int target, int start,
9                           List<Integer> current, List<List<Integer>> result) {
10
11        if (target == 0) {
12            result.add(new ArrayList<>(current));
13            return;
14        }
15
16        if (target < 0) {
17            return;
18        }
19
20        for (int i = start; i < candidates.length; i++) {
21            current.add(candidates[i]);
22
23            // Same index because we can reuse the same number
24            backtrack(candidates, target - candidates[i], i, current, result);
25
26            // Backtrack
27            current.remove(current.size() - 1);
28        }
29    }
30}