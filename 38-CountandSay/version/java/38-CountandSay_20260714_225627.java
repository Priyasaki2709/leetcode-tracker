// Last updated: 7/14/2026, 10:56:27 PM
1class Solution {
2    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
3
4        List<List<Integer>> result = new ArrayList<>();
5        Arrays.sort(candidates);
6
7        backtrack(candidates, target, 0, new ArrayList<>(), result);
8
9        return result;
10    }
11
12    private void backtrack(int[] candidates, int target, int start,
13                           List<Integer> current, List<List<Integer>> result) {
14
15        if (target == 0) {
16            result.add(new ArrayList<>(current));
17            return;
18        }
19
20        if (target < 0) {
21            return;
22        }
23
24        for (int i = start; i < candidates.length; i++) {
25
26            if (i > start && candidates[i] == candidates[i - 1]) {
27                continue;
28            }
29
30            current.add(candidates[i]);
31
32            backtrack(candidates, target - candidates[i], i + 1, current, result);
33
34            current.remove(current.size() - 1);
35        }
36    }
37}